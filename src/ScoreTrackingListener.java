
/**
 * ScoreTrackingListener class.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * ScoreTrackingListener constructor.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * increases the score by 5 when a block is hit.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }

    /**
     * returns the currentScore.
     *
     * @return current score
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }

}
