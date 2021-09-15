//ID: 316266683
import biuoop.DrawSurface;
import java.awt.Color;
import biuoop.KeyboardSensor;
/**
 * @author Aviv Rahamim
 */
public class Paddle implements Sprite, Collidable {
    // field
    private KeyboardSensor keyboard;
    private double paddleW;
    private int paddleH;
    private Rectangle rec;
    private int height;
    private int width;
    private int step;
    private Point upperLeft;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;

    // constructor

    /**
     * constructor for the paddle.
     *
     * @param keyboardSensor gui
     * @param speed          speed
     * @param width          width
     */
    public Paddle(KeyboardSensor keyboardSensor, int speed, int width) {
        this.height = 600;
        this.width = 800 - 15;
        this.keyboard = keyboardSensor;
        this.paddleW = width;
        this.paddleH = 10;
        this.step = speed;
        this.upperLeft = new Point(200, 560);
        this.p2 = new Point(upperLeft.getX() + paddleW / 5, 560);
        this.p3 = new Point(upperLeft.getX() + 2 * paddleW / 5, 560);
        this.p4 = new Point(upperLeft.getX() + 3 * paddleW / 5, 560);
        this.p5 = new Point(upperLeft.getX() + 4 * paddleW / 5, 560);
        this.p6 = new Point(upperLeft.getX() + 5 * paddleW / 5, 560);
        this.rec = new Rectangle(upperLeft, paddleW, paddleH);
    }

    /**
     * moves the paddle to the left.
     */
    public void moveLeft() {
        if (rec.getUpperLeft().getX() - step >= 15) {
            Point newUpperLeft = new Point(
                    rec.getUpperLeft().getX() - step,
                    rec.getUpperLeft().getY());

            this.rec = new Rectangle(newUpperLeft, paddleW, paddleH);
            this.upperLeft = newUpperLeft;
            this.p2 = new Point(newUpperLeft.getX() + paddleW / 5, 560);
            this.p3 = new Point(newUpperLeft.getX() + 2 * paddleW / 5, 560);
            this.p4 = new Point(newUpperLeft.getX() + 3 * paddleW / 5, 560);
            this.p5 = new Point(newUpperLeft.getX() + 4 * paddleW / 5, 560);
            this.p6 = new Point(newUpperLeft.getX() + 5 * paddleW / 5, 560);
        }
    }

    /**
     * moves the paddle to the right.
     */
    public void moveRight() {
        if (rec.getUpperLeft().getX() + paddleW <= width) {
            Point newUpperLeft = new Point(
                    rec.getUpperLeft().getX() + step,
                    rec.getUpperLeft().getY());

            this.rec = new Rectangle(newUpperLeft, paddleW, paddleH);
            this.upperLeft = newUpperLeft;
            this.p2 = new Point(newUpperLeft.getX() + paddleW / 5, 560);
            this.p3 = new Point(newUpperLeft.getX() + 2 * paddleW / 5, 560);
            this.p4 = new Point(newUpperLeft.getX() + 3 * paddleW / 5, 560);
            this.p5 = new Point(newUpperLeft.getX() + 4 * paddleW / 5, 560);
            this.p6 = new Point(newUpperLeft.getX() + 5 * paddleW / 5, 560);
        }
    }

    // Sprite

    /**
     * checks if the user used the right or the left arrow.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * draws the paddle.
     *
     * @param d surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle(
                (int) rec.getUpperLeft().getX(),
                (int) rec.getUpperLeft().getY(),
                (int) paddleW, paddleH);
    }

    // Collidable

    /**
     * returns the rectangle the ball collides with.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    /**
     * notify the object that it get hit.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the hitting ball
     * @return velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity vel = new Velocity(currentVelocity);
        if (collisionPoint.getY() == rec.getUpperLeft().getY()) {
            if (collisionPoint.getX() >= upperLeft.getX() &&
                    collisionPoint.getX() < p2.getX()) {
                vel = new Velocity(Velocity.fromAngleAndSpeed(300,
                        Math.sqrt(currentVelocity.getDx() *
                                currentVelocity.getDx() +
                                currentVelocity.getDy() *
                                        currentVelocity.getDy())));
            }
            if (collisionPoint.getX() >= p2.getX() &&
                    collisionPoint.getX() < p3.getX()) {
                vel = new Velocity(Velocity.fromAngleAndSpeed(330,
                        Math.sqrt(currentVelocity.getDx() *
                                currentVelocity.getDx() +
                                currentVelocity.getDy() *
                                        currentVelocity.getDy())));
            }
            if (collisionPoint.getX() >= p3.getX() &&
                    collisionPoint.getX() < p4.getX()) {
                vel = new Velocity(Velocity.fromAngleAndSpeed(0,
                        Math.sqrt(currentVelocity.getDx() *
                                currentVelocity.getDx() +
                                currentVelocity.getDy() *
                                        currentVelocity.getDy())));
            }
            if (collisionPoint.getX() >= p4.getX() &&
                    collisionPoint.getX() < p5.getX()) {
                vel = new Velocity(Velocity.fromAngleAndSpeed(30,
                        Math.sqrt(currentVelocity.getDx() *
                                currentVelocity.getDx() +
                                currentVelocity.getDy() *
                                        currentVelocity.getDy())));
            }
            if (collisionPoint.getX() >= p5.getX() &&
                    collisionPoint.getX() <= p6.getX()) {
                vel = new Velocity(Velocity.fromAngleAndSpeed(60,
                        Math.sqrt(currentVelocity.getDx() *
                                currentVelocity.getDx() +
                                currentVelocity.getDy() *
                                        currentVelocity.getDy())));
            }
        }
        return vel;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
