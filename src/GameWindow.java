import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private GameLogic gameLogic;

    public GameWindow() {
        gameLogic = new GameLogic();
        setTitle("Snake Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameLogic.handleKeyPress(e.getKeyCode());
            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLogic.update();
                gameCanvas.repaint();
            }
        });
        timer.start();
    }

    private class GameCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gameLogic.draw(g);
        }
    }
}
