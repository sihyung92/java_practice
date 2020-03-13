package com.practice.gradebook.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class ScoreTest {
    @DisplayName("점수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"100:100:100:100,100,100", "50:60:70:50,60,70", "35:45:77:35,45,77"}, delimiter = ':')
    void 점수_입력_테스트(int kor, int eng, int math, String expectedResult) {
        Score score = new Score(kor, eng, math);
        Map<Subject, Integer> scoreMap = score.showPersonalScores();

        List<Subject> subjects = new ArrayList<>(scoreMap.keySet());
        subjects.sort(Comparator.comparingInt(Enum::ordinal));
        String splitScores = subjects.stream()
                .map(scoreMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        assertThat(splitScores).isEqualTo(expectedResult);
    }

    @DisplayName("점수 변경 테스트")
    @ParameterizedTest
    @CsvSource(value = {"100:100:100:50:100,100,50"}, delimiter = ':')
    void 점수_변경_테스트(int kor, int eng, int math, int modifiedMath, String expectedResult) {
        Score score = new Score(kor, eng, math);
        score.modifyScore(Subject.MATH, modifiedMath);
        Map<Subject, Integer> scoreMap = score.showPersonalScores();

        List<Subject> subjects = new ArrayList<>(scoreMap.keySet());
        subjects.sort(Comparator.comparingInt(Enum::ordinal));
        String splitScores = subjects.stream()
                .map(scoreMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        assertThat(splitScores).isEqualTo(expectedResult);
    }
}