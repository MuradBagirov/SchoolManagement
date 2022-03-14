package com.StudentManagement.StudentManagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private Long passwordNumber;

    private String phone;

    private String address;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
        for (Student s : students) {
            s.setManager(this);
        }
    }

    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
    private Set<Teacher>teachers=new HashSet<>();


    public Set<Teacher> getTeachers() {
        return teachers;
    }


    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
        for (Teacher t:teachers){
            t.setManager(this);
        }
    }
}
