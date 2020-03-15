package com.practice.gradebook.controller;

import com.practice.gradebook.service.ScoreService;
import com.practice.gradebook.service.StudentService;
import com.practice.gradebook.student.Student;
import com.practice.gradebook.view.InputView;
import com.practice.gradebook.view.OutputView;

public class GradeBookController {
    private static final int CONTINUE_PROCESS = 1;
    private static final int STUDENT_REGIST_PROCESS = 1;
    private static final int STUDENT_PRINT_PROCESS = 2;
    private static final int SCORE_INSERT_PROCESS = 3;
    private static final int SCORE_PRINT_PROCESS = 4;
    private static final int EXIT_PROCESS = 5;
    public static final int SCORE_PRINT_SORT_BY_ID_PROCESS = 1;
    public static final int SCORE_PRINT_SORT_BY_SCORE_PROCESS = 2;

    private static StudentService studentService = new StudentService();

    public void run() {
        OutputView.printIntro();
        while (true) {
            OutputView.printMenu();
            int process = InputView.inputMenu();
            if (process == STUDENT_REGIST_PROCESS) {
                registStudent();
            }
            if (process == STUDENT_PRINT_PROCESS) {
                printStudent();
            }
            if (process == SCORE_INSERT_PROCESS) {
                insertScore();
            }
            if (process == SCORE_PRINT_PROCESS) {
                printAllScoreMenu();
            }
            if (process == EXIT_PROCESS) {
                break;
            }
        }
        OutputView.printExit();
    }

    private void printAllScoreMenu() {
        OutputView.printScoreMenu();
        while (true) {
            int process = InputView.inputMenu();
            if (process == SCORE_PRINT_SORT_BY_ID_PROCESS) {
                printAllScoreSortByID();
            }
            if (process == SCORE_PRINT_SORT_BY_SCORE_PROCESS) {
                printAllScoreSortByScore();
            }
            break;
        }
    }

    private void printAllScoreSortByScore() {
        OutputView.printBeforeAllScore();
        ScoreService.printTotalScoreSortByScore();
    }

    private void printAllScoreSortByID() {
        OutputView.printBeforeAllScore();
        ScoreService.printTotalScoreSortByID();
    }

    private void insertScore() {
        OutputView.requestStudentID();
        Student aStudent = StudentService.findStudentByID(InputView.inputStudentId());
        OutputView.printScoreInfo();
        ScoreService.insertScore(aStudent, InputView.inputScore());
    }


    private void printStudent() {
        OutputView.printStudentIntro();
        studentService.printStudent();
    }

    private void registStudent() {
        do {
            OutputView.printInputIntroduceMessage();
            studentService.registStudent(InputView.inputStudent());
            OutputView.askContinue();
        } while (InputView.inputMenu() == CONTINUE_PROCESS);
    }
}
