import java.util.ArrayList;
import models.Student;
import controller.StudentController;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        ArrayList<Student> students = controller.loadStudentsFromCSV("src/data/students.csv");

        for (Student s : students) {
            double gpa = controller.calculateGPA(s);
            System.out.println(s.getName() + " GPA: " + gpa);
        }

        controller.returnStudentRank(students, 2); // Sort descending
        controller.assignClassRank(students);

        System.out.println("\nRanked Students:");
        for (Student s : students) {
            System.out.println(s.getClassRank() + ". " + s.getName() + " - GPA: " + s.getGPA());
        }
    }
}
