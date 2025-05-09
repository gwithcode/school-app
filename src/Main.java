import controller.StudentController;
import controller.TeacherController;
import models.Student;
import models.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();

        String studentFile = "src/data/students.csv";
        String teacherFile = "src/data/teachers.csv";

        ArrayList<Student> students = studentController.loadStudentsFromCSV(studentFile);
        ArrayList<Teacher> teachers = teacherController.loadTeachersFromCSV(teacherFile);

        studentController.assignClassRank(students);

        System.out.print("Are you a Student or Teacher? (Enter 1 for student or 2 for teacher): ");
        int userType = Integer.parseInt(scanner.nextLine());

        switch (userType) {
            case 1:
                System.out.print("Enter your student ID: \n");
                int id = Integer.parseInt(scanner.nextLine());

                Student currentStudent = null;
                for (Student student : students) {
                    if (student.getStudentID() == id) {
                        currentStudent = student;
                    }
                }

                if (currentStudent == null) {
                    System.out.println("Student not found.");
                    break;
                }

                boolean studentExit = false;
                while (!studentExit) {
                    System.out.println("\nStudent Menu:");
                    System.out.println("1. View Grades");
                    System.out.println("2. View Class Rank");
                    System.out.println("3. View Full Info");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int studentOption = Integer.parseInt(scanner.nextLine());

                    switch (studentOption) {
                        case 1:
                            System.out.println("Grades: " + currentStudent.getGrades());
                            System.out.println("Letter Grades: " + studentController.convertGradesNumericToLetter(currentStudent));
                            break;
                        case 2:
                            double GPA = studentController.calculateGPA(currentStudent);
                            currentStudent.setGPA(GPA);

                            System.out.println("Class Rank: " + currentStudent.getClassRank());
                            break;
                        case 3:
                            System.out.println("\nStudent Info:");
                            System.out.println("Name: " + currentStudent.getName());
                            System.out.println("Age: " + currentStudent.getAge());
                            System.out.println("Grade Year: " + currentStudent.getGradeYear());
                            System.out.println("GPA: " + currentStudent.getGPA());
                            System.out.println("Class Rank: " + currentStudent.getClassRank());
                            System.out.println("Grades: " + currentStudent.getGrades());
                            System.out.println("Credits: " + currentStudent.getCredits());
                            break;
                        case 4:
                            studentExit = true;
                            System.out.println("Exiting");
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                }
                break;

                case 2:
                System.out.println("\nWelcome, Teacher! What would you like to do?");
                boolean teacherExit = false;
                while (!teacherExit) {
                    System.out.println("\n1. View All Students");
                    System.out.println("2. View Student Ranks");
                    System.out.println("3. Update Student Grades");
                    System.out.println("4. Add New Student");
                    System.out.println("5. View All Teachers");
                    System.out.println("6. Add Grade to Student");
                    System.out.println("7. Exit");
                    System.out.print("Enter your choice: ");
            
                    int choice = Integer.parseInt(scanner.nextLine());
            
                    switch (choice) {
                        case 1:
                            studentController.listAllStudents(students);
                            break;
                        case 2:
                            System.out.print("Sort ranks by GPA (1 = low to high, 2 = high to low): ");
                            int sort = Integer.parseInt(scanner.nextLine());
                            studentController.returnStudentRank(students, sort);
                            studentController.assignClassRank(students);
                            studentController.listAllStudents(students);
                            break;
                        case 3:
                            System.out.print("Enter student ID to update grades: ");
                            int updateID = Integer.parseInt(scanner.nextLine());
                            teacherController.updateStudentGrades(students, updateID);
                            break;
                        case 4:
                            studentController.createNewStudent(studentFile);
                            students = studentController.loadStudentsFromCSV(studentFile); 
                            break;
                        case 5:
                            teacherController.listAllTeachers(teachers);
                            break;
                        case 6:
                            System.out.print("Enter student ID to add a grade: ");
                            int addID = Integer.parseInt(scanner.nextLine());
                            teacherController.addStudentGrade(students, addID);
                            break;
                        case 7:
                            teacherExit = true;
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
                break;

            default:
                System.out.println("Invalid input. Please restart and enter 1 or 2.");
        }
        scanner.close();
    }
}
