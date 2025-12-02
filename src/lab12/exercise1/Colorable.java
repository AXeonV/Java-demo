package lab12.exercise1;

import java.awt.Color;

public interface Colorable {
    void setColorPalettes(Color[] colors);
    void useColorPalette(int paletteIndex);
    Color getColor();
}
