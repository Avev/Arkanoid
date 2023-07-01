
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 *The CountdownAnimation will display the given gameScreen,
 *for numOfSeconds seconds, and on top of them it will show
 *a countdown from countFrom back to 1, where each number will
 *appear on the screen for (numOfSeconds / countFrom) seconds, before
 *it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double seconds;
    private int count;
    private SpriteCollection sprites;
    private boolean stop;
    private Sleeper sleeper;
    private long time;

    /**
     * constructor.
     *
     * @param numOfSeconds the seconds before start
     * @param countFrom    the countdown from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.seconds = numOfSeconds;
        this.count = countFrom;
        this.sprites = gameScreen;
        this.sleeper = new Sleeper();
        this.time = (long) (1000 * seconds / count);
    }

    /**
     * makes the action of a single frame.
     *
     * @param d drawsurface
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        this.sprites.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.drawText(200, 15, "Starts in " + count, 18);
        if (count != 3) {
            this.sleeper.sleepFor(this.time);
        }
        if (count <= 0) {
            this.stop = true;
        }
        count--;
        seconds--;
    }

    /**
     * if the animation should stop running.
     *
     * @return true or false
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
