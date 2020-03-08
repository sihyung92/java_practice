package com.practice.lang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringMethodExercise {
    private static final String delimeter = "\\";

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
    public static Map<String, String> exercise1(String fullPath) {
        Map<String, String> resultMap = new HashMap<>();

        int lastIndex = fullPath.lastIndexOf(delimeter);

        if (lastIndex != fullPath.length()) {
            resultMap.put("fileName", fullPath.substring(lastIndex + 1));
        }

        resultMap.put("path", fullPath.substring(0, lastIndex));
        return resultMap;
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
    public static String exercise2(String str, int length, int alignment) {
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
        return new String(chars);
    }

    /*
     * 하나의 긴 문자열 중에서 특정 문자열과 일치하는 문자열의 개수 (source)를 구하는 예제
     * */
    static int exercise3(String src, String key) {
        return exercise3(src, key, 0);
    }

    static int exercise3(String src, String key, int pos) {
        int count = 0;
        int index = 0;
        if (key == null || key.length() == 0) {
            return src.length();
        }
        while ((index = src.indexOf(key, pos)) != -1) {
            count++;
            pos = index + key.length();
        }

        return count;
    }
}
