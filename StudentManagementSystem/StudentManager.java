import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = FileHandler.load();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        System.out.print("Marks: ");
        int marks = sc.nextInt();

        students.add(new Student(id, name, course, marks));
        FileHandler.save(students);
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s.id+" "+s.name+" "+s.course+" "+s.marks+" "+s.grade);
        }
    }
}
