/**
 * PrintingHitListener class.
 */
public class PrintingHitListener implements HitListener {
    /**
     * prints a massage when a block is hit.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}
