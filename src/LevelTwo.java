//ID: 316266683
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * second level class.
 */
public class LevelTwo implements LevelInformation {
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
    public LevelTwo() {
        this.balls = 10;
        this.myBallsVelocity = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.myBallsVelocity.add(new Velocity(i - 5, -1));
        }
        this.pSpeed = 5;
        this.pWidth = 500;
        this.name = "Level Two";
        this.background = new LevelTwoBackground();
        this.myBlocks = new ArrayList<>();
        Color color = Color.RED;
        for (int i = 0; i < 15; i++) {
            if (i <= 1) {
                color = Color.RED;
            }
            if (i >= 2 && i <= 3) {
                color = Color.ORANGE;
            }
            if (i >= 4 && i <= 5) {
                color = Color.YELLOW;
            }
            if (i >= 6 && i <= 8) {
                color = Color.GREEN;
            }
            if (i >= 9 && i <= 10) {
                color = Color.BLUE;
            }
            if (i >= 11 && i <= 12) {
                color = Color.PINK;
            }
            if (i >= 13) {
                color = Color.CYAN;
            }
            this.myBlocks.add(
                    new Block(
                            new Rectangle(
                                    new Point(i * 51.5 + 15, 250),
                                    50.5, 20), color));
        }
        this.numOfBlocks = 15;
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
