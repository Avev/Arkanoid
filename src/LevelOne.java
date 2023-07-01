
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * first level class.
 */
public class LevelOne implements LevelInformation {
    private int balls;
    private List<Velocity> myBallsVelocity;
    private int pSpeed;
    private int pWidth;
    private String name;
    private Sprite background;
    private List<Block> myBlocks;
    private int numOfBlocks;

    /**
     * constructor.
     */
    public LevelOne() {
        this.balls = 1;
        this.myBallsVelocity = new ArrayList<>();
        this.myBallsVelocity.add(new Velocity(0, -1));
        this.pSpeed = 5;
        this.pWidth = 100;
        this.name = "Level One";
        this.background = new LevelOneBackground();
        this.myBlocks = new ArrayList<>();
        this.myBlocks.add(
                new Block(
                        new Rectangle(
                                new Point(390, 150), 20, 20), Color.RED));
        this.numOfBlocks = 1;
    }

    @Override
    public int numberOfBalls() {
        return this.balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return myBallsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return pSpeed;
    }

    @Override
    public int paddleWidth() {
        return pWidth;
    }

    @Override
    public String levelName() {
        return name;
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        return myBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numOfBlocks;
    }
}
