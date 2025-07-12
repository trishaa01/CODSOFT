// Student.java
// Represents a student with name, roll number, and grade

public class Student {
    private String name;
    private int rollNo;
    private String grade;

    // Constructor
    public Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getGrade() {
        return grade;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method to return student info as string
    public String toString() {
        return "Name: " + name + "\nRoll No: " + rollNo + "\nGrade: " + grade;
    }

    // Convert to file format
    public String toFileString() {
        return rollNo + "," + name + "," + grade;
    }

    // Create Student object from file data
    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        int roll = Integer.parseInt(parts[0]);
        return new Student(parts[1], roll, parts[2]);
    }
}
// StudentManagementSystem.java
// Manages a list of students using Scanner for file reading

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;            // List to store student records
    private final String filename = "students.txt"; // File to store student data

    // Constructor initializes the list and loads data from file
    public StudentManagementSystem() {
        students = new ArrayList<Student>();
        loadFromFile();
    }

    // Adds a student and saves to file
    public void addStudent(Student s) {
        // Check if roll number already exists
        for (Student student : students) {
            if (student.getRollNo() == s.getRollNo()) {
                System.out.println("Student already exists.");
                return; // Exit the method without adding
            }
        }
    
        // If roll number is unique, add to list
        students.add(s);
        saveToFile();
        System.out.println("Student added successfully.");
    }

    // Removes student by roll number
    public boolean removeStudent(int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                students.remove(i);    // Remove student
                saveToFile();          // Save updated list
                return true;
            }
        }
        return false;   // Not found
    }

    // Searches for a student by roll number
    public Student searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    // Displays all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student records.");
        } else {
            for (Student s : students) {
                System.out.println("\n"+s);
            }
        }
    }

    // Saves student data to file
    private void saveToFile() {
        try {
            FileWriter fw = new FileWriter(filename);
            for (Student s : students) {
                fw.write(s.toFileString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Loads student data from file using Scanner
    private void loadFromFile() {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            students.clear();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Student s = Student.fromFileString(line);
                students.add(s);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            // File might not exist on first run
        }
    }
}
// Console interface for the Student Management System

import java.util.Scanner;

public class Operate {
    public static void main(String[] args) {
        StudentManagementSystem sm = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    sm.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    int r = sc.nextInt();
                    if (sm.removeStudent(r)) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int sr = sc.nextInt();
                    Student s = sm.searchStudent(sr);
                    if (s != null) {
                        System.out.println("Found: " + s);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    sm.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
        sc.close();
    }
}
