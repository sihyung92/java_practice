package com.practice.gradebook.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rank {
    private int classRank;
    private int schoolRank;

    public Rank(int classRank, int schoolRank) {
        this.classRank = classRank;
        this.schoolRank = schoolRank;
    }

    public int classRank() {
        return classRank;
    }

    public int schoolRank() {
        return schoolRank;
    }

    public static void calculateRank() {
        List<Student> studentList = Students.list();
        Map<Student, Integer> forSaveSchoolRankMap = new HashMap<>();

        studentList = studentList.stream().filter(Student::hasScore).collect(Collectors.toList());

        studentList.sort((o1, o2) -> (int) (o2.getScoreAverage() * 100 - o1.getScoreAverage() * 100));

        ranking(studentList, forSaveSchoolRankMap);

        studentList.stream().collect(Collectors.groupingBy(x -> "" + x.getGradeNumber() + x.getClassNumber()))
                .values().forEach(x -> {
            System.out.println(x);
            ranking(x, forSaveSchoolRankMap);

        });

    }

    private static void ranking(List<Student> studentList, Map<Student, Integer> forSaveSchoolRankMap) {
        int prevRank = -1;
        int prevTotal = -1;
        int myRank;
        for (int i = 0; i < studentList.size(); i++) {
            Student aStudent = studentList.get(i);
            int myTotal = studentList.get(i).getScoreSum();

            if (prevTotal == myTotal) {
                myRank = prevRank;
            } else {
                myRank = i + 1;
            }

            prevRank = myRank;
            prevTotal = myTotal;
            Integer schoolRank = forSaveSchoolRankMap.get(aStudent);
            System.out.println(aStudent.getStudentID()+"마랭:"+myRank);
            if (Objects.nonNull(schoolRank)) {
                System.out.println(aStudent.getStudentID()+"스랭:"+schoolRank);
                aStudent.setRank(new Rank(myRank, schoolRank));
            }
            forSaveSchoolRankMap.put(aStudent, myRank);
        }
    }
}
