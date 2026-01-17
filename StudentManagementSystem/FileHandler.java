import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    static final String FILE = "students.dat";

    public static void save(ArrayList<Student> list) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE))) {
            o.writeObject(list);
        } catch (Exception e) {
            System.out.println("File Save Error");
        }
    }

    public static ArrayList<Student> load() {
        try (ObjectInputStream i = new ObjectInputStream(new FileInputStream(FILE))) {
            return (ArrayList<Student>) i.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
