package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BoxMover extends JFrame {

    private Box box;

    public BoxMover() {
        setTitle("Box Mover Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        box = new Box();
        add(box);

        box.addKeyListener(new KeyListener() {
          public void keyTyped(KeyEvent e) {}
          public void keyReleased(KeyEvent e) {}
          public void keyPressed(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_LEFT) box.addX(-5);
              if (e.getKeyCode() == KeyEvent.VK_RIGHT) box.addX(5);
              if (e.getKeyCode() == KeyEvent.VK_UP) box.addY(-5);
              if (e.getKeyCode() == KeyEvent.VK_DOWN) box.addY(5);
              box.repaint();
          }
        });

        box.setFocusable(true);
        box.requestFocusInWindow();

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxMover();
    }


    class Box extends JPanel {
        private int x = 180;
        private int y = 180;
        private final int SIZE = 20;

        public void addX(int x) {
            this.x += x;
        }
        public void addY(int y) {
            this.y += y;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(x, y, SIZE, SIZE);
        }
    }
}
