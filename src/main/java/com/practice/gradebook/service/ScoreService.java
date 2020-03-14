package com.practice.gradebook.service;

import com.practice.gradebook.score.Score;
import com.practice.gradebook.score.Subject;
import com.practice.gradebook.score.TotalScore;
import com.practice.gradebook.student.Student;

import java.util.Arrays;

public class ScoreService {
    private static final String DELIMETER = ",";
    private static final String WRONG_NUMBER_RANGE_MESSAGE = "0 에서 100 사이의 값을 입력해주세요.";
    public static final String WRONG_NUMBER_TYPE_MESSAGE = "숫자 입력 란에는 숫자를 입력해주세요.";
    public static final String WRONG_FORMAT_MESSAGE = "양식에 맞게 입력해주세요.";
    private static final int INPUT_SCORE_ARRAY_LENGTH = 4;

    private static final int MAX_SCORE = 100;
    private static final int MIN_SCORE = 0;
    private static final int KOR_INDEX = 0;
    private static final int ENG_INDEX = 1;
    private static final int MATH_INDEX = 2;

    public static void insertScore(Student student, String input) {
        int[] scores = inputToScoreArray(input);
        Score score = new Score(scores[KOR_INDEX], scores[ENG_INDEX], scores[MATH_INDEX]);
        TotalScore.add(student, score);
    }

    public static void modifyAllScore(Student student, String input) {
        insertScore(student, input);
    }

    public static void modifySubjectScore(Student student, String input, Subject subject) {
        int modifiedScore = inputToOneScore(input);
        TotalScore.findScore(student).modifyScore(subject, modifiedScore);
    }

    private static int[] inputToScoreArray(String input) {
        String[] separatedString = input.split(DELIMETER);
        return trimAndValidate(separatedString);
    }

    private static int inputToOneScore(String input) {
        return trimAndValidate(input);
    }

    private static int[] trimAndValidate(String[] separatedString) {
        validateInput(separatedString);
        return Arrays.stream(separatedString)
                .map(String::trim)
                .mapToInt(ScoreService::parseInt)
                .map(ScoreService::validateProperRange)
                .toArray();
    }

    private static int trimAndValidate(String input) {
        return validateProperRange(parseInt(input.trim()));
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(WRONG_NUMBER_TYPE_MESSAGE);
        }
    }

    private static void validateInput(String[] temp) {
        if (temp.length != INPUT_SCORE_ARRAY_LENGTH) {
            throw new IllegalArgumentException(WRONG_FORMAT_MESSAGE);
        }
    }

    public static void printTotalScore() {

    }

    public static int validateProperRange(int score) {
        if (score > MAX_SCORE || score < MIN_SCORE) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MESSAGE);
        }
        return score;
    }

}
