package com.practice.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveExerciseTest {
    private RecursiveExercise exercise = new RecursiveExercise();

    @DisplayName("n까지의 합")
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5})
    void sum(int n) {
        assertThat(exercise.sum(n)).as(n + "까지의 합").isEqualTo(exercise.sumRecursive(n));
    }

    @DisplayName("n의 거듭 제곱")
    @ParameterizedTest
    @CsvSource(value={"5,2","5,3","3,2","3,3"})
    void square(int n, int square) {
        assertThat(exercise.square(n, square)).as(String.format("%s의 %s승",n,square)).isEqualTo(exercise.squareRecursive(n,square));
    }

    @DisplayName("구구단 테이블")
    @Test
    void multiplyTable() {
        assertThat(exercise.multiplyTable()).isEqualTo(exercise.multiplyTableRecursive(2,""));
    }

    @DisplayName("팩토리얼")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8})
    void factorial(int n) {
        assertThat(exercise.factorial(n)).isEqualTo(exercise.factorialRecursive(n));
    }

    @DisplayName("회문검증")
    @ParameterizedTest
    @ValueSource(strings = {"Do geese see God","Was it a car or a cat I saw","","123454321"})
    void isPalindrome(String str) {
        str = str.toLowerCase();
        str = str.replace(" ","");
        assertThat(exercise.isPalindrome(str)).isTrue();
    }
}