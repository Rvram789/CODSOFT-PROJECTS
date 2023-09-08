import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
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

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\n";
    }
}

class StudentManagementSystemGUI extends JFrame {
    private ArrayList<Student> students;
    private JTextField nameField;
    private JTextField rollNumberField;
    private JTextField gradeField;
    private JTextArea displayArea;

    public StudentManagementSystemGUI() {
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        students = new ArrayList<>();

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberField = new JTextField(10);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(5);

        JButton addButton = new JButton("Add Student");
        JButton displayButton = new JButton("Display Students");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        add(nameLabel);
        add(nameField);
        add(rollNumberLabel);
        add(rollNumberField);
        add(gradeLabel);
        add(gradeField);
        add(addButton);
        add(displayButton);
        add(new JScrollPane(displayArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
    }

    private void addStudent() {
        String name = nameField.getText();
        String rollNumberStr = rollNumberField.getText();
        String grade = gradeField.getText();

        try {
            int rollNumber = Integer.parseInt(rollNumberStr);

            Student student = new Student(name, rollNumber, grade);
            students.add(student);

            nameField.setText("");
            rollNumberField.setText("");
            gradeField.setText("");

            displayArea.append("Student added:\n" + student + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid roll number. Please enter a numeric value.");
        }
    }

    private void displayStudents() {
        displayArea.setText("");

        for (Student student : students) {
            displayArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystemGUI().setVisible(true);
            }
        });
    }
}
