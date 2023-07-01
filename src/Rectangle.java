
import java.util.List;
import java.util.ArrayList;
/**
 * @author Aviv Rahamim
 */
public class Rectangle {
    // field
    private Point upperLeft;
    private double width;
    private double height;

    // constructor

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft upper left point
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * returns a list of intersection points with the rectangle.
     *
     * @param line line
     * @return list of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<>();
        if (line.isIntersecting(getUpper())) {
            points.add(line.intersectionWith(getUpper()));
        }
        if (line.isIntersecting(getLower())) {
            points.add(line.intersectionWith(getLower()));
        }
        if (line.isIntersecting(getRight())) {
            points.add(line.intersectionWith(getRight()));
        }
        if (line.isIntersecting(getLeft())) {
            points.add(line.intersectionWith(getLeft()));
        }
        return points;
    }

    // Return the width and height of the rectangle

    /**
     * returns the width of the rectangle.
     *
     * @return width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * returns the height of the rectangle.
     *
     * @return height of the rectangle
     */
    public double getHeight() {
        return height;
    }


    // Returns the points of the rectangle.

    /**
     * returns the upper left point of the rectangle.
     *
     * @return upper left point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * returns the upper right point of the rectangle.
     *
     * @return upper right point
     */
    public Point getUpperRight() {
        return new Point(getUpperLeft().getX() + getWidth(), getUpperLeft().getY());
    }

    /**
     * returns the lower left point of the rectangle.
     *
     * @return lower left point
     */
    public Point getLowerLeft() {
        return new Point(getUpperLeft().getX(), getUpperLeft().getY() + getHeight());
    }

    /**
     * returns the lower right point of the rectangle.
     *
     * @return lower right point
     */
    public Point getLowerRight() {
        return new Point(getUpperLeft().getX() + getWidth(),
                getUpperLeft().getY() + getHeight());
    }

    // Returns the lines of the rectangle.

    /**
     * returns the upper line of the rectangle.
     *
     * @return upper line
     */
    public Line getUpper() {
        return new Line(getUpperLeft(), getUpperRight());
    }

    /**
     * returns the lower line of the rectangle.
     *
     * @return lower line
     */
    public Line getLower() {
        return new Line(getLowerLeft(), getLowerRight());
    }

    /**
     * returns the right line of the rectangle.
     *
     * @return right line
     */
    public Line getRight() {
        return new Line(getUpperRight(), getLowerRight());
    }

    /**
     * returns the left line of the rectangle.
     *
     * @return left line
     */
    public Line getLeft() {
        return new Line(getUpperLeft(), getLowerLeft());
    }
}
