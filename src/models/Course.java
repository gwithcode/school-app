package models;

public class Course {
    int credits;
    int courseID;

    public Course(int credits, int courseID){
        this.credits = credits;
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public int getCourseID() {
        return courseID;
    }
}
