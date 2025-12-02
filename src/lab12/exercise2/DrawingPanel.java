package lab12.exercise2;



import lab12.exercise1.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawingPanel extends JPanel {

    List<Rectangle> rectangleList = new ArrayList<>();


    public DrawingPanel() {
        setLayout(new BorderLayout());

        generateRectangles();

        JPanel circlePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Rectangle r : rectangleList){
                    r.draw((Graphics2D) g);
                }
            }
        };
        circlePanel.setPreferredSize(new Dimension(600, 400));
        add(circlePanel, BorderLayout.CENTER);


        JPanel buttons = new JPanel(new FlowLayout());
        JButton brushButton = new JButton("sort and brush");



        brushButton.addActionListener(e -> {
            Collections.sort(rectangleList);
            for (int i = 0; i < rectangleList.size(); i++)
                rectangleList.get(i).useColorPalette(i % 7);
            circlePanel.repaint();
        });



        buttons.add(brushButton);

        add(buttons, BorderLayout.SOUTH);


    }

    private void generateRectangles() {

        int[][] rectangles = {

                {50, 10, 50, 250},
                {100, 30, 50, 200},
                {150, 50, 50, 150},
                {200, 70, 50, 100},
                {250, 90, 50, 50},

                {300, 150, 50, 50},
                {350, 130, 50, 100},
                {400, 110, 50, 150},
                {450, 90, 50, 200},
                {500, 70, 50, 250}
        };

        for (int[] rect : rectangles) {
            rectangleList.add(new Rectangle(rect[0], rect[1], rect[2], rect[3]));
        }


        Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
        for (Rectangle r : rectangleList)
            r.setColorPalettes(colors);
    }
}
