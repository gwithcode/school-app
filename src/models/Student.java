package models;

public class Student extends Person {
    double GPA;
    int classRank;
    double[] grades;

    public Student(String name, int gradeYear, int age, double GPA, int classRank, double[] grades) {
        super(name, gradeYear, age);
        this.GPA = GPA;
        this.classRank = classRank;
        this.grades = grades;
    }
}
