
public class Point {
    // field
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x point's x value
     * @param y point's y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point.
     *
     * @param other the point that we want to calculate the distance from our current point and this one
     * @return the distance from the point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt((other.getX() - x) *
                (other.getX() - x) +
                (other.getY() - y) *
                        (other.getY() - y));
    }

    /**
     * return true is the points are equal, false otherwise.
     *
     * @param other the point we want to compare with this point
     * @return true if they are equal otherwise false
     */
    public boolean equals(Point other) {
        return other.getX() == x &&
                other.getY() == y;
    }

    /**
     * returns the x value of the point.
     *
     * @return x value of the point
     */
    public double getX() {
        return x;
    }

    /**
     * returns the y value of the point.
     *
     * @return y value of the point
     */
    public double getY() {
        return y;
    }

}
