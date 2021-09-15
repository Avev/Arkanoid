//ID: 316266683
/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * BlockRemover constructor.
     *
     * @param game          the game the blocks are in
     * @param removedBlocks counter of the remaining blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = new Counter(removedBlocks.getValue());
    }

    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        remainingBlocks.decrease(1);
    }

    /**
     * returns the remaining blocks counter.
     *
     * @return remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}
