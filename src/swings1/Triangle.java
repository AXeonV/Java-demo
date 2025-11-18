package swings1;

import java.awt.*;

public class Triangle extends Shape {
    public Triangle() {
        this.color = Color.BLUE;
    }

    // Override the draw method
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        int[] xPoints = {x, x + 25, x + 50};
        int[] yPoints = {y + 50, y, y + 50};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    // Override the shape name
    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public void checkPosition() {
        if (!checkdot(x, y + 50) || !checkdot(x + 25, y) || !checkdot(x + 50, y + 50))
          this.color = Color.gray;
    }
}