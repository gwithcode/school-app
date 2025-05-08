package models;

public class Teacher extends Person{
    String subjectTeaching;
    
    public Teacher(String name, int gradeYear, int age, String subjectTeaching) {
        super(name, gradeYear, age);
        this.subjectTeaching = subjectTeaching;
    }
}
