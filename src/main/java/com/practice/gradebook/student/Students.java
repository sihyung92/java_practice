package com.practice.gradebook.student;

import java.util.*;
import java.util.stream.Collectors;

public class Students {
    public static final String ALREADY_EXIST_MESSAGE = "이미 있는 학번입니다. ";
    public static final String ID_NOT_EXIST_MESSAGE = "해당 학번을 가진 학생이 없습니다.";
    private static TreeSet<Student> students;

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

    public static List<Student> list(){
        return new ArrayList<>(students);
    }

    public static Student findStudentByID(int studentID) {
        Optional<Student> target = students.stream().filter(aStudent -> aStudent.matchStudentID(studentID)).findFirst();
        if (target.isPresent()) {
            return target.get();
        }
        throw new IllegalArgumentException(ID_NOT_EXIST_MESSAGE);
    }
}
