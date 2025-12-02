package lab12.exercise1;
import java.awt.*;

public abstract class Shape implements Colorable {
    int x;
    int y;
    Color color;
    Color[] colors;

    public Shape() {
        this.color = Color.BLACK;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int getSize();

    public abstract void draw(Graphics2D g2d);

    public abstract String getShapeName();

    public void useColorPalette(int paletteIndex) {
        this.color = this.colors[paletteIndex];
    }
    public void setColorPalettes(Color[] colors) {
        this.colors = colors;
    }
    public Color getColor() {
        return color;
    }
}
