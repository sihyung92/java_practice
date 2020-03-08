package com.practice.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringMethodExerciseTest {

    @DisplayName("패스 쪼개기")
    @Test
    void exercise1Test() {
        //given
        String pullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "c:\\jdk1.8\\work";
        String fileName = "PathSeparateTest.java";

        //when
        Map<String, String> resultMap = StringMethodExercise.exercise1(pullPath);
        //then
        assertThat(resultMap.get("path").equals(path) || resultMap.get(fileName).equals(fileName))
                .as("path == expectedPath || fileName == expectedFileName")
                .isTrue();
    }

    @DisplayName("formatter test")
    @ParameterizedTest
    @MethodSource("exercise2Params")
    void exercise2Test(String target, int length, int align, String expectedResult) {
        assertThat(StringMethodExercise.exercise2(target, length, align)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> exercise2Params() {
        return Stream.of(
                Arguments.of("가나다", 7, 0, "가나다    "),
                Arguments.of("가나다", 7, 1, "  가나다  "),
                Arguments.of("가나다", 7, 2, "    가나다")
        );
    }

    @DisplayName("해당 문자열이 몇번 나오는지 test")
    @ParameterizedTest
    @CsvSource({"가abdddg가qweoora가qssksad가,가,4", "asd,,3"})
    void exercise3Test(String input, String key, int expectedResult) {
        assertThat(StringMethodExercise.exercise3(input, key)).isEqualTo(expectedResult);
    }
}