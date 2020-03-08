package com.practice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarClassExercise {
    public static void main(String[] args) {
        beforeEachExercise("exercise1", "매월 두번째 일요일 날짜 구하기");
        exercise1(2010);
        afterEachExercise();
        beforeEachExercise("exercise2", "두 날짜사이의 월급일 구하기");
        exercise2("2010-01-20", "2010-01-21");
        afterEachExercise();
    }

    private static void beforeEachExercise(String exerciseName, String description) {
        System.out.println(exerciseName + "::" + description);
    }

    private static void afterEachExercise() {
        System.out.println("----------------");
    }

    /*
     * Calendar 클래스와 SimpleDateFormat 클래스를 이용해서 2010년의 매월 두 번째
     * 일요일의 날짜를 출력하시오.
     * */
    private static void exercise1(int year) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월의 F번째 E요일의 날짜는 MM-dd");
        calendar.set(year, 0, 1);
        for (int i = 0; i < 12; i++) {
            //일요일 = 1
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            int secondSunday = 8;
            if (weekday != 1) {
                secondSunday = 16 - weekday;
            }

            calendar.set(Calendar.DAY_OF_MONTH, secondSunday);
            System.out.println(dateFormat.format(calendar.getTime()));

            calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
    }

    /*
     * 어떤 회사의 월급날이 매월 21일이다 두 날짜 사이에 월급날이 몇 번 있었는지 계산해서 반환하는 메서드를 작성하고 테스트 하시오.
     * */
    private static void exercise2(String from, String to) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(dateFormat.parse(from));
            cal2.setTime(dateFormat.parse(to));
            if (cal1.after(cal2)) {
                throw new IllegalArgumentException("나중 시간이 먼저 시간보다 앞설 수 없습니다");
            }
            int monthDiff = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
            int result = monthDiff - 1;
            if (cal1.get(Calendar.DAY_OF_MONTH) <= 21) {
                result++;
            }
            if (cal2.get(Calendar.DAY_OF_MONTH) >= 21) {
                result++;
            }
            System.out.println(String.format("%s 와 %s 사이의 월급일은 %d번 입니다.", from, to, result));
        } catch (ParseException e) {
            System.out.println("날짜 형식은 yyyy-MM-dd입니다");
        }
    }
}
