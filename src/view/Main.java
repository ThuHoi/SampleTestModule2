package view;

import controller.StudentManager;


public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        while (true) {
            studentManager.menu();
        }
    }
}
