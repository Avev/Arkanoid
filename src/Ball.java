
import biuoop.DrawSurface;

public class Ball implements Sprite {
    //field
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private int topFrame;
    private int bottomFrame;
    private int rightFrame;
    private int leftFrame;
    private GameEnvironment gameInv;

    // constructor

    /**
     * creates a ball object with a center point, radius and a color.
     * @param center the center point of the ball
     * @param r the radius of the ball
     * @param color the color of the ball
     * @param game the environment of the ball
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameInv = game;
    }
    /**
     * creates a ball object with a center point, radius and a color.
     * @param center the center point of the ball
     * @param r the radius of the ball
     * @param color the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * creates a ball object with x and y that are the center point of the ball, radius and a color.
     * @param x the x value of the center point
     * @param y the y value of the center point
     * @param r the radius of the ball
     * @param color the color of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    // accessors

    /**
     * returns the x value of the center point.
     * @return x value of the center point
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * returns the y value of the center point.
     * @return y value of the center point
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * returns the radius of the ball.
     * @return the radius of the ball
     */
    public int getSize() {
        return r;
    }

    /**
     * returns the color of the ball.
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * draws the ball on the given DrawSurface.
     * @param surface the surface the ball is drawn on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * sets the velocity of the ball from the input velocity.
     * @param vel the velocity of the ball
     */
    public void setVelocity(Velocity vel) {
        this.v = vel;
    }

    /**
     * sets the velocity of the ball from the input dx and dy.
     * @param dx the x we want to move the ball to
     * @param dy the y we want to move the ball to
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * returns the velocity of the ball.
     * @return the velocity of the ball
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * sets the ball's frames, the borders that he can't pass.
     * @param top the upper border
     * @param bottom the lower border
     * @param right the right border
     * @param left the left border
     */
    public void setFrames(int top, int bottom, int right, int left) {
        this.topFrame = top;
        this.bottomFrame = bottom;
        this.rightFrame = right;
        this.leftFrame = left;
    }

    /**
     * returns the top frame.
     * @return the top frame
     */
    public int getTopFrame() {
        return this.topFrame;
    }
    /**
     * returns the bottom frame.
     * @return the bottom frame
     */
    public int getBottomFrame() {
        return this.bottomFrame;
    }
    /**
     * returns the right frame.
     * @return the right frame
     */
    public int getRightFrame() {
        return this.rightFrame;
    }
    /**
     * returns the left frame.
     * @return the left frame
     */
    public int getLeftFrame() {
        return this.leftFrame;
    }

    /**
     * moves the ball one step
     * <p>
     *     the function checks the ball is gonig to cross one of his borders, if it will,
     *     then it changes the velocity's direction by changing it's dx or dy to it's minus.
     */
    public void moveOneStep() {
        Point end = getVelocity().applyToPoint(center);
        Line trajectory = new Line(center, end);
        CollisionInfo colInf = gameInv.getClosestCollision(trajectory);
        if (colInf == null) {
            center = end;
        } else {
            center = newFun(colInf.collisionPoint());
            v = colInf.collisionObject()
                    .hit(this, colInf.collisionPoint(), v);
        }
    }

    /**
     * takes the input speed and changes it in a way that the bigger
     *      the radius smaller the velocity caps at 50.
     * @param speed the speed of the ball
     * @return the speed by the ball's radius
     */
    public int getSpeed(int speed) {
        final int maxR = 50;
        final int speedFormula = speed + 100;
        if (r >= maxR) {
            return speedFormula / maxR;
        }
        return speedFormula / (r);
    }

    /**
     * checks if too add or subtract 1 from the point.
     * @param collision the collision point
     * @return point
     */
    public Point newFun(Point collision) {
        double signX = Math.signum(
                center.getX() - collision.getX());
        double signY = Math.signum(
                center.getY() - collision.getY());
        return new Point(collision.getX() + signX,
                collision.getY() + signY);
    }

    /**
     * adds the object to the game.
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * removes the ball from the game.
     * @param game the game the ball is in
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
