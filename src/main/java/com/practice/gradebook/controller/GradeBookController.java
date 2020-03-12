package com.practice.gradebook.controller;

import com.practice.gradebook.service.StudentService;
import com.practice.gradebook.view.InputView;
import com.practice.gradebook.view.OutputView;

public class GradeBookController {
    private static StudentService studentService = new StudentService();
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void run() {
        outputView.printRequestMessage();
        studentService.registStudent(inputView.inputStudent());
     }


}
