//ID: 316266683
/**
 * @author Aviv Rahamim
 */
public class CollisionInfo {
    // field
    private Point collisionPoint;
    private Collidable collisionObject;

    // constructor

    /**
     * gets info about the collision, the collision points and the collision object.
     *
     * @param collisionPoint  the collision Point
     * @param collisionObject the collision Object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * returns the collision point.
     *
     * @return collision point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * returns the collision object.
     *
     * @return collision object
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
