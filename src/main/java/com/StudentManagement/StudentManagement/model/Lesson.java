package com.StudentManagement.StudentManagement.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lessonName;


    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Set<Teacher>teacher=new HashSet<>();
    public Set<Teacher> getTeachers() {
        return teacher;
    }

    public void setTeachers(Set<Teacher> teacher) {
        this.teacher = teacher;
        for (Teacher t : teacher) {
            t.setLesson(this);
        }

    }
}
