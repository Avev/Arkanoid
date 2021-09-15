//ID: 316266683

/**
 * BallRemover class.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * BallRemover constructor.
     *
     * @param game          the game the ball is in
     * @param removedBlocks the remaining balls
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = new Counter(removedBlocks.getValue());
    }

    /**
     * Balls that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the hitted block
     * @param hitter   the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //hitter.removeHitListener(this);
        hitter.removeFromGame(this.game);
        remainingBalls.decrease(1);
    }

    /**
     * returns the remaining balls.
     *
     * @return remaining balls
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }
}
