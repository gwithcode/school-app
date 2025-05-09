package models;

public class Teacher extends Person{
    String subjectTeaching;
    double salary;
    int yearsTeaching;
    
    public Teacher(String name, int gradeYear, int age, String subjectTeaching, double salary, int yearsTeaching) {
        super(name, gradeYear, age);
        this.subjectTeaching = subjectTeaching;
        this.salary = salary;
        this.yearsTeaching = yearsTeaching;
    }

    public String getSubjectTeaching() {
        return subjectTeaching;
    }
    
    public void setSubjectTeaching(String subjectTeaching) {
        this.subjectTeaching = subjectTeaching;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public int getYearsTeaching() {
        return yearsTeaching;
    }
    
    public void setYearsTeaching(int yearsTeaching) {
        this.yearsTeaching = yearsTeaching;
    }
}
