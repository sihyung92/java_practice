package com.practice.gradebook;

import com.practice.gradebook.controller.GradeBookController;

public class Application {
    public static void main(String[] args) {
        GradeBookController controller = new GradeBookController();
        controller.run();
    }
}
