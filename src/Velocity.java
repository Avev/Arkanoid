
// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    /**
     * receives velocity inputs for angle and speed and converts them to dx and dy.
     *
     * @param angle the angle the user wants the object to move
     * @param speed the speed the user wants the object to move
     * @return the Velocity after the conversion
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double myAngle = angle - 90;
        double dx = speed * Math.cos(Math.toRadians(myAngle));
        double dy = speed * Math.sin(Math.toRadians(myAngle));
        return new Velocity(dx, dy);
    }

    //field
    private double dx;
    private double dy;

    // constructor

    /**
     * velocity copy constructor.
     *
     * @param vel velocity
     */
    public Velocity(Velocity vel) {
        this.dx = vel.getDx();
        this.dy = vel.getDy();
    }

    /**
     * receives the change in x and y for the object to know where to move him.
     *
     * @param dx the next x the object moves to
     * @param dy the next y the object moves to
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * returns the x value of the Velocity, the X that the object want to move to.
     *
     * @return dx value
     */
    public double getDx() {
        return dx;
    }

    /**
     * returns the y value of the Velocity, the X that the object want to move to.
     *
     * @return dy value
     */
    public double getDy() {
        return dy;
    }


    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the point we want to move
     * @return the point at it's new location
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * multiply the dx by -1.
     */
    public void reverseX() {
        this.dx *= -1;
    }

    /**
     * multiply the dy by -1.
     */
    public void reverseY() {
        this.dy *= -1;
    }
}

