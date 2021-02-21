//ID: 316266683
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import biuoop.Sleeper;
import biuoop.KeyboardSensor;
/**
 * @author Aviv Rahamim
 */
public class GameLevel implements Animation {
    //field
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //private GUI gui;
    private Sleeper sleeper;
    private Counter counter;
    private BlockRemover blockRemove;
    private BallRemover ballRemove;
    private ScoreTrackingListener scoreTrack;
    private Counter score;
    private ScoreIndicator scoreInd;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation info;
    //constructor

    /**
     * constructor.
     *
     * @param inf the level information
     * @param k   the keyboard sensor
     * @param an  the animation runner
     * @param c   the score counter
     */
    public GameLevel(LevelInformation inf, KeyboardSensor k, AnimationRunner an, Counter c) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.sleeper = new Sleeper();
        this.info = inf;
        this.keyboard = k;
        this.runner = an;
        this.score = c;
    }

    /**
     * adds a collidable to the game.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * removes a collidable from the game.
     *
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * adds a sprite to the game.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * removes a sprite from the game.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * returns the counter.
     *
     * @return counter
     */
    public Counter getCounter() {
        return this.counter;
    }
    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * initializing the game.
     */
    public void initialize() {
        //this.score = new Counter();
        this.scoreTrack = new ScoreTrackingListener(score);
        this.scoreInd = new ScoreIndicator(this.scoreTrack, this.info);
        int height = 600;
        int width = 800;
        int bHeight = 15;
        int bWidth = 50;
        //this.gui = new GUI("Arkanoid", width, height);
        //this.runner = new AnimationRunner(this.gui);
        //this.keyboard = this.gui.getKeyboardSensor();
        Point center = new Point(400, 550);
        this.sprites.addSprite(info.getBackground());
        Paddle paddle = new Paddle(this.keyboard, info.paddleSpeed(), info.paddleWidth());
        paddle.addToGame(this);
        Block up = new Block(new Rectangle(new Point(0, 0), width, bHeight), Color.RED);
        Block down = new Block(new Rectangle(new Point(bHeight + 1, height - bHeight + 15), width - 2 * bHeight,
                bHeight), Color.GRAY);
        Block left = new Block(new Rectangle(new Point(0, bHeight + 1), bHeight, height - bHeight - 1),
                Color.GRAY);
        Block right = new Block(new Rectangle(new Point(width - bHeight, bHeight + 1), bHeight,
                height - bHeight - 1), Color.GRAY);
        up.addToGame(this);
        down.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        this.counter = new Counter();
        this.blockRemove = new BlockRemover(this, this.counter);
        this.ballRemove = new BallRemover(this, new Counter(info.numberOfBalls()));
        down.addHitListener(ballRemove);
        int y = 100;
        int x = 175;
        Color color = Color.GRAY;
        //DrawScore drawScore = new DrawScore(up.getCollisionRectangle(), Color.RED, scoreInd);
        //drawScore.addToGame(this);
        scoreInd.addToGame(this);
        List<Ball> myBalls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myBalls.add(new Ball(center, 5, Color.WHITE, environment));
        }
        for (int i = 0; i < info.numberOfBalls(); i++) {
            myBalls.get(i).setVelocity(info.initialBallVelocities().get(i));
            myBalls.get(i).addToGame(this);
        }
        for (int i = 0; i < info.blocks().size(); i++) {
            info.blocks().get(i).addHitListener(blockRemove);
            info.blocks().get(i).addHitListener(scoreTrack);
            //this.counter.increase(1);
            this.blockRemove.getRemainingBlocks().increase(1);
            info.blocks().get(i).addToGame(this);
        }
        /**for (int i = 0; i < 6; i++) {
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
         color = Color.PINK;
         }
         if (i == 5) {
         color = Color.GREEN;
         }
         for (int j = i; j < 12; j++) {
         Block block = new Block(new Rectangle(new Point(x, y), bWidth, bHeight), color);
         block.addToGame(this);
         block.addHitListener(blockRemove);
         block.addHitListener(scoreTrack);
         this.counter.increase(1);
         this.blockRemove.getRemainingBlocks().increase(1);
         x += bWidth + 1;
         }
         x = 175 + (i + 1) * (bWidth + 1);
         y += bHeight + 1;
         }**/
    }

    // Run the game -- start the animation loop.

    /**
     * runs the animation loop.
     */
    /**public void run() {
     //...
     int framesPerSecond = 60;
     int millisecondsPerFrame = 1000 / framesPerSecond;
     while (true) {
     long startTime = System.currentTimeMillis(); // timing

     DrawSurface d = gui.getDrawSurface();
     this.sprites.drawAllOn(d);
     gui.show(d);
     this.sprites.notifyAllTimePassed();

     // timing
     long usedTime = System.currentTimeMillis() - startTime;
     long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
     if (milliSecondLeftToSleep > 0) {
     sleeper.sleepFor(milliSecondLeftToSleep);
     }
     if (blockRemove.getRemainingBlocks().getValue() == 0) {
     //score.increase(100);
     scoreTrack.getCurrentScore().increase(100);
     gui.close();
     return;
     }
     if (ballRemove.getRemainingBalls().getValue() == 0) {
     gui.close();
     return;
     }
     }
     }**/
    /**
     * returns the remaining blocks.
     *
     * @return remaining blocks
     */
    public int getRemainingBlocks() {
        return this.blockRemove.getRemainingBlocks().getValue();
    }

    /**
     * returns the remaining balls.
     *
     * @return remaining balls
     */
    public int getRemainingBalls() {
        return this.ballRemove.getRemainingBalls().getValue();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
        this.sprites.drawAllOn(d);
        //gui.show(d);
        this.sprites.notifyAllTimePassed();
        if (blockRemove.getRemainingBlocks().getValue() == 0) {
            score.increase(100);
            //scoreTrack.getCurrentScore().increase(100);
            this.running = false;
        }
        if (ballRemove.getRemainingBalls().getValue() == 0) {
            //gui.close();
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * use our runner to run the current animation -- which is one turn of
     * the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }
}
