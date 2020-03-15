package com.practice.gradebook.student;

import java.util.*;
import java.util.stream.Collectors;

public class Rank {
    private int classRank;
    private int totalRank;

    public Rank(int classRank, int totalRank) {
        this.classRank = classRank;
        this.totalRank = totalRank;
    }

    public int getClassRank() {
        return classRank;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public static void calculateRank() {
        List<Student> studentList = Students.list();
        Map<Student, Integer> forSaveClassRankMap = new HashMap<>();

        studentList = studentList.stream().filter(x -> Objects.nonNull(x.getScore())).collect(Collectors.toList());

        studentList.sort((o1, o2) -> Comparator.<Student>comparingDouble(x -> x.getScore()
                .calculateAverage())
                .compare(o2, o1));

        ranking(studentList, forSaveClassRankMap);

        studentList.stream().collect(Collectors.groupingBy(x -> "" + x.getGradeNumber() + x.getClassNumber()))
                .values().forEach(x -> ranking(x, forSaveClassRankMap));

    }

    private static void ranking(List<Student> studentList, Map<Student, Integer> forSaveClassRankMap) {
        int prevRank = -1;
        int prevTotal = -1;
        int myRank;
        for (int i = 0; i < studentList.size(); i++) {
            Student aStudent = studentList.get(i);
            int myTotal = studentList.get(i).getScore().calculateSum();

            if (prevTotal == myTotal) {
                myRank = prevRank;
            } else {
                myRank = i + 1;
            }

            prevRank = myRank;
            prevTotal = myTotal;
            Integer value = forSaveClassRankMap.put(aStudent, myRank);
            if (Objects.nonNull(value)) {
                aStudent.setRank(new Rank(value, myRank));
            }
            ;
        }
    }
}
