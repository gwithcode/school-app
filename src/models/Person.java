package models;

public class Person {
    String name;
    int gradeYear;
    int age;

    public Person(String name, int gradeYear, int age){
        this.name = name;
        this.gradeYear = gradeYear;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public int getAge() {
        return age;
    }
}
