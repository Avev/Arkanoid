//ID: 316266683

/**
 * HitNotifier class.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the listener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the listener
     */
    void removeHitListener(HitListener hl);
}
