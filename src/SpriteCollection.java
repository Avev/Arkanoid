//ID: 316266683
import java.util.List;
import java.util.ArrayList;
import biuoop.DrawSurface;
/**
 * @author Aviv Rahamim
 */
public class SpriteCollection {
    // field
    private List<Sprite> sprites;

    // constructor

    /**
     * construct the sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * adds a sprite to the list.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * removes a sprite from the list.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * notify the sprites that time passed, call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites2 = new ArrayList<Sprite>(sprites);
        for (Sprite s : sprites2) {
            s.timePassed();
        }
    }

    /**
     * draws all the sprites, call drawOn(d) on all sprites.
     *
     * @param d sprite
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
