
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * LevelFourBackground class.
 */
public class LevelFourBackground implements Sprite {
    /**
     * constructor.
     *
     * @param d surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        int x = 100;
        int y = 400;
        int x2 = 600;
        int y2 = 500;
        d.setColor(new Color(44, 150, 229));
        d.fillRectangle(0, 0, 800, 600);
        for (int i = 0; i < 7; i++) {
            d.setColor(Color.WHITE);
            d.drawLine(x + 10 * i, y, x + 10 * i - 10, 600);
        }
        d.setColor(new Color(227, 227, 227));
        d.fillCircle(x, y, 30);
        d.setColor(new Color(202, 201, 202));
        d.fillCircle(x + 30, y - 10, 30);
        d.setColor(new Color(193, 192, 193));
        d.fillCircle(x + 30, y + 20, 30);
        d.setColor(new Color(157, 156, 157));
        d.fillCircle(x + 60, y, 30);
        for (int i = 0; i < 7; i++) {
            d.setColor(Color.WHITE);
            d.drawLine(x2 + 10 * i, y2, x2 + 10 * i - 10, 600);
        }
        d.setColor(new Color(227, 227, 227));
        d.fillCircle(x2, y2, 30);
        d.setColor(new Color(202, 201, 202));
        d.fillCircle(x2 + 30, y2 - 10, 30);
        d.setColor(new Color(193, 192, 193));
        d.fillCircle(x2 + 30, y2 + 20, 30);
        d.setColor(new Color(157, 156, 157));
        d.fillCircle(x2 + 60, y2, 30);
    }

    @Override
    public void timePassed() {

    }
}
