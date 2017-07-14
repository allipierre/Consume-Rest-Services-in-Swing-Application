import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;

    Console console;
    Ball ball;
    Terminal terminal;

    private static Main main;

    private Main() {
        console = new Console();
        ball = new Ball();
        terminal = new Terminal();

        setTitle("Rest Demo");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        setMinimumSize(windowSize);
        setMaximumSize(windowSize);

        setLayout(new BorderLayout());
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
}
