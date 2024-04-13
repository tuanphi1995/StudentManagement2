package com.example;

import com.example.entity.Student;
import com.example.model.StudentList;
import java.util.*;

public class Application {

    private static Scanner input = new Scanner(System.in);
    private static StudentList list = new StudentList();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.print("#: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    printStudentsInDescendingOrder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        Student student = new Student();
        student.scanInfo();
        list.add(student);
        System.out.println("Student added successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = input.nextInt();
        list.remove(id);
    }

    private static void searchByName() {
        input.nextLine(); // consume leftover newline
        System.out.print("Enter student name to search: ");
        String name = input.nextLine();
        ArrayList<Student> matches = list.findByName(name);
        if (!matches.isEmpty()) {
            list.showList(matches);
        }
    }

    private static void searchById() {
        System.out.print("Enter student ID to search: ");
        int id = input.nextInt();
        Student student = list.findById(id);
        if (student != null) {
            student.printInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void printStudentsInDescendingOrder() {
        list.sortByMarks();
        list.showList();
    }

    public static void menu() {
        System.out.println("\nStudent Manage");
        System.out.println("1. Add a new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Print student info in descending order of mark");
        System.out.println("6. Exit");
    }
}
