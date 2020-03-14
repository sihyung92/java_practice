package com.practice.gradebook.score;

import com.practice.gradebook.student.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalScore {
    private static Map<Student, Score> totalScore = new HashMap<>();

    public static Map<Student, Score> showAllScores() {
        return totalScore.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    public static void add(Student student, int kor, int eng, int math) {
        totalScore.put(student, new Score(kor, eng, math));
    }

    public static void add(Student student, Score score) {
        totalScore.put(student, score);
    }

    public static Score findScore(Student student) {
        return totalScore.get(student);
    }
}
