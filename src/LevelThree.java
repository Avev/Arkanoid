
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * third level class.
 */
public class LevelThree implements LevelInformation {
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
    public LevelThree() {
        this.balls = 2;
        this.myBallsVelocity = new ArrayList<>();
        this.myBallsVelocity.add(new Velocity(-1, -1));
        this.myBallsVelocity.add(new Velocity(1, -1));
        this.pSpeed = 5;
        this.pWidth = 100;
        this.name = "Level Three";
        this.background = new LevelThreeBackground();
        this.myBlocks = new ArrayList<>();
        Color color = Color.GRAY;
        int y = 200;
        int x = 375;
        for (int i = 0; i < 5; i++) {
            if (i == 1) {
                color = Color.RED;
            }
            if (i == 2) {
                color = Color.YELLOW;
            }
            if (i == 3) {
                color = Color.BLUE;
            }
            if (i == 4) {
                color = Color.WHITE;
            }
            for (int j = i; j < 10; j++) {
                myBlocks.add(new Block(new Rectangle(new Point(x, y), 40, 20), color));
                x += 40 + 1;
            }
            x = 415 + i * (40 + 1);
            y += 20 + 1;
        }
        this.numOfBlocks = 40;
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
