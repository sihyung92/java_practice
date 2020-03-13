package com.practice.gradebook.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudentsTest {

    @DisplayName("학생 중복 검출")
    @Test
    void 학생_중복_테스트() {
        //given
        Student oldStudent = new Student("기존의", 1, 1, 1);
        Student newStudent = new Student("새로운", 1, 1, 1);

        //when
        Students.registStudent(oldStudent);

        //then
        assertThatThrownBy(() -> Students.registStudent(newStudent))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 있는 학번입니다.");
    }

    @DisplayName("학생 생성 테스트")
    @ParameterizedTest
    @MethodSource("studentSources")
    void 학생_생성_테스트(Student student, int result) {
        assertThat(student.getStudentID()).isEqualTo(result);
    }

    @DisplayName("학생 조회 테스트")
    @ParameterizedTest
    @MethodSource("studentSources")
    void 학생_조회_테스트(Student student, int studentID) {
        //given
        //when
        Students.registStudent(student);
        //then
        List<String[]> studentIdAndName = Students.showStudentsIdAndName();
        assertThat(studentIdAndName)
                .contains(new String[]{String.valueOf(studentID), student.getName()});
    }

    static Stream<Arguments> studentSources() {
        return Stream.of(
                Arguments.of(new Student("김자바", 1, 1, 1), 10101),
                Arguments.of(new Student("나자바", 1, 1, 2), 10102),
                Arguments.of(new Student("다자바", 2, 10, 3), 21003),
                Arguments.of(new Student("라자바", 2, 2, 4), 20204),
                Arguments.of(new Student("마자바", 3, 1, 5), 30105));
    }
}