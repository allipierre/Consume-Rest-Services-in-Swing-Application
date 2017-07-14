import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;

public class Terminal extends JPanel {

    private static final int TF_COLUMNS = 10;

    private JTextField employeeName;
    private JTextField employeeDept;
    private JTextField empSalary;
    private JTextField manager;
    private JTextField empId;

    public Terminal() {
        setLayout(new FlowLayout());

        empId = new JTextField();
        employeeDept = new JTextField();
        employeeName = new JTextField();
        empSalary = new JTextField();
        manager = new JTextField();

        empId.setColumns(TF_COLUMNS);
        employeeDept.setColumns(TF_COLUMNS);
        employeeName.setColumns(TF_COLUMNS);
        empSalary.setColumns(TF_COLUMNS);
        manager.setColumns(TF_COLUMNS);

        JPanel empIdPanel = toPanel(empId, "Emp ID");
        JPanel employeeDeptPanel = toPanel(employeeDept, "Department");
        JPanel employeeNamePanel = toPanel(employeeName, "Name");
        JPanel empSalaryPanel = toPanel(empSalary, "Salary");
        JPanel managerPanel = toPanel(manager, "Manager");

        JButton submit = new JButton("Create");
        submit.addActionListener(e -> createNewEmployee());

        JButton edit = new JButton("Edit");
        edit.addActionListener(e -> editEmployee());

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> deleteEmployee());

        JPanel actionPanel = new JPanel(new BorderLayout());
        actionPanel.add(delete, BorderLayout.PAGE_START);
        actionPanel.add(edit, BorderLayout.CENTER);
        actionPanel.add(submit, BorderLayout.PAGE_END);

        add(empIdPanel);
        add(employeeNamePanel);
        add(employeeDeptPanel);
        add(empSalaryPanel);
        add(managerPanel);

        add(actionPanel);
    }

    private JPanel toPanel(JTextField field, String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMinimumSize(new Dimension(10, 20));
        panel.add(new JLabel(title), BorderLayout.PAGE_START);
        panel.add(field, BorderLayout.PAGE_END);

        return panel;
    }

    private void createNewEmployee() {
        // form employee
        Employee employee = new Employee();
        employee.setEname(employeeName.getText());
        employee.setDeptno(Integer.parseInt(employeeDept.getText()));
        employee.setSal(Integer.parseInt(empSalary.getText()));
        employee.setMgr(Integer.parseInt(manager.getText()));
        // employee.setHiredate(new Date());

        ServiceGenerator.createService(RestEndpoint.class)
                .addEmployee(employee)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Main.getMainInstance().setStatus("Employee created!");
                        } else {
                            Main.getMainInstance().setStatus("Failed to create employee");
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Main.getMainInstance().setStatus("Please retry");
                    }
                });
    }

    private void deleteEmployee() {
        if (empId.getText() == null || empId.getText().isEmpty()) {
            Main.getMainInstance().setStatus("Specify employee id");
            return;
        }
        ServiceGenerator.createService(RestEndpoint.class)
                .deleteEmployee(Long.parseLong(empId.getText()))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Main.getMainInstance().setStatus("Employee deleted");
                        } else {
                            Main.getMainInstance().setStatus("Failed to delete employee");
                            System.out.println(response.raw().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Main.getMainInstance().setStatus("Retry!");
                    }
                });
    }

    private void editEmployee() {
        if (empId.getText() == null || empId.getText().isEmpty()) {
            Main.getMainInstance().setStatus("Specify employee id");
            return;
        }

        Employee data = new Employee();
        if (notEmpty(employeeName)) {
            data.setEname(employeeName.getText());
        }

        if (notEmpty(employeeDept)) {
            data.setDeptno(Long.parseLong(employeeDept.getText()));
        }

        // do for other attributes

        ServiceGenerator.createService(RestEndpoint.class)
                .editEmployee(data, Long.parseLong(empId.getText()))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Main.getMainInstance().setStatus("Edited employee successfully!");
                        }
                        else {
                            Main.getMainInstance().setStatus("Couldn't edit employee");
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Main.getMainInstance().setStatus("Retry");
                    }
                });
    }

    private boolean notEmpty(JTextField field) {
        return field.getText() != null && !field.getText().isEmpty();
    }
}
