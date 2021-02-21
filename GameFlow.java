//ID: 316266683
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * GameFlow class, creates the game levels.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * constructor.
     *
     * @param ar animationrunner
     * @param ks keyboardsensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.score = new Counter();
    }

    /**
     * runs all the levels in the input.
     *
     * @param levels levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);

            level.initialize();

            while (level.getRemainingBalls() > 0 && level.getRemainingBlocks() > 0) {
                /**Animation a1 = new WinScreen(0,keyboardSensor);
                 Animation a2 = new PauseScreen(keyboardSensor); // also an Animation
                 Animation a1k = new KeyPressStoppableAnimation(keyboardSensor,"m", a1);
                 Animation a2k = new KeyPressStoppableAnimation(keyboardSensor,"m", a2);
                 animationRunner.run(a1k);
                 animationRunner.run(a2k);**/
                level.run();
            }

            if (level.getRemainingBalls() == 0) {
                animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new LoseScreen(score.getValue(), keyboardSensor)));
                return;
            }
        }
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                new WinScreen(score.getValue(), keyboardSensor)));
    }
}
