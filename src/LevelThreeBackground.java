
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * LevelThreeBackground class.
 */
public class LevelThreeBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int x = 100;
        int y = 220;
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.fillCircle(x, y, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(x, y, 5);
        d.setColor(Color.GRAY);
        d.fillRectangle(x - 5, y + 10, 10, 150);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(x - 10, y + 10 + 150, 20, 50);
        d.setColor(Color.WHITE);
        d.fillRectangle(x - 50, y + 10 + 150 + 50, 100, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50, 100, 10);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50 + 100, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50 + 160, 100, 10);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50 + 20, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50 + 40, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50 + 60, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50 + 80, y + 10 + 150 + 50, 10, 170);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50 + 30, 100, 10);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50 + 60, 100, 10);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50 + 90, 100, 10);
        d.setColor(Color.BLACK);
        d.fillRectangle(x - 50, y + 10 + 150 + 50 + 120, 100, 10);
    }

    @Override
    public void timePassed() {

    }
}
