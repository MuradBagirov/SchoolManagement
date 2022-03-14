package com.StudentManagement.StudentManagement.controller;

import com.StudentManagement.StudentManagement.dto.LoginDto;
import com.StudentManagement.StudentManagement.model.Manager;
import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.model.Teacher;
import com.StudentManagement.StudentManagement.service.IManagerService;
import com.StudentManagement.StudentManagement.service.IStudentService;
import com.StudentManagement.StudentManagement.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    private final IStudentService studentService;

    private final ITeacherService teacherService;

    private final IManagerService managerService;

    @GetMapping(value = "/getLogin")
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto) {
        model.addAttribute("login", loginDto);
        return "login";
    }

    @PostMapping(value = "/postLogin")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session, HttpServletResponse response) {

        if (loginDto.getRole().equals("student")) {
            List<Student> studentList = studentService.getAllStudent();
            for (Student student : studentList) {
                if (student.getPasswordNumber().equals(loginDto.getPasswordNo()) && student.getPassword().equals(loginDto.password)) {
                    session.setAttribute("student", student);
                    return "redirect:/student/getStudentPage";
                }
            }
        } else if (loginDto.getRole().equals("teacher")) {
            List<Teacher> teacherList = teacherService.getAllTeacher();
            for (Teacher teacher : teacherList) {
                if (teacher.getPassportNumber().equals(loginDto.getPasswordNo()) && teacher.getPassword().equals(loginDto.getPassword())) {
                    session.setAttribute("teacher", teacher);
                    return "redirect:/teacher/getTeacherPage";
                }
            }
        } else if (loginDto.getRole().equals("admin")) {
            List<Manager> managerList = managerService.getAllManager();
            for (Manager manager : managerList) {
                if (manager.getPasswordNumber().equals(loginDto.getPasswordNo()) && manager.getPassword().equals(loginDto.password)) {
                    session.setAttribute("admin", manager);
                    return "redirect:/management/getManagerPage";
                }
            }
        }
        return "redirect:/login/getLogin";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login/getLogin";
    }

    @GetMapping(value = "/Authorization")
    public String getAuthErrorPage() {
        return "authErrorPage";
    }
}
