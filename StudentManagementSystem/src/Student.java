

public class Student {//class for storage of data and management
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return "\tName: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }//send dataone by one
}


