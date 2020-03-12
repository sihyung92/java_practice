package com.practice.gradebook.student;

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
        this.studentID = Integer.parseInt(""+gradeNumber+classNumber+personalNumber);
    }

    public void setScore(Score score){
        this.score = score;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public int getStudentID(){
        return studentID;
    }
}
