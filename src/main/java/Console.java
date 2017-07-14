import javax.swing.*;
import java.util.ArrayList;

public class Console extends JPanel {
    JTextPane textPane;

    public Console() {
        textPane = new JTextPane();
        add(textPane);
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
