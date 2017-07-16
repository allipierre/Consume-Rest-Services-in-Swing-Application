package View;

import javax.swing.*;

import application.Main;
import modell.EmployeesData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel {
	private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 700;

	public Ball() {
		setLayout(new GridLayout(4, 1));
		JButton getNextBtn = new JButton("Get Next");
		getNextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getNextList();
			}
		});
		add(getNextBtn);

		JButton clearConsole = new JButton("Clear console");
		clearConsole.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearMainConsole();
			}
		});

		JButton btnNewButton = new JButton("Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNextListById();
			}
		});
		add(btnNewButton);

		JButton openFrame = new JButton("Open Frame");
		openFrame.addActionListener(e -> openFrame());
		add(openFrame);
		add(clearConsole);
	}

	/**
	 * @return
	 */
	private void openFrame() {
		JframeItems jfi = new JframeItems();
		Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		jfi.setMinimumSize(windowSize);
		jfi.setMaximumSize(windowSize);
		jfi.setBounds(810, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		jfi.setDefaultCloseOperation(jfi.DISPOSE_ON_CLOSE);
		jfi.setVisible(true);
		

	}

	private void clearMainConsole() {
		Main.getMainInstance().clearConsole();
	}

	private void getNextList() {
		EmployeesData.getInstance().fetchNext();
	}

	private void getNextListById() {
		EmployeesData.getInstance().fetchNextById();
	}
}
