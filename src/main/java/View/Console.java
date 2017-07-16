package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modell.Employee;
import modell.EmployeesData;


import java.awt.*;
import java.util.ArrayList;

public class Console extends JPanel {
	JTextArea textPane;
	DefaultTableModel model;

	public JTable table = new JTable();

	public Console() {
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 400));
		add(scrollPane);
		

		
	}

	public void updateConsole() {
		ArrayList<Employee> employees = EmployeesData.getInstance().getEmployees();
		Object[] columnNames = { "Deptno", "Empno", "Name","Hiredate","Job","Management","Salary"};
		 model = new DefaultTableModel(new Object[0][0], columnNames);
		StringBuilder builder = new StringBuilder();
		for (Employee employee : employees) {
			//builder.append(employee.toString());

			Object[] o = new Object[7];
			o[0] = employee.getDeptno();
			o[1] = employee.getEmpno();
			o[2] = employee.getEname();
			o[3] = employee.getHiredate();
			o[4] = employee.getJob();
			o[5] = employee.getMgr();
			o[6] = employee.getSal();
			model.addRow(o);

			

			//builder.append("\n");
		}

		//textPane.setText(builder.toString());
		table.setModel(model);
	}

	public void clear() {
		model.setRowCount(0);
		EmployeesData.getInstance().restart();
	}
}
