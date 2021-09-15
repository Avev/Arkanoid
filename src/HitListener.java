//ID: 316266683

/**
 * HitListener interface.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitting back
     */
    void hitEvent(Block beingHit, Ball hitter);
}
