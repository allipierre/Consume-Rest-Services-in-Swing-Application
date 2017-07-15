package View;
import javax.swing.*;

import application.Main;
import modell.EmployeesData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel {

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
        add(clearConsole);
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
