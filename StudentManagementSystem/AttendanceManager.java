import java.util.ArrayList;

public class AttendanceManager {
    ArrayList<Attendance> list = new ArrayList<>();

    public void markAttendance(int id, String date, String status) {
        list.add(new Attendance(id, date, status));
        System.out.println("Attendance Marked");
    }
}
