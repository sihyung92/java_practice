package com.practice.gradebook.student;

import com.practice.gradebook.score.Score;
import com.practice.gradebook.score.Subject;

import java.util.Objects;

public class Student {
    private String name;
    private int studentID;
    private int gradeNumber;
    private int classNumber;
    private int personalNumber;
    private Score score;
    private Rank rank;

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

    public int getStudentID() {
        return studentID;
    }

    public boolean matchStudentID(int studentID) {
        return this.studentID == studentID;
    }

    public String getName() {
        return name;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void createScore(int kor, int eng, int math){
        this.score = new Score(kor,eng,math);
    }

    public int getSubjectScore(Subject subject){
        return score.of(subject);
    }

    public int getScoreSum(){
        return score.calculateSum();
    }

    public double getScoreAverage(){
        return score.calculateAverage();
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int schoolRank(){
        return rank.schoolRank();
    }

    public int classRank(){
        return rank.classRank();
    }

    public boolean hasRank() {
        return Objects.nonNull(rank);
    }

    public boolean hasScore(){
        return Objects.nonNull(score);
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
        return Objects.hash(name, studentID, gradeNumber, classNumber, personalNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentID=" + studentID +
                ", gradeNumber=" + gradeNumber +
                ", classNumber=" + classNumber +
                ", personalNumber=" + personalNumber +
                '}';
    }
}
