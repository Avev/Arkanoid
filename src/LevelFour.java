
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * fourth level class.
 */
public class LevelFour implements LevelInformation {
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
    public LevelFour() {
        this.balls = 3;
        this.myBallsVelocity = new ArrayList<>();
        this.myBallsVelocity.add(new Velocity(0, -1));
        this.myBallsVelocity.add(new Velocity(-2, -1));
        this.myBallsVelocity.add(new Velocity(2, -1));
        this.pSpeed = 5;
        this.pWidth = 100;
        this.name = "Level Four";
        this.background = new LevelFourBackground();
        this.myBlocks = new ArrayList<>();
        Color color = Color.GRAY;
        int y = 50;
        int x = 15;
        for (int i = 0; i < 7; i++) {
            if (i == 1) {
                color = Color.RED;
            }
            if (i == 2) {
                color = Color.YELLOW;
            }
            if (i == 3) {
                color = Color.GREEN;
            }
            if (i == 4) {
                color = Color.WHITE;
            }
            if (i == 5) {
                color = Color.PINK;
            }
            if (i == 6) {
                color = Color.CYAN;
            }
            for (int j = 0; j < 15; j++) {
                myBlocks.add(new Block(new Rectangle(new Point(j * 51.5 + 15, y), 50.5, 20), color));
            }
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
