package swing2;


import java.awt.*;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
        if(width != height){
            this.color = Color.GREEN;
        }

    }

    @Override
    public int getSize(){
        return width;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void shift(){
        if (width == height) {
            this.width += 20;
            this.height += 20;
        } else setPosition(0, this.y);
    }
    public void reset(){
        if (width == height) {
            this.width = 50;
            this.height = 50;
        }
    }
}