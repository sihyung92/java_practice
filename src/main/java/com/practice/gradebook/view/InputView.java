package com.practice.gradebook.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    public static final String EMPTY_OR_NULL_MESSAGE = "아무것도 입력되지 않았습니다.";
    public static final String WRONG_NUMBER_TYPE_MESSAGE = "숫자를 입력해주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMenu() {
        return convertToInteger(inputProperString());
    }

    public static String inputStudent() {
        return inputProperString();
    }

    public static String inputScore() {
        return inputProperString();
    }

    public static int inputStudentId() {
        return convertToInteger(inputProperString());
    }

    private static String inputProperString() {
        String input = inputString();
        input = input.trim();
        validateNullOrEmpty(input);
        return input;
    }

    private static String inputString() {
        return scanner.nextLine();
    }
    private static void validateNullOrEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_OR_NULL_MESSAGE);
        }
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(WRONG_NUMBER_TYPE_MESSAGE);
        }
    }
}
