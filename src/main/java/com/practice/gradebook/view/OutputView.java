package com.practice.gradebook.view;

public class OutputView {
    public static final String REQUEST_INPUT_MESSAGE = "학생 정보를 입력합니다...";
    public static final String FORMAT_INTRODUCE_MESSAGE = "[학년,반,번호,이름] 형식으로 입력해주세요\n예시 : 1,1,1,홍길동 2,1,3,성춘향";
    public static final String WRONG_FORMAT_MESSAGE = "양식에 맞게 입력해주세요";

    public void printRequestMessage() {
        System.out.println(REQUEST_INPUT_MESSAGE);
        System.out.println(FORMAT_INTRODUCE_MESSAGE);
    }
}
