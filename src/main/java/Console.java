import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Console extends JPanel {
    JTextArea textPane;

    public Console() {
        textPane = new JTextArea();
        textPane.setColumns(50);
        textPane.setRows(35);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane);
    }

    public void updateConsole() {
        ArrayList<Employee> employees = EmployeesData.getInstance().getEmployees();
        StringBuilder builder = new StringBuilder();
        for (Employee employee : employees) {
            builder.append(employee.toString());
            builder.append("\n");
        }

        textPane.setText(builder.toString());
    }

    public void clear() {
        textPane.setText("");
        EmployeesData.getInstance().restart();
    }
}
