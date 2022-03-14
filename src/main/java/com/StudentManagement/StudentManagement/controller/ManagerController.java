package com.StudentManagement.StudentManagement.controller;

import com.StudentManagement.StudentManagement.model.Manager;
import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.repository.ILessonRepository;
import com.StudentManagement.StudentManagement.repository.IStudentInfoRepository;
import com.StudentManagement.StudentManagement.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/management")
@RequiredArgsConstructor
public class ManagerController {

    private final IManagerService managerService;

    private final IStudentService studentService;

    private final ITeacherService teacherService;

    private final IStudentInfoRepository infoRepository;

    private final ILessonRepository lessonRepository;

    private static Student student;

    @GetMapping(value = "/getManagementPage")
    public String managementHomePage(Model model, HttpServletResponse response, HttpServletRequest request) {
        try {
            Manager manager=(Manager) request.getSession().getAttribute("admin");
            if (manager!=null){
                Cookie cookie=new Cookie("UserInfo",manager.getName());
                cookie.setMaxAge(1*24*60*60);
                cookie.setSecure(false);
                cookie.setHttpOnly(false);
                response.addCookie(cookie);

                Cookie cookie2=new Cookie("Role","Manager");
                cookie2.setMaxAge(1*24*60*60);
                cookie2.setSecure(false);
                cookie2.setHttpOnly(false);
                response.addCookie(cookie2);

                List<Student>studentList=studentService.getAllStudent();
                studentList=studentService.getAllStudent();
                model.addAttribute("studentList",studentList);

                return "managementStudentCreate";
            }else {
                return "redirect:/login/Authorization";
            }
        }catch (Exception e){
            return "redirect:/management/getManagementPage";
        }
    }
    
}
