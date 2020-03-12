package com.practice.gradebook.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    public static final String EMPTY_OR_NULL_MESSAGE = "아무것도 입력되지 않았습니다.";

    private static Scanner scanner = new Scanner(System.in);

    public String inputStudent() {
        String input = scanner.nextLine();
        input = input.trim();
        validateNullOrEmpty(input);
        return input;
    }

    private void validateNullOrEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_OR_NULL_MESSAGE);
        }
    }

}
