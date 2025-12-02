package lab12.exercise2;

import java.awt.*;

public interface Colorable {
    void setColorPalettes(Color[] colors);
    void useColorPalette(int paletteIndex);
    Color getColor();
}
