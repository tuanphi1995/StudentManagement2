package com.example.model;

import com.example.entity.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    private ArrayList<Student> list;
    private int length;

    public StudentList() {
        list = new ArrayList<Student>();
    }

    public ArrayList<Student> findByName(String name) {
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<>();
        for (Student s : list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
            if (fullName.matches(".*" + name.toLowerCase() + ".*")) {
                matches.add(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
        return matches;
    }

    public Student findById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void add(Student s) {
        list.add(s);
    }

    public void remove(int id) {
        boolean found = false;
        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Are you sure deleting this student? (1. Yes 2. No)");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                if (choice == 1) {
                    list.remove(s);
                    found = true;
                    break; // Stop the loop after removing the student
                }
            }
        }
        if (!found) {
            System.out.println("Cannot find student with id " + id);
        }
    }

    public void sortByMarks() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMark(), s1.getMark());
            }
        });
    }

    public void showList() {
        for (Student s : list) {
            s.printInfo();
        }
    }

    public void showList(ArrayList<Student> sList) {
        for (Student s : sList) {
            s.printInfo();
        }
    }
}
