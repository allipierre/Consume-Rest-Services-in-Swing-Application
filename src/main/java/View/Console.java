package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modell.Employee;
import modell.EmployeesData;

import java.awt.*;
import java.util.ArrayList;

public class Console extends JPanel {
    JTextArea textPane;
    private JTable table;
    
	DefaultTableModel model;

    public Console() {
        textPane = new JTextArea();
        textPane.setColumns(50);
        textPane.setRows(35);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane);
        
        table = new JTable();
        add(table);
    }

    public void updateConsole() {
        ArrayList<Employee> employees = EmployeesData.getInstance().getEmployees();
        StringBuilder builder = new StringBuilder();
        for (Employee employee : employees) {
            builder.append(employee.toString());
            table.setModel(model);
            table.setModel(model);
            builder.append("\n");
        }

        textPane.setText(builder.toString());
    }

    public void clear() {
        textPane.setText("");
        EmployeesData.getInstance().restart();
    }
}
