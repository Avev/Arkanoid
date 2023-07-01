
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aviv Rahamim
 */
public class Block implements Collidable, Sprite, HitNotifier {
    // field
    private Rectangle rec;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    // constructor

    /**
     * constructor to create a block.
     *
     * @param rec   rectangle
     * @param color color
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rec = rec;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * draws the block.
     *
     * @param surface block surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rec.getUpperLeft().getX(),
                (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
    }

    @Override
    public void timePassed() {

    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    /**
     * adds the object to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removes the object from the game.
     *
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notifies the listeners about the hit.
     *
     * @param hitter the hiting ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    // Notice that we changed the hit method to include a "Ball hitter" parameter -- update the
    // Collidable interface accordingly.
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double k = 0.1;
        if (collisionPoint == null) {
            return currentVelocity;
        }
        Velocity vel = new Velocity(currentVelocity);
        if (collisionPoint.equals(rec.getUpperLeft()) ||
                collisionPoint.equals(rec.getUpperRight()) ||
                collisionPoint.equals(rec.getLowerLeft()) ||
                collisionPoint.equals(rec.getLowerRight())) {
            if ((collisionPoint.equals(rec.getUpperLeft()))) {
                if (currentVelocity.getDy() < 0 &&
                        currentVelocity.getDx() > 0) {
                    vel.reverseY();
                }
                if (currentVelocity.getDy() > 0 &&
                        currentVelocity.getDx() < 0) {
                    vel.reverseX();
                }
            }
            if (collisionPoint.equals(rec.getUpperRight())) {
                if (currentVelocity.getDy() > 0 &&
                        currentVelocity.getDx() > 0) {
                    vel.reverseX();
                }
                if (currentVelocity.getDy() < 0 &&
                        currentVelocity.getDx() < 0) {
                    vel.reverseY();
                }
            }
            if (collisionPoint.equals(rec.getLowerLeft())) {
                if (currentVelocity.getDy() > 0 &&
                        currentVelocity.getDx() > 0) {
                    vel.reverseY();
                }
                if (currentVelocity.getDy() < 0 &&
                        currentVelocity.getDx() < 0) {
                    vel.reverseX();
                }
            }
            if (collisionPoint.equals(rec.getLowerRight())) {
                if (currentVelocity.getDy() < 0 &&
                        currentVelocity.getDx() > 0) {
                    vel.reverseX();
                }
                if (currentVelocity.getDy() > 0 &&
                        currentVelocity.getDx() < 0) {
                    vel.reverseY();
                }
            }
        }
        if (Math.abs(collisionPoint.getX() - rec.getUpperLeft().getX()) < k ||
                Math.abs(collisionPoint.getX() - rec.getUpperRight().getX()) < k) {
            vel.reverseX();
        }
        if (Math.abs(collisionPoint.getY() - rec.getUpperLeft().getY()) < k ||
                Math.abs(collisionPoint.getY() - rec.getLowerLeft().getY()) < k) {
            vel.reverseY();
        }
        this.notifyHit(hitter);
        return vel;
    }
}
