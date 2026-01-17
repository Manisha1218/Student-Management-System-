public class Student {
    int id;
    String name;
    String course;
    int marks;
    String grade;

    public Student(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(int m) {
        if (m >= 90) return "A+";
        if (m >= 75) return "A";
        if (m >= 60) return "B";
        if (m >= 40) return "C";
        return "Fail";
    }
}
