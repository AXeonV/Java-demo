package swings1;

import java.awt.*;

public class Diamond extends Shape {
    public Diamond() {
        this.color = Color.MAGENTA;
    }

    // Override the draw method
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        int[] xPoints = {x + 25, x + 50, x + 25, x};
        int[] yPoints = {y, y + 25, y + 50, y + 25};
        g2d.fillPolygon(xPoints, yPoints, 4);
    }

    // Override the shape name
    @Override
    public String getShapeName() {
        return "Diamond";
    }

    @Override
    public void checkPosition() {
        if (!checkdot(x + 25, y) || !checkdot(x + 50, y + 25) || !checkdot(x + 25, y + 50) || !checkdot(x, y + 25))
          this.color = Color.gray;
    }
}
