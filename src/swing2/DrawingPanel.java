package swing2;

import javax.swing.*;
import java.awt.*;


public class DrawingPanel extends JPanel {
    public Shape selected = null;

    public DrawingPanel() {
        setLayout(new BorderLayout());

        // Create shapes panel with grid layout
        JPanel shapesPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        shapesPanel.setPreferredSize(new Dimension(400, 400));

        // Initialize arrays
        Shape[] shapes = new Shape[]{
                new Rectangle(50,50),
                new Triangle(),
                new Rectangle(80,30),
                new Circle()
        };

        JButton[] buttons = new JButton[4];

        // Create buttons with shapes
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];

            buttons[i] = new JButton() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    boolean isSquare = false;

                    if(shape instanceof Rectangle){
                        Rectangle rect = (Rectangle) shape;
                        isSquare = rect.getWidth() == rect.getHeight();
                    }

                    // Center shape in button
                    if(shape instanceof Rectangle && !isSquare){
                        if (selected == null)
                            shape.setPosition((getWidth() - ((Rectangle) shape).getWidth())/2,
                                (getHeight() - ((Rectangle) shape).getHeight())/2);
                    }
                    else{ // Polymorphism call on getSize()
                        shape.setPosition(
                            (getWidth() - shape.getSize()) / 2,
                            (getHeight() - shape.getSize()) / 2
                        );
                    }

                    shape.draw(g2d);
                }
            };

            buttons[i].addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    this,
                    "Selected: " + shape.getShapeName(),
                    "Shape Information",
                    JOptionPane.INFORMATION_MESSAGE
                );
                selected = shape;
            });

            shapesPanel.add(buttons[i]);
        }

        // Create control panel for shift/reset buttons
        JPanel controlPanel = new JPanel();
        JButton shiftButton = new JButton("Shift");
        JButton resetButton = new JButton("Reset");

        // Add shift button action
        shiftButton.addActionListener(e -> {
            if (selected != null) {
                for (Shape shape : shapes)
                    if (shape == selected)
                        shape.shift();
                for (JButton button : buttons)
                    button.repaint();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "No shape selected",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Add reset button action
        resetButton.addActionListener(e -> {
            selected = null;
            for (Shape shape : shapes)
                shape.reset();
            for (JButton button : buttons)
                button.repaint();
        });

        controlPanel.add(shiftButton);
        controlPanel.add(resetButton);

        // Add panels to main panel
        add(shapesPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
}