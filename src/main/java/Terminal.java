import javax.swing.*;
import java.awt.*;

public class Terminal extends JPanel {

    JTextField employeeName;
    JTextField employeeDept;
    JTextField empSalary;
    JTextField manager;
    JTextField empId;

    public Terminal() {
        setLayout(new FlowLayout());

        empId = new JTextField();
        employeeDept = new JTextField();
        employeeName = new JTextField();
        empSalary = new JTextField();
        manager = new JTextField();

        JButton submit = new JButton("Upload");
    }
}
