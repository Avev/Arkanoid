//ID: 316266683
import java.util.List;
/**
 * LevelInformation class.
 */
public interface LevelInformation {
    /**
     * returns the number of balls.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return velocity list
     */
    List<Velocity> initialBallVelocities();

    /**
     * returns the paddle speed.
     *
     * @return paddle speed
     */
    int paddleSpeed();

    /**
     * returns the paddle width.
     *
     * @return paddle width
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return level name
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return background
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return block list
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number of blocks to remove
     */
    int numberOfBlocksToRemove();
}
