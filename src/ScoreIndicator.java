
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * ScoreIndicator class.
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener scoreTrack;
    private java.awt.Color color;
    private LevelInformation info;

    /**
     * ScoreIndicator constructor.
     *
     * @param s the score tracking listener
     * @param i level information
     */
    public ScoreIndicator(ScoreTrackingListener s, LevelInformation i) {
        this.scoreTrack = s;
        this.color = Color.BLACK;
        this.info = i;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawText(400, 15, "Score: " + scoreTrack.getCurrentScore().getValue(), 18);
        d.setColor(Color.BLACK);
        d.drawText(600, 15, this.info.levelName(), 18);
    }

    @Override
    public void timePassed() {

    }

    /**
     * adds the indicator to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
