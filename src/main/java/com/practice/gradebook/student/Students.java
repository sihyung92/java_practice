package com.practice.gradebook.student;

import com.practice.gradebook.score.TotalScore;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Students {
    public static final String ALREADY_EXIST_MESSAGE = "이미 있는 학번입니다. ";
    private static TreeSet<Student> students;
    private static TotalScore totalScore;

    static {
        students = new TreeSet<>(Comparator.comparingInt(Student::getStudentID));
    }

    public static void registStudent(Student student) {
        if (!students.add(student)) {
            throw new IllegalArgumentException(ALREADY_EXIST_MESSAGE);
        }
    }

    public static List<String[]> showStudentsIdAndName() {
        return students.stream()
                .map(student -> new String[]{String.valueOf(student.getStudentID()), student.getName()})
                .collect(Collectors.toList());
    }
}
