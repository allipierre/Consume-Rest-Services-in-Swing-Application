/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Main;
import modell.Employee;
import modell.EmployeesData;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * @author yotti
 *
 */
public class JframeItems extends JFrame {

	private JPanel contentPane;
	private static JframeItems jframeItems;
	JComboBox comboBox;
	JList list = new JList();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JframeItems() {

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox = new JComboBox();
		comboBox.setBounds(19, 22, 150, 27);
		
		list.setBounds(218, 22, 159, 162);
		//contentPane.add(list);
		contentPane.add(comboBox);

		ArrayList<Employee> employees = EmployeesData.getInstance().fetchNexts();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		DefaultListModel modelList=new DefaultListModel();
		for (Employee employee : employees) {

			Object[] o = new Object[7];
			o[0] = employee.getDeptno();
			o[1] = employee.getEmpno();
			o[2] = employee.getEname();
			o[3] = employee.getHiredate();
			o[4] = employee.getJob();
			o[5] = employee.getMgr();
			o[6] = employee.getSal();
			model.addElement(o[2]);
			modelList.addElement(o[6]);
		}

		comboBox.setModel(model);
		list.setModel(modelList);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(19, 70, 150, 90);
		scrollPane.setPreferredSize(new Dimension(600, 400));
		contentPane.add(scrollPane);
		
		
		
		
		
	}

	public static JframeItems getMainInstance() {
		return jframeItems;
	}
}
