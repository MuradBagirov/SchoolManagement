package com.StudentManagement.StudentManagement.controller;

import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.model.StudentInfo;
import com.StudentManagement.StudentManagement.service.IStudentInfoService;
import com.StudentManagement.StudentManagement.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;
    private final IStudentInfoService studentInfoService;


    @GetMapping("/getStudent")
    public String getStudent(Model model, HttpServletRequest request, HttpServletResponse response) {
        Student student = (Student) request.getSession().getAttribute("student");
        if (student != null) {
            String name = student.getName() + " / " + student.getSurName();
            Cookie cookie = new Cookie("UserInfo", String.valueOf(name));
            cookie.setMaxAge(1 * 24 * 60 * 60);
            cookie.setSecure(false);
            cookie.setHttpOnly(false);
            response.addCookie(cookie);

            Cookie cookie2 = new Cookie("Role", "Student");
            cookie2.setMaxAge(1 * 24 * 60 * 60);
            cookie.setSecure(false);
            cookie.setHttpOnly(false);
            response.addCookie(cookie2);

            response.setContentType("text/html;charset=UTG-8");
            Student student1 = studentService.getStudentById(student.getId());
            model.addAttribute("student", student1);
            return "studentShow";
        } else {
            return "redirect:/login/Authorization";
        }

    }

    @GetMapping("/getStudentInfo/{student_id}")
    public String getStudentInfo(@PathVariable("student_id") Long student_id, Model model, HttpServletRequest request) {
        Student studentSession= (Student) request.getSession().getAttribute("student");
        if (studentSession!=null){
            if (student_id==studentSession.getId()){
                Student student =studentService.getStudentById(studentSession.getId());
                List<StudentInfo>studentInfoList=studentInfoService.getStudentInfoByStudentId(studentSession.getId());
                model.addAttribute("studentInfoList",studentInfoList);
                return "studentInfoShow";
            }
            return "redirect:/student/getStudentInfo";
        }else {
           return  "redirect:/login/Authorization";
        }

    }
}
