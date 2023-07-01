
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * LevelTwoBackground class.
 */
public class LevelTwoBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int x = 200;
        int y = 100;
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.YELLOW);
        d.fillCircle(x, y, 60);
        for (int i = 0; i < 50; i++) {
            d.setColor(Color.YELLOW);
            d.drawLine(x, y, i * 15, 250);
        }
    }

    @Override
    public void timePassed() {

    }
}
