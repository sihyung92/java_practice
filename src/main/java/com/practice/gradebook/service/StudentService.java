package com.practice.gradebook.service;

import com.practice.gradebook.student.Student;
import com.practice.gradebook.student.Students;
import com.practice.gradebook.view.OutputView;

import java.util.Arrays;

public class StudentService {
    public static final String DELIMITER = ",";
    public static final int INPUT_STUDENT_ARRAY_LENGTH = 4;

    public static final String WRONG_FORMAT_MESSAGE = "양식에 맞게 입력해주세요.";
    public static final String WRONG_NUMBER_TYPE_MESSAGE = "숫자 입력 란에는 숫자를 입력해주세요.";
    public static final int GRADE_NUMBER_INDEX = 0;
    public static final int CLASS_NUMBER_INDEX = 1;
    public static final int PERSONAL_NUMBER_INDEX = 2;
    public static final int STUDENT_NAME_INDEX = 3;

    public static void registStudent(String inputStudent) {
        String[] studentInformation = inputStudent.split(DELIMITER);
        validateInput(studentInformation);
        Students.registStudent(createStudent(studentInformation));
    }

    private static Student createStudent(String[] studentInformation) {
        int[] studentNumbers = parseInt(studentInformation);
        int grade = studentNumbers[GRADE_NUMBER_INDEX];
        int classNumber = studentNumbers[CLASS_NUMBER_INDEX];
        int personalNumber = studentNumbers[PERSONAL_NUMBER_INDEX];
        String name = studentInformation[STUDENT_NAME_INDEX];
        return new Student(name, grade, classNumber, personalNumber);
    }

    private static int[] parseInt(String[] studentInformation) {
        int[] temp;
        try{
            temp = Arrays.stream(studentInformation)
                    .limit(INPUT_STUDENT_ARRAY_LENGTH - 1)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }catch(NumberFormatException e){
            throw new NumberFormatException(WRONG_NUMBER_TYPE_MESSAGE);
        }
        return temp;
    }

    private static void validateInput(String[] temp) {
        if (temp.length != INPUT_STUDENT_ARRAY_LENGTH) {
            throw new IllegalArgumentException(WRONG_FORMAT_MESSAGE);
        }
    }

    public static void printStudent() {
        Students.getStudents()
                .stream()
                .forEach(student ->
                        OutputView.printStudentInfo(student.getStudentID(), student.getName())
                );
    }
}
