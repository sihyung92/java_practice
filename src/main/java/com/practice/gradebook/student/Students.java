package com.practice.gradebook.student;

import java.util.Comparator;
import java.util.TreeSet;

public class Students {
    private static TreeSet<Student> students;

    static {
        students = new TreeSet<>(Comparator.comparingInt(Student::getStudentID));
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
