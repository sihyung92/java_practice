package com.practice.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMethodExercise {
    private static final String delimeter = "\\";

    public static void main(String[] args) {
        beforeEachExercise("exercise1", "패스 쪼개기(문자열 쪼개기)");
        exercise1();
        afterEachExercise();

        beforeEachExercise("exercise2", "formatter 만들기");
        exercise2("가나다", 11, 0);
        exercise2("가나다", 11, 1);
        exercise2("가나다", 11, 2);
        afterEachExercise();

        beforeEachExercise("exercise3", "특정 문자열과 일치하는 갯수 구하기");
        exercise3("가abdddg가qweoora가qssksad가", "가");
        afterEachExercise();
    }

    public static void beforeEachExercise(String exerciseName, String description) {
        System.out.println(exerciseName + "::" + description);
    }

    public static void afterEachExercise() {
        System.out.println("----------------");
    }

    /*
     * 실행 결과 :
     * fullPath:c:\jdk1.8\work\PathSeparateTest.java
     * path:c:\jdk1.8\work
     * fileName:PathSeparateTest.java
     * */
    public static void exercise1() {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        int lastIndex = fullPath.lastIndexOf(delimeter);
        if (lastIndex != fullPath.length()) {
            fileName = fullPath.substring(lastIndex + 1);
        }
        path = fullPath.substring(0, lastIndex);

        System.out.println("fullPath:" + fullPath);
        System.out.println("path:" + path);
        System.out.println("fileName:" + fileName);
    }

    /*
     * 메서드명 : format
     * 기 능 주어진 문자열을 지정된 크기의 문자열로 변환한다 나머지 공간은 공백으로 채운다 : . .
     * 반환타입 : String
     * 매개변수 변환할 문자열 : String str -
     * int length - 변환된 문자열의 길이
     * int alignment - 변환된 문자열의 정렬조건
     * (0: 왼쪽 , 1: 가운데 , 2: 오른쪽)
     */
    public static void exercise2(String str, int length, int alignment) {
        if (str.length() > length) {
            str = str.substring(0, length);
        }
        char[] chars = new char[length];
        Arrays.fill(chars, ' ');
        char[] temp = str.toCharArray();
        int startIndex = 0;
        if (alignment == 0) {
            startIndex = 0;
        }
        if (alignment == 1) {
            startIndex = (chars.length - temp.length) / 2;
        }
        if (alignment == 2) {
            startIndex = chars.length - temp.length;
        }
        for (int i = 0; i < temp.length; i++) {
            chars[startIndex + i] = temp[i];
        }
        System.out.println(chars);
    }

    /*
     * 하나의 긴 문자열 중에서 특정 문자열과 일치하는 문자열의 개수 (source)를 구하는 예제
     * */
    static void exercise3(String src, String key) {
        exercise3(src, key, 0);
    }

    static void exercise3(String src, String key, int pos) {
        int count = 0;
        int index = 0;
        if (key == null || key.length() == 0)
            return;
        while ((index = src.indexOf(key, pos)) != -1) {
            count++;
            pos = index + key.length();
        }
        System.out.println(count);
    }
}
