package com.StudentManagement.StudentManagement.controller;

import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.model.StudentInfo;
import com.StudentManagement.StudentManagement.model.Teacher;
import com.StudentManagement.StudentManagement.service.ILessonService;
import com.StudentManagement.StudentManagement.service.IStudentInfoService;
import com.StudentManagement.StudentManagement.service.IStudentService;
import com.StudentManagement.StudentManagement.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private static Long Student_Id;

    private final ILessonService lessonService;

    private final IStudentInfoService studentInfoService;

    private final ITeacherService teacherService;

    private final IStudentService studentService;


    public String getTeacher(Model model, HttpServletRequest request, HttpServletResponse response) {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (teacher != null) {
            String name = teacher.getName();

            Cookie cookie = new Cookie("UserInfo", String.valueOf(name));
            cookie.setMaxAge(1 * 24 * 60 * 60);
            cookie.setSecure(false);
            cookie.setHttpOnly(false);
            response.addCookie(cookie);

            Cookie cookie2 = new Cookie("Role", "Teacher");
            cookie2.setMaxAge(1 * 24 * 60 * 60);
            cookie2.setHttpOnly(false);
            cookie2.setSecure(false);
            response.addCookie(cookie2);

            List<StudentInfo> list = studentInfoService.getAllStudentInfo().stream().
                    filter(x -> x.getTeacherId() == (teacher.getId()))
                    .collect(Collectors.toList());

            List<Student> studentList = new ArrayList<>();
            for (StudentInfo studentInfo : list) {
                if (teacher.getId() == studentInfo.getId()) {
                    studentList.add(studentService.getStudentById(studentInfo.getStudent().getId()));
                }
            }
            model.addAttribute("studentlist", studentList);
            return "teacherShow";
        } else {
            return "redirect:/login/Authorization";
        }
    }

    @GetMapping("/getStudentInfo/{student_id}")
    public String getStudentInfo(@PathVariable("student_id") Long student_id, Model model, HttpServletRequest request) {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (teacher != null) {
            Student_Id = student_id;
            List<StudentInfo> list = studentInfoService.getAllStudentInfo().stream().
                    filter(x -> x.getTeacherId() == (teacher.getId()))
                    .collect(Collectors.toList());
            List<Student> studentList = new ArrayList<>();
            for (StudentInfo studentInfo : list) {
                if (teacher.getId() == studentInfo.getTeacherId()) {
                    studentList.add(studentService.getStudentById(studentInfo.getStudent().getId()));
                }
            }
            Student student = studentList.stream().filter(x -> x.getId() == student_id)
                    .collect(Collectors.toList())
                    .stream().findFirst().get();

            Stream<StudentInfo> infoList = studentInfoService.getStudentInfoByStudentId(student.getId())
                    .stream()
                    .filter(x -> x.getTeacherId() == teacher.getId());
            model.addAttribute("infolist", infoList);
            return "teacherStudentInfoShow";
        } else {
            return "redirect:/login/Authorization";
        }
    }

    @PostMapping("/postStudentInfoCreate")
    public String postStudentInfoCreate(@ModelAttribute("studentInfoModel") StudentInfo studentInfo, Model model, HttpServletRequest request) {
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            if (teacher != null) {
                if (studentInfo == null) {
                    return "redirect:/teacher/getTeacher";
                }
                studentInfo.setTeacherId(teacher.getId().intValue());
                studentInfo.setLessonName(lessonService.lessonById(teacher.getLesson().getId()).getLessonName());
                studentInfo.setStudent(studentService.getStudentById(Student_Id));
                studentInfoService.saveStudentInfo(studentInfo);
                return "teacherStudentInfoShow";
            } else {
                return "redirect:/login/Authorization";
            }

        } catch (Exception e) {
            return "redirect:/teacher/getTeacher";
        }
    }

    @PostMapping("/postStudentInfoUpdate")
    public String postStudentInfoUpdate(@ModelAttribute("student_info_id") StudentInfo studentInfo, Model model, HttpServletRequest request) {
        try {


            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            if (teacher != null) {
                if (studentInfo == null) {
                    return "redirect:/teacher/getTeacher";
                }
                studentInfo.setStudent(studentService.getStudentById(Student_Id));
                studentInfoService.saveStudentInfo(studentInfo);
                return "redirect:/teacher/getStudentInfoUpdate/" + studentInfo.getId();
            } else {
                return "redirect:/login/Authorization";
            }
        } catch (Exception e) {
            return "redirect:/teacher/getTeacher";
        }
    }
}
