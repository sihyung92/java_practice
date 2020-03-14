package com.practice.gradebook.score;

import com.practice.gradebook.service.ScoreService;
import com.practice.gradebook.student.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    @DisplayName("점수 입력 테스트")
    @ParameterizedTest
    @MethodSource("studentSources")
    void 점수_입력_테스트(Student student, String input, String expectedResult) {
        //given
        ScoreService.insertScore(student, input);
        Map<Subject, Integer> scoreMap = TotalScore.findScore(student).showPersonalScores();

        //when
        List<Subject> subjects = new ArrayList<>(scoreMap.keySet());
        subjects.sort(Comparator.comparingInt(Enum::ordinal));
        String splitScores = subjects.stream()
                .map(scoreMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        //then
        assertThat(splitScores).isEqualTo(expectedResult);
    }

    @DisplayName("점수 변경 테스트")
    @Test
    void 점수_변경_테스트() {
        //given
        Student student = new Student("김자바", 1, 1, 1);
        String input = "100,100,100";
        Subject subject = Subject.KOR;
        String input2 = "50";
        String expectedResult = "50,100,100";

        ScoreService.insertScore(student, input);

        //when
        ScoreService.modifySubjectScore(student, input2, subject);
        Map<Subject, Integer> scoreMap = TotalScore.findScore(student).showPersonalScores();

        List<Subject> subjects = new ArrayList<>(scoreMap.keySet());
        subjects.sort(Comparator.comparingInt(Enum::ordinal));
        String splitScores = subjects.stream()
                .map(scoreMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        //then
        assertThat(splitScores).isEqualTo(expectedResult);
    }

    static Stream<Arguments> studentSources() {
        return Stream.of(
                Arguments.of(new Student("김자바", 1, 1, 1), "100,100,100", "100,100,100"),
                Arguments.of(new Student("나자바", 1, 1, 2), "40,50,60", "40,50,60"));
    }
}