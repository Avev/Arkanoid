
import biuoop.DrawSurface;

/**
 * Animation interface.
 */
public interface Animation {
    /**
     * does the action of 1 step at a time.
     *
     * @param d drawsurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * returns true if needs to stop, false otherwise.
     *
     * @return true/false
     */
    boolean shouldStop();
}
