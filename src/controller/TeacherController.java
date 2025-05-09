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
                System.out.print("How many grades do you want to update? ");
                int numGrades = Integer.parseInt(scanner.nextLine());
            

            ArrayList<Double> newGrades = new ArrayList<>();
            ArrayList<Integer> newCredits = new ArrayList<>();

            for (int i = 0; i < numGrades; i++) {
                System.out.print("Enter grade #" + (i + 1) + ": ");
                double grade = scanner.nextDouble();
                System.out.print("Enter credit hours for grade #" + (i + 1) + ": ");
                int credit = scanner.nextInt();
                newGrades.add(grade);
                newCredits.add(credit);
            }
        
            student.setGrades(newGrades);
            student.setCredits(newCredits);
            student.setGPA(0);
            System.out.println("Grades updated for student " + student.getName());
            break;
        }
    } System.out.println("Student with " + studentID + " not found.");
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


