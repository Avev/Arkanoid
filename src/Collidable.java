//ID: 316266683
/**
 * @author Aviv Rahamim
 */
public interface Collidable {

    /**
     * the rectangle that has a collision.
     *
     * @return rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the hitting ball
     * @return velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}