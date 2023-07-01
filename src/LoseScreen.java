
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * WinScreen class.
 */
public class LoseScreen implements Animation {
    private int score;
    private boolean stop;
    private KeyboardSensor keyboard;

    /**
     * constructor.
     *
     * @param s score
     * @param k keyboard sensor
     */
    public LoseScreen(int s, KeyboardSensor k) {
        this.score = s;
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(
                10,
                d.getHeight() / 2,
                "Game Over. Your score is " + this.score,
                32);
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
