package swings1;

import javax.swing.*;
import java.awt.*;


public class DrawingPanel extends JPanel {

    private final Diamond diamond;
    private final Triangle triangle;
    private final Rectangle rectangle;
    private final Circle circle;

    public DrawingPanel() {
        setPreferredSize(new Dimension(400, 400));

        diamond = new Diamond();
        triangle = new Triangle();
        rectangle = new Rectangle();
        circle = new Circle();

        // Position each shape individually
        diamond.setPosition(50, 50);
        triangle.setPosition(200, 50);
        rectangle.setPosition(50, 200);
        circle.setPosition(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw each shape individually
        diamond.draw(g2d);
        triangle.draw(g2d);
        rectangle.draw(g2d);
        circle.draw(g2d);

        // Draw name for each shape individually
        g2d.setColor(Color.BLACK);
        g2d.drawString(diamond.getShapeName(), diamond.x, diamond.y + 70);
        g2d.drawString(triangle.getShapeName(), triangle.x, triangle.y + 70);
        g2d.drawString(circle.getShapeName(), circle.x, circle.y + 70);
        g2d.drawString(rectangle.getShapeName(), rectangle.x, rectangle.y + 70);
    }
}