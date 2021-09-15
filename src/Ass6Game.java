//ID: 316266683
import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aviv Rahamim
 */
public class Ass6Game {
    /**
     * main function.
     *
     * @param args received input
     */
    public static void main(String[] args) {
        int height = 600;
        int width = 800;
        List<Integer> levelNums = new ArrayList<>();
        for (String arg : args) {
            if (arg.equals("1")) {
                levelNums.add(1);
            }
            if (arg.equals("2")) {
                levelNums.add(2);
            }
            if (arg.equals("3")) {
                levelNums.add(3);
            }
            if (arg.equals("4")) {
                levelNums.add(4);
            }
        }
        GUI gui = new GUI("Arkanoid", width, height);
        GameFlow flow = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();
        if (levelNums.size() == 0) {
            levels.add(new LevelOne());
            levels.add(new LevelTwo());
            levels.add(new LevelThree());
            levels.add(new LevelFour());
        } else {
            for (Integer levelNum : levelNums) {
                if (levelNum == 1) {
                    levels.add(new LevelOne());
                }
                if (levelNum == 2) {
                    levels.add(new LevelTwo());
                }
                if (levelNum == 3) {
                    levels.add(new LevelThree());
                }
                if (levelNum == 4) {
                    levels.add(new LevelFour());
                }
            }
        }
        flow.runLevels(levels);
        gui.close();
    }
}
