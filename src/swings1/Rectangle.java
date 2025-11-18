package swings1;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle() {
        this.color = Color.GREEN;
    }

    // Override the draw method
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, 80, 50);
    }

    // Override the shape name
    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public void checkPosition() {
        if (!checkdot(x, y) || !checkdot(x + 80, y) || !checkdot(x, y + 50) || !checkdot(x + 80, y + 50))
          this.color = Color.gray;
    }
}
