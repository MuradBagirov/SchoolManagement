package com.StudentManagement.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoCreateDto {

    public Long id;

    public int lectureNoteOne;

    public int lectureNoteTwo;

    public int lectureNoteThree;

    public String rightOfAbsence;



}
