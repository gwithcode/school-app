package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Student;
import models.Teacher;

public class TeacherController {
    public void updateStudentGrades(ArrayList<Student> students, int studentID){
        Scanner scanner = new Scanner(System.in);
        for(Student student : students){
            if(student.getStudentID() == studentID){
                ArrayList<Double> grades = student.getGrades();
                ArrayList<Integer> credits = student.getCredits();

                System.out.println("Current Grades:");
                for (int i = 0; i < grades.size(); i++) {
                    System.out.println("Grade = " + grades.get(i) + ", Credit = " + credits.get(i));
                }
    
                System.out.print("Enter index of the grade you want to update: ");
                int index = Integer.parseInt(scanner.nextLine());
    
                if (index >= 0 && index < grades.size()) {
                    System.out.print("Enter new grade: ");
                    double newGrade = Double.parseDouble(scanner.nextLine());
    
                    System.out.print("Enter new credit hours: ");
                    int newCredit = Integer.parseInt(scanner.nextLine());
    
                    grades.set(index, newGrade);
                    credits.set(index, newCredit);
    
                    student.setGrades(grades);
                    student.setCredits(credits);
                    student.setGPA(0);
                }
            System.out.println("Grades updated for student " + student.getName());
            break;
        }
    } 
    }

    public void addStudentGrade(ArrayList<Student> students, int studentID) {
        Scanner scanner = new Scanner(System.in);
    
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                ArrayList<Double> grades = student.getGrades();
                ArrayList<Integer> credits = student.getCredits();
    
                System.out.print("Enter new grade to add: ");
                double newGrade = Double.parseDouble(scanner.nextLine());
    
                System.out.print("Enter credit hours for this grade: ");
                int newCredit = Integer.parseInt(scanner.nextLine());
    
                grades.add(newGrade);
                credits.add(newCredit);
    
                student.setGrades(grades);
                student.setCredits(credits);
                student.setGPA(0); 
    
                System.out.println("New grade added for student " + student.getName());
            }
        }
    }

    public void listAllTeachers(ArrayList<Teacher> teachers) {
    for (Teacher teacher : teachers) {
        System.out.println("Teacher Name: " + teacher.getName());
        System.out.println("Teacher Age: " + teacher.getAge());
        System.out.println("Subject Teaching: " + teacher.getSubjectTeaching());
        System.out.println("Salary: " + teacher.getSalary());
        System.out.println("Years Teaching: " + teacher.getYearsTeaching());
        System.out.println("Grade Year: " + teacher.getGradeYear());
        System.out.println("---------------------------------------------");
    }
    }

    public ArrayList<Teacher> loadTeachersFromCSV(String filePath) {
    ArrayList<Teacher> teachers = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            String name = values[0];
            int gradeYear = Integer.parseInt(values[1]);
            int age = Integer.parseInt(values[2]);
            String subjectTeaching = values[3];
            double salary = Double.parseDouble(values[4]);
            int yearsTeaching = Integer.parseInt(values[5]);

            Teacher teacher = new Teacher(name, gradeYear, age, subjectTeaching, salary, yearsTeaching);
            teachers.add(teacher);
        }

    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
    }

    return teachers;
}


}


