package swings1;

import javax.swing.*;

public class ShapesDemo extends JFrame {
    public ShapesDemo() {
        setTitle("Shapes Inheritance Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new DrawingPanel2());

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ShapesDemo().setVisible(true);
    }
}
