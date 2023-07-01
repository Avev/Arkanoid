
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * LevelOneBackground class.
 */
public class LevelOneBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int x = 400;
        int y = 160;
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        d.drawCircle(x, y, 40);
        d.setColor(Color.BLUE);
        d.drawCircle(x, y, 60);
        d.setColor(Color.BLUE);
        d.drawCircle(x, y, 80);
        d.setColor(Color.BLUE);
        d.drawLine(x, y + 100, x, y - 100);
        d.setColor(Color.BLUE);
        d.drawLine(x + 100, y, x - 100, y);
    }

    @Override
    public void timePassed() {

    }
}
