package com.practice.gradebook.score;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Score {
    Map<Subject, Integer> score = new HashMap<>();

    public Score(int kor, int eng, int math) {
        score.put(Subject.KOR, kor);
        score.put(Subject.ENG, eng);
        score.put(Subject.MATH, math);
    }

    public Score(Map<Subject, Integer> score) {
        score.putAll(score);
    }

    public String calculateAverage() {
        return new DecimalFormat("0.00").format(score.values().stream().mapToInt(Integer::intValue).average().getAsDouble());
    }

    public String calculateSum() {
        return String.valueOf(score.values().stream().mapToInt(Integer::intValue).sum());
    }

    public Score modifyScore(Subject subject, int score) {
        this.score.put(subject, score);
        return new Score(this.score
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public Map<Subject, Integer> createPersonalScores() {
        return score.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
