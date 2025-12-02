package lab12.exercise1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class DrawingPanel extends JPanel {
    private ArrayList<Circle> circles = new ArrayList<>();

    public DrawingPanel() {
        setLayout(new BorderLayout());

        generateCircles();

        JPanel circlePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Circle c : circles) {
                    c.draw((Graphics2D) g);
                }
            }
        };
        circlePanel.setPreferredSize(new Dimension(600, 400));
        add(circlePanel, BorderLayout.CENTER);


        JPanel buttons = new JPanel(new FlowLayout());
        JButton brushButton = new JButton("brush");
        JButton sortButton = new JButton("sort");

        sortButton.setEnabled(false);

        brushButton.addActionListener(e -> {
            for (int i = 0; i < circles.size(); i++)
                circles.get(i).useColorPalette(i % 7);
            circlePanel.repaint();

            sortButton.setEnabled(true);
            brushButton.setEnabled(false);
        });

        sortButton.addActionListener(e -> {
            // TODO
            // sort circles;
            // iterate the sorted list and reposition each circle to be centered
            Collections.sort(circles);
            for (Circle c : circles)
                c.setPosition(300 - c.getRadius(), 200 - c.getRadius());
            circlePanel.repaint();
        });

        buttons.add(brushButton);
        buttons.add(sortButton);

        add(buttons, BorderLayout.SOUTH);
    }

    private void generateCircles() {

        circles.add(new Circle(100, 100, 70));
        circles.add(new Circle(300, 120, 80));
        circles.add(new Circle(450, 100, 40));
        circles.add(new Circle(150, 300, 50));
        circles.add(new Circle(400, 300, 60));
        circles.add(new Circle(100, 200, 20));
        circles.add(new Circle(500, 350, 30));
        circles.add(new Circle(50, 50, 10));

        Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
        for (Circle c : circles)
            c.setColorPalettes(colors);
    }
}
