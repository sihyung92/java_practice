package com.practice.recursive;

import com.sun.javafx.binding.StringFormatter;

public class RecursiveExercise {
    //예제 1, n까지의 합 (for문)
    public int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //예제 1-2, n까지의 합 (재귀식)
    public int sumRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    //예제 2-1, 거듭제곱(for문)
    public int square(int n, int square) {
        int result = 1;
        for (int i = 0; i < square; i++) {
            result *= n;
        }
        return result;
    }

    //예제 2-2, 거듭제곱(재귀식)
    public int squareRecursive(int n, int square) {
        if (square == 0) {
            return 1;
        }
        return n * squareRecursive(n, square - 1);
    }

    //예제 3-1, 구구단(for문)
    public String multiplyTable() {
        StringBuffer gugudan = new StringBuffer();
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                gugudan.append(String.format("%d*%d=%d%n", i, j, i * j));
            }
            gugudan.append("\n");
        }
        return gugudan.toString();
    }

    //예제 3-2, 구구단(재귀식)
    public String multiplyTableRecursive(int frontStart, String gugudan) {
        if (frontStart == 10) {
            return gugudan;
        }

        for (int i = 1; i < 10; i++) {
            gugudan += String.format("%d*%d=%d%n", frontStart, i, frontStart * i);
        }
        gugudan += "\n";

        return multiplyTableRecursive(frontStart + 1, gugudan);
    }

    //예제 4-1, 팩토리얼 (for문)
    public int factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    //예제 4-2, 팩토리얼 (재귀함수)
    public int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //예제 5-1, 회문 검증
    public boolean isPalindrome(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1,str.length()-1));
        }

        return false;
    }
}
