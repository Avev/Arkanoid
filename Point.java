//ID: 316266683
/**
 * @author Aviv Rahamim
 */
public class Point {
    // field
    private double x;
    private double y;

    // constructor

    /**
     * the constructor, receives the point's x and y to know where it sits.
     * @param x point's x value
     * @param y point's y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // distance -- return the distance of this point to the other point

    /**
     * calculates the distance between 2 points and returns it.
     * @param other the point that we want to calculate the distance from our current point and this one
     * @return the distance from the point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt((other.getX() - x) * (other.getX() - x) + (other.getY() - y) * (other.getY() - y));
    }

    // equals -- return true is the points are equal, false otherwise

    /**
     * checks if this point and the input point are equal.
     * @param other the point we want to compare with this point
     * @return true if they are equal otherwise false
     */
    public boolean equals(Point other) {
        return other.getX() == x && other.getY() == y;
    }

    // Return the x and y values of this point

    /**
     * returns the x value of the point.
     * @return x value of the point
     */
    public double getX() {
        return x;
    }

    /**
     * returns the y value of the point.
     * @return y value of the point
     */
    public double getY() {
        return y;
    }

}
