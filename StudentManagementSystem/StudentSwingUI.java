import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentSwingUI {

    JFrame frame;
    JTextField txtId, txtName, txtCourse, txtMarks;
    DefaultTableModel model;
    ArrayList<Student> students;

    public StudentSwingUI() {

        students = FileHandler.load();

        frame = new JFrame("Student Management System");
        frame.setSize(900, 450);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 246, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== TITLE BAR =====
        JLabel title = new JLabel("Student Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setOpaque(true);
        title.setBackground(new Color(52, 73, 94));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 900, 50);
        frame.add(title);

        // ===== FORM PANEL =====
        JPanel form = new JPanel();
        form.setLayout(null);
        form.setBackground(Color.WHITE);
        form.setBounds(20, 70, 300, 320);
        frame.add(form);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel l1 = new JLabel("Student ID");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Course");
        JLabel l4 = new JLabel("Marks");

        l1.setFont(labelFont);
        l2.setFont(labelFont);
        l3.setFont(labelFont);
        l4.setFont(labelFont);

        txtId = new JTextField();
        txtName = new JTextField();
        txtCourse = new JTextField();
        txtMarks = new JTextField();

        l1.setBounds(20, 20, 100, 25);
        txtId.setBounds(20, 45, 250, 30);

        l2.setBounds(20, 80, 100, 25);
        txtName.setBounds(20, 105, 250, 30);

        l3.setBounds(20, 140, 100, 25);
        txtCourse.setBounds(20, 165, 250, 30);

        l4.setBounds(20, 200, 100, 25);
        txtMarks.setBounds(20, 225, 250, 30);

        JButton btnAdd = createButton("Add", new Color(46, 204, 113));
        JButton btnUpdate = createButton("Update", new Color(52, 152, 219));
        JButton btnDelete = createButton("Delete", new Color(231, 76, 60));

        btnAdd.setBounds(20, 265, 80, 35);
        btnUpdate.setBounds(110, 265, 80, 35);
        btnDelete.setBounds(200, 265, 80, 35);

        form.add(l1); form.add(txtId);
        form.add(l2); form.add(txtName);
        form.add(l3); form.add(txtCourse);
        form.add(l4); form.add(txtMarks);
        form.add(btnAdd); form.add(btnUpdate); form.add(btnDelete);

        // ===== TABLE =====
        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Course", "Marks", "Grade"}, 0);

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(52, 73, 94));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(340, 70, 520, 320);
        frame.add(sp);

        // Load existing data
        for (Student s : students) {
            model.addRow(new Object[]{
                    s.id, s.name, s.course, s.marks, s.grade
            });
        }

        // ===== BUTTON ACTIONS =====

        btnAdd.addActionListener(e -> {
            Student s = new Student(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtCourse.getText(),
                    Integer.parseInt(txtMarks.getText())
            );

            students.add(s);
            FileHandler.save(students);

            model.addRow(new Object[]{
                    s.id, s.name, s.course, s.marks, s.grade
            });

            clearFields();
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            Student s = students.get(row);
            s.id = Integer.parseInt(txtId.getText());
            s.name = txtName.getText();
            s.course = txtCourse.getText();
            s.marks = Integer.parseInt(txtMarks.getText());
            s.grade = new Student(s.id, s.name, s.course, s.marks).grade;

            model.setValueAt(s.id, row, 0);
            model.setValueAt(s.name, row, 1);
            model.setValueAt(s.course, row, 2);
            model.setValueAt(s.marks, row, 3);
            model.setValueAt(s.grade, row, 4);

            FileHandler.save(students);
            clearFields();
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            students.remove(row);
            model.removeRow(row);
            FileHandler.save(students);
            clearFields();
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtCourse.setText(model.getValueAt(row, 2).toString());
                txtMarks.setText(model.getValueAt(row, 3).toString());
            }
        });

        frame.setVisible(true);
    }

    JButton createButton(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        return b;
    }

    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtCourse.setText("");
        txtMarks.setText("");
    }

    public static void main(String[] args) {
        new StudentSwingUI();
    }
}
