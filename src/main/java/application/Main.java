package application;
import javax.swing.*;

import View.Ball;
import View.Console;
import View.Terminal;

import java.awt.*;

public class Main extends JFrame {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;
    private static Main main;
    Console console;
    Ball ball;
    Terminal terminal;
    JLabel status;

    private Main() {
        console = new Console();
        ball = new Ball();
        terminal = new Terminal();
        status = new JLabel();

        setTitle("Rest Demo");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        setMinimumSize(windowSize);
        setMaximumSize(windowSize);

        setLayout(new BorderLayout());
        add(status, BorderLayout.PAGE_START);
        add(console, BorderLayout.CENTER);
        add(ball, BorderLayout.LINE_END);
        add(terminal, BorderLayout.PAGE_END);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            main = new Main();
            main.setVisible(true);
        });
    }


    public static Main getMainInstance() {
        return main;
    }

    public void updateConsole() {
        console.updateConsole();
    }

    public void clearConsole() {
        console.clear();
    }

    public void setStatus(String st) {
        status.setText(st);
    }
}
