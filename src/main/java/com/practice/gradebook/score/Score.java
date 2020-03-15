package com.practice.gradebook.score;

import java.util.HashMap;
import java.util.Map;
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

    public double calculateAverage() {
        //if return string
//        return new DecimalFormat("0.00").format(score.values().stream().mapToInt(Integer::intValue).average().getAsDouble());
        return Math.round(score.values().stream().mapToInt(Integer::intValue).average().getAsDouble() * 100) / 100.0d;
    }

    public int calculateSum() {
        return score.values().stream().mapToInt(Integer::intValue).sum();
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
