import javax.swing.*;
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
        add(clearConsole);
    }

    private void clearMainConsole() {
        Main.getMainInstance().clearConsole();
    }


    private void getNextList() {
        EmployeesData.getInstance().fetchNext();
    }
}
