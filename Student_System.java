import java.util.*;

class Student {
    private String ID, name, course, grades;

    Student(String ID, String name, String course, String grades) {
        this.ID = ID;
        this.name = name;
        this.course = course;
        this.grades = grades;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public void setGrade(String grades)
    {
        this.grades = grades;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getCourse()
    {
        return course;
    }

    public String getGrade()
    {
        return grades; 
    }
}

public class Student_System {
    private static TreeMap<String, Student> studentMap = new TreeMap<>();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nStudent Grade System");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Update Grades");
            System.out.println("3. Remove Student and Grades");
            System.out.println("4. View Students");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter a choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    searchStudent(scanner);
                    break;
                case 6:
                scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String ID = scanner.next();
        System.out.print("Enter Student Name: ");
        String name = scanner.next();
        System.out.print("Enter Course Name: ");
        String course = scanner.next();
        System.out.print("Enter Grades: ");
        String grades = scanner.next();

        Student newStudent = new Student(ID, name, course, grades);
        studentMap.put(newStudent.getID(), newStudent);

        System.out.println("Student and Grades Added successfully.");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter the student ID for grades update: ");
        String newID = scanner.next();
        Student existingStudent = studentMap.get(newID);

        if (existingStudent != null) {
            System.out.print("Enter the new Grade: ");
            String newGrade = scanner.next();

            existingStudent.setGrade(newGrade);

            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter the student ID to remove: ");
        String removeID = scanner.next();
        Student removedStudent = studentMap.remove(removeID);

        if (removedStudent != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudents() {
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() +
                    ", Course: " + entry.getValue().getCourse() + ", Grades: " + entry.getValue().getGrade());
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter the student ID to search: ");
        String searchID = scanner.next();
        Student searchedStudent = studentMap.get(searchID);

        if (searchedStudent != null) {
            System.out.println("Student found - Name: " + searchedStudent.getName() +
                    ", Course: " + searchedStudent.getCourse() + ", Grades: " + searchedStudent.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }
}