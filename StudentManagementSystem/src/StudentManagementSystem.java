import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private static final String FILE_PATH = "students.txt";//file for data

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {//insert info
        students.add(student);
        saveStudents();
        System.out.println("\n\t\t *** Student added successfully! ***");
    }

    public void removeStudent(int rollNumber) {//delete student
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                saveStudents();
                System.out.println("\n\t\t*** Student removed successfully! ***");
                return;
            }
        }
        System.out.println("\n\t\t*** Student with Roll Number " + rollNumber + " not found ***");
    }

    public Student searchStudent(int rollNumber) {// search
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;//not found
    }

    public void displayAllStudents() {//show all
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void loadStudents() {// load data
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int rollNumber = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();
                students.add(new Student(name, rollNumber, grade));
            }
        } catch (IOException e) {
            // File may not exist initially or some other I/O error.
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }

    private void saveStudents() {//save data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.getName() + ", " + student.getRollNumber() + ", " + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
}