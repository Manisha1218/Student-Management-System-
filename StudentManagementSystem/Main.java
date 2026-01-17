import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        if (!Admin.login(u, p)) {
            System.out.println("Invalid Login");
            return;
        }

        StudentManager sm = new StudentManager();
        sm.addStudent();
        sm.viewStudents();
    }
}
