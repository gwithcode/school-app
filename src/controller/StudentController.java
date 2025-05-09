package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import models.Student;


public class StudentController {
    public double calculateGPA(Student student){
        int totalCredits = getTotalCredits(student);
        double totalGradePoint = gradePointMapper(student);

        double gpa = totalGradePoint / totalCredits;
        student.setGPA(gpa);
        return gpa;
    }

    public double gradePointMapper(Student student){
        int totalGradePoint = 0;
        ArrayList<Double> grades = student.getGrades();
        ArrayList<Integer> credits = student.getCredits();
        for (int i = 0; i < grades.size(); i++){
            if(grades.get(i) >= 90 && grades.get(i) <= 100){
                totalGradePoint = totalGradePoint + (4 * credits.get(i));
            } else if(grades.get(i) >= 80){
                totalGradePoint = totalGradePoint + (3 * credits.get(i));
            } else if(grades.get(i) >= 70){
                totalGradePoint = totalGradePoint + (2 * credits.get(i));
            } else if(grades.get(i) >= 60){
                totalGradePoint = totalGradePoint + (1 * credits.get(i));
            }
        }
        return totalGradePoint;
    }

    public int getTotalCredits(Student student){
        int totalCredits = 0;
        for (int credit : student.getCredits()) {
            totalCredits += credit;
        }
        return totalCredits;
    }

    public void returnStudentRank(ArrayList<Student> students, int input){
        if(input == 1){ //low to high
            students.sort(Comparator.comparingDouble(Student::getGPA));
        } else if(input == 2){ //high to low
            students.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        } else{
            System.out.println("Not valid input, please only enter either 1 or 2");
        }
    }

    public void assignClassRank(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setClassRank(i + 1);
        }
    }

    public void createNewStudent(String filePath) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter grade year: ");
        int gradeYear = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Enter class rank: ");
        int classRank = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter student ID");
        int studentID = Integer.parseInt(scanner.nextLine());
    
        List<Double> grades = new ArrayList<>();
        List<Integer> credits = new ArrayList<>();
    
        grades.add(0.0);
        credits.add(0);

        scanner.close();
    
        try (FileWriter writer = new FileWriter(filePath, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(",").append(gradeYear).append(",")
              .append(age).append(",").append(gpa).append(",").append(classRank).append(studentID);
    
            for (double grade : grades) {
                sb.append(",").append(grade);
            }
            for (int credit : credits) {
                sb.append(",").append(credit);
            }
    
            sb.append("\n");
            writer.write(sb.toString());
            System.out.println("Student added with default grades and credits.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> loadStudentsFromCSV(String filePath){
        ArrayList<Student> students = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
    
                String name = values[0];
                int gradeYear = Integer.parseInt(values[1]);
                int age = Integer.parseInt(values[2]);
                double gpa = Double.parseDouble(values[3]);
                int classRank = Integer.parseInt(values[4]);
                int studentID = Integer.parseInt(values[5]);

                int dynamicCount = (values.length - 6) / 2;
                int creditStart = 6 + dynamicCount;
    
                ArrayList<Double> grades = new ArrayList<>();
                for (int i = 6; i < creditStart; i++) {
                    grades.add(Double.parseDouble(values[i]));
                }

                ArrayList<Integer> credits = new ArrayList<>();
                for (int i = creditStart; i < values.length; i++) {
                    credits.add(Integer.parseInt(values[i]));
                }
    
                Student student = new Student(name, gradeYear, age, gpa, classRank, studentID, grades, credits);
                students.add(student);
            }
    
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    
        return students;
    }
}
