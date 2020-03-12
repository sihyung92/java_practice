package com.practice.gradebook.student;

import java.util.*;

public class Students {
    public static final String ALREADY_EXIST_MESSAGE = "이미 있는 학번입니다. ";
    private static TreeSet<Student> students;

    static {
        students = new TreeSet<>(Comparator.comparingInt(Student::getStudentID));
    }

    public static void registStudent(Student student) {
        if(!students.add(student)){
            throw new IllegalArgumentException(ALREADY_EXIST_MESSAGE);
        };
    }

    public static Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }


}
