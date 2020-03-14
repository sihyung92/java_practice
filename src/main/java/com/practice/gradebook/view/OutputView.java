package com.practice.gradebook.view;

public class OutputView {
    public static final String LINE_SEPARATOR_TWO = "======================";
    public static final String APPNAME_AND_VERSION = "성적관리프로그램 1.0.0 by SHONG";

    public static final String INPUT_INTRODUCE_MESSAGE = "학생 정보를 입력합니다...";
    public static final String STUDENT_FORMAT_INTRODUCE_MESSAGE = "[학년,반,번호,이름] 형식으로 입력해주세요\n예시 : 1,1,1,홍길동 2,1,3,성춘향";

    public static final String MENU = "1. 학생 등록 2. 학생 조회 3. 성적 입력 4. 성적 조회 5. 종료";

    public static final String ASK_CONTINUE_MESSAGE = "더 입력하시겠습니까? 1. 더 입력 2. 메뉴로 >>";

    public static final String LINE_SEPARATOR_ONE = "------------";
    public static final String PRINT_STUDENT_HEADER = "학번\t이름";

    public static final String WRONG_FORMAT_MESSAGE = "양식에 맞게 입력해주세요";
    public static final String EXIT_MESSAGE = "프로그램이 종료되었습니다.";
    public static final String STUDENT_INFOMATION_FORMAT = "%s\t%s";
    public static final String SCORE_FORMAT_INFOMATION_MESSAGE = "점수 입력 >> 100,100,100 국영수 순으로 입력";

    public static void printIntro() {
        System.out.println(LINE_SEPARATOR_TWO);
        System.out.println(APPNAME_AND_VERSION);
        System.out.println(LINE_SEPARATOR_TWO);
    }

    public static void printMenu() {
        System.out.println(MENU);
    }

    public static void askContinue() {
        System.out.println(ASK_CONTINUE_MESSAGE);
    }

    public static void printExit() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void printInputIntroduceMessage() {
        System.out.println(INPUT_INTRODUCE_MESSAGE);
        System.out.println(STUDENT_FORMAT_INTRODUCE_MESSAGE);
    }

    public static void printStudentIntro() {
        System.out.println(LINE_SEPARATOR_TWO);
        System.out.println(PRINT_STUDENT_HEADER);
        System.out.println(LINE_SEPARATOR_ONE);
    }

    public static void printStudentInfo(String studentId, String name) {
        System.out.println(String.format(STUDENT_INFOMATION_FORMAT, studentId, name));
    }

    public static void printScoreInfo(){
        System.out.println(SCORE_FORMAT_INFOMATION_MESSAGE);
    }

    public static void requestStudentID() {
        System.out.println("성적을 입력할 학생의 학번을 입력해주세요");
    }
}
