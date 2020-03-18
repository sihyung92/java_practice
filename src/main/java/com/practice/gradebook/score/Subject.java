package com.practice.gradebook.score;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Subject {
    KOR("국어"),
    ENG("영어"),
    MATH("수학");

    public static final String NOT_EXIST_SUBJECT_MSG = "없는 과목명입니다.";
    static Map<String, Subject> subjectList = new HashMap<>();

    static {
        subjectList = Stream.of(values()).collect(Collectors.toMap(subject -> subject.getNameInKorean(), Function.identity()));
    }

    String nameInKorean;

    Subject(String nameInKorean) {
        this.nameInKorean = nameInKorean;
    }

    private String getNameInKorean() {
        return this.nameInKorean;
    }

    public Subject of(String nameInKorean) {
        if (!subjectList.containsKey(nameInKorean)) {
            throw new IllegalArgumentException(NOT_EXIST_SUBJECT_MSG);
        }
        return subjectList.get(nameInKorean);
    }
}
