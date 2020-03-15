package com.practice.gradebook.view;

public class OutputView {
    private static final String LINE_SEPARATOR_TWO = "======================";
    private static final String APPNAME_AND_VERSION = "성적관리프로그램 1.0.0 by SHONG";

    private static final String INPUT_INTRODUCE_MESSAGE = "학생 정보를 입력합니다...";
    private static final String STUDENT_FORMAT_INTRODUCE_MESSAGE = "[학년,반,번호,이름] 형식으로 입력해주세요\n예시 : 1,1,1,홍길동 2,1,3,성춘향";

    private static final String MENU = "1. 학생 등록 2. 학생 조회 3. 성적 입력 4. 성적 조회 5. 종료";
    private static final String SCORE_MENU = "1. 학번 순 조회 2. 평균 순 조회";
    private static final String ASK_CONTINUE_MESSAGE = "더 입력하시겠습니까? 1. 더 입력 2. 메뉴로 >>";

    private static final String LINE_SEPARATOR_ONE = "------------";
    private static final String PRINT_STUDENT_HEADER = "학번\t이름";

    private static final String EXIT_MESSAGE = "프로그램이 종료되었습니다.";
    private static final String STUDENT_INFOMATION_FORMAT = "%s\t%s";
    private static final String SCORE_FORMAT_INFOMATION_MESSAGE = "점수 입력 >> 100,100,100 국영수 순으로 입력";
    public static final String ALL_SCORE_HEADER = "학번\t국어\t영어\t수학\t학급석차\t전교석차";
    public static final String ALL_SCORE_BODY_FORMAT = "%d\t%d\t%d\t%d\t%d\t%d";
    public static final String REQUEST_STUDENT_ID_MESSAGE = "성적을 입력할 학생의 학번을 입력해주세요";

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
        System.out.println(REQUEST_STUDENT_ID_MESSAGE);
    }

    public static void printAllScore(int studentID, int kor, int eng, int math, int classRank, int schoolRank) {
        System.out.println(String.format(ALL_SCORE_BODY_FORMAT,studentID,kor,eng,math, classRank, schoolRank));
    }

    public static void printScoreMenu(){
        System.out.println(SCORE_MENU);
    }

    public static void printBeforeAllScore() {
        System.out.println(ALL_SCORE_HEADER);
        System.out.println(LINE_SEPARATOR_ONE);
    }
}
