//ID: 316266683
import java.util.List;
import java.util.ArrayList;
/**
 * @author Aviv Rahamim
 */
public class GameEnvironment {
    // field
    private List<Collidable> collidables;

    // constructor

    /**
     * construct the game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * adds a collidable to the environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * removes a collidable from the environment.
     *
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * returns the closest collision.
     *
     * @param trajectory the line from the balls location to its destination
     * @return collision info
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestPoint = null;
        Collidable closestCol = null;
        for (Collidable c : collidables) {
            Point intersection = trajectory
                    .closestIntersectionToStartOfLine(
                            c.getCollisionRectangle());
            if (intersection == null) {
                continue;
            }
            if (closestPoint == null) {
                closestPoint = intersection;
                closestCol = c;
            }
            if (intersection.distance(trajectory.start())
                    < closestPoint.distance(trajectory.start())) {
                closestPoint = intersection;
                closestCol = c;
            }
        }
        if (closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, closestCol);
    }
}
