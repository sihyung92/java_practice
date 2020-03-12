package com.practice.gradebook.student;

import java.util.Objects;

public class Student {
    private String name;
    private int studentID;
    private int gradeNumber;
    private int classNumber;
    private int personalNumber;
    private Score score;

    public Student(String name, int gradeNumber, int classNumber, int personalNumber) {
        this.name = name;
        this.gradeNumber = gradeNumber;
        this.classNumber = classNumber;
        this.personalNumber = personalNumber;

        StringBuilder sb = new StringBuilder();
        sb.append(gradeNumber);
        if (classNumber < 10) {
            sb.append(0);
        }
        sb.append(classNumber);

        if (personalNumber < 10) {
            sb.append(0);
        }
        sb.append(personalNumber);

        this.studentID = Integer.parseInt(sb.toString());
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return studentID == that.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentID, gradeNumber, classNumber, personalNumber, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentID=" + studentID +
                ", gradeNumber=" + gradeNumber +
                ", classNumber=" + classNumber +
                ", personalNumber=" + personalNumber +
                ", score=" + score +
                '}';
    }
}
