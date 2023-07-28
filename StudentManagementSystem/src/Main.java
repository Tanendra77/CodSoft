import java.util.Scanner;

public class Main{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem managementSystem = new StudentManagementSystem();
        boolean running = true;// for loop repetetion

        System.out.println("\t_________________________________________________________________");
        System.out.println("\t\t\t\t\tSTUDENT MANAGEMENT SYSTEM");
        System.out.println("\t_________________________________________________________________");

        while (running) {
            System.out.println("\n\t\t\t\t<< MENU >>");
            System.out.println("\t\t1. Add Student");
            System.out.println("\t\t2. Remove Student");
            System.out.println("\t\t3. Search Student");
            System.out.println("\t\t4. Display All Students");
            System.out.println("\t\t5. Exit");
            System.out.print("\n\tEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1://insert info
                    System.out.print("\n\t\t\t<< INSERT INFO >>");
                    addStudent(managementSystem);
                    break;

                case 2://delete info
                    System.out.print("\n\t\t\t<< DELETE INFO >>");
                    removeStudent(managementSystem);
                    break;

                case 3://search
                    System.out.print("\n\t\t\t<< SEARCH >>");
                    searchStudent(managementSystem);
                    break;

                case 4://show all info
                    System.out.print("\n\t\t\t<< STUDENT DETAILS >>");
                    displayAllStudents(managementSystem);
                    break;

                case 5://EXIT
                    System.out.println("\n\t\t\t<< LEAVING THE PROGRAM >>");
                    running = false;
                    break;

                default:
                    System.out.println("\n\t\t\t<< Invalid choice >>");
            }
        }

        System.out.println("\n\tTHANK YOU..!");
        scanner.close();
    }

    private static void addStudent(StudentManagementSystem managementSystem) {// insert information
        System.out.println("\n\t\t<< Enter Student Details >>");
        System.out.print("\tName: ");
        String name = scanner.nextLine();

        System.out.print("\tRoll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // for newline by nextInt()

        System.out.print("\tGrade: ");
        String grade = scanner.nextLine();


        Student newStudent = new Student(name, rollNumber, grade);
        managementSystem.addStudent(newStudent);
    }

    private static void removeStudent(StudentManagementSystem managementSystem) {// delete student info
        System.out.print("\n\tEnter the Roll Number : ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // for newline by nextInt()
        managementSystem.removeStudent(rollNumber);
    }

    private static void searchStudent(StudentManagementSystem managementSystem) {//  search for student
        System.out.print("\n\tEnter Roll Number : ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = managementSystem.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("\n\tStudent found:");
            System.out.println(student);
        } else {
            System.out.println("\t\n\tStudent with Roll Number " + rollNumber + " not found.");
        }
    }

    private static void displayAllStudents(StudentManagementSystem managementSystem) {// show all students
        System.out.println("\n\tAll Students:");
        managementSystem.displayAllStudents();
    }
}
