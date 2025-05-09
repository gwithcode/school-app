package models;

import java.util.ArrayList;

public class Student extends Person {
    double GPA;
    int classRank;
    int studentID;
    ArrayList<Double> grades;
    ArrayList<Integer> credits;

    public Student(String name, int gradeYear, int age, double GPA, int classRank, int studentID, ArrayList<Double> grades, ArrayList<Integer> credits) {
        super(name, gradeYear, age);
        this.GPA = GPA;
        this.classRank = classRank;
        this.studentID = studentID;
        this.grades = grades;
        this.credits = credits;
    }

    public int getStudentID(){
        return studentID;
    }

    public double getGPA() {
        return GPA;
    }

     public ArrayList<Double> getGrades() {
        return grades;
    }

    public ArrayList<Integer> getCredits() {
        return credits;
    }

    public int getClassRank() {
        return classRank;
    }

    public void setClassRank(int rank){
        this.classRank = rank;
    }

    public void setGPA(double GPA){
        this.GPA = GPA;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }
    
    public void setCredits(ArrayList<Integer> credits) {
        this.credits = credits;
    }
}
