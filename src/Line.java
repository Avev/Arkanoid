//ID: 316266683
import java.util.List;
/**
 * @author Aviv Rahamim
 */
public class Line {
    // field
    private Point start;
    private Point end;

    // constructors

    /**
     * creates a line from 2 points.
     * @param start the starting point of the line
     * @param end the ending point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * creates a line from x1,y1 and x2,y2.
     * @param x1 x value of the first point
     * @param y1 y value of the first point
     * @param x2 x value of the second point
     * @param y2 y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * returns the length of the line.
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * returns the middle point of the line.
     * @return the middle point of the line
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    /**
     *returns the start point of the line.
     * @return starting point of the line
     */
    public Point start() {
        return start;
    }

    /**
     *returns the end point of the line.
     * @return ending point of the line
     */
    public Point end() {
        return end;
    }

    /**
     *checks if the line and the line in the input intersect.
     * @param other the line we want to check if our line intersecting with
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * checks if the line and the input line intersect.
     * <p>
     *     the function first checks if the lines are vertical, and then checks their range to see if they intersect
     *     if the lines are not vertical it checks for their slopes and if their intersection point is in the lines
     *     range
     * @param other the line we want to search his intersection point with our line if there is one
     * @return the intersection point if there is one, null otherwise
     */
    public Point intersectionWith(Line other) {
        double k = 0.1;
        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = other.start.getX();
        double x4 = other.end.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = other.start.getY();
        double y4 = other.end.getY();
        if (Math.abs(x1 - x2) < k ||
                Math.abs(x3 - x4) < k) {
            if (Math.abs(x1 - x2) < k &&
                    Math.abs(x3 - x4) < k) {
                if (Math.abs(x1 - x3) < k) {
                    if (Math.abs(y1 - y3) < k ||
                            Math.abs(y2 - y4) < k) {
                        if (y2 + k > y1 &&
                                y4 < y3 + k) {
                            return start;
                        }
                        if (y2 < y1 + k &&
                                y4 + k > y3) {
                            return start;
                        }
                    }
                }
                return null;
            }
            if (Math.abs(x1 - x2) < k) {
                double slope2 = calcSlope(other);
                double c2 = (-1) *
                        other.start.getX() *
                        slope2 +
                        other.start.getY();
                if ((x3 + k >= x1 && x4 <= x1 + k) ||
                        (x3 <= x1 + k && x4 + k >= x1)) {
                    if (y3 + k >= y1 &&
                            y4 <= y2 + k) {
                        return new Point(x1, x1 * slope2 + c2);
                    }
                    if (y4 <= y1 + k &&
                            y3 + k >= y2) {
                        return new Point(x1, x1 * slope2 + c2);
                    }
                }
            }
            if (Math.abs(x3 - x4) < k) {
                double slope1 = calcSlope(this);
                double c1 = (-1) *
                        start.getX() *
                        slope1 +
                        start.getY();
                if ((x1 + k >= x3 && x2 <= x3 + k) ||
                        (x1 <= x3 + k && x2 + k >= x3)) {
                    if (y1 + k >= y4 &&
                            y2 <= y3 + k) {
                        return new Point(x3, x2 * slope1 + c1);
                    }
                    if (y2 <= y4 + k &&
                            y1 + k >= y3) {
                        return new Point(x3, x2 * slope1 + c1);
                    }
                }
            }
        }
        double slope1 = calcSlope(this);
        double slope2 = calcSlope(other);
        double c1 = (-1) *
                start.getX() *
                slope1 +
                start.getY();

        double c2 = (-1) *
                other.start.getX() *
                slope2 +
                other.start.getY();

        if (Math.abs(slope1 - slope2) < k) {
            if (start.equals(other.start) &&
                    ((x2 <= x1 + k && x4 + k >= x3) ||
                            (x2 + k >= x1 && x4 <= x3 + k))) {
                return start;
            }
            if (end.equals(other.end) &&
                    ((x1 <= x2 + k && x3 + k >= x4) ||
                            (x1 + k >= x2 && x3 <= x4 + k))) {
                return end;
            }
            if (start.equals(other.end) &&
                    ((x2 <= x1 + k && x3 + k >= x4) ||
                            (x2 + k >= x1 && x3 <= x4 + k))) {
                return start;
            }
            if (end.equals(other.start) &&
                    ((x1 <= x2 + k && x4 + k >= x3) ||
                            (x1 + k >= x2 && x4 <= x3 + k))) {
                return end;
            }
            return null;
        }
        double x = (c1 - c2) / (slope2 - slope1);
        double y = (c1 * slope2 - c2 * slope1) / (slope2 - slope1);
        Point intersection = new Point(x, y);
        double xi = intersection.getX();
        double yi = intersection.getY();
        if ((x1 <= xi + k && xi <= x2 + k) ||
                (x2 <= xi + k && xi <= x1 + k)) {

            if ((y1 <= yi + k && yi <= y2 + k) ||
                    (y2 <= yi + k && yi <= y1 + k)) {

                if ((x3 <= xi + k && xi <= x4 + k) ||
                        (x4 <= xi + k && xi <= x3 + k)) {

                    if ((y3 <= yi + k && yi <= y4 + k) ||
                            (y4 <= yi + k && yi <= y3 + k)) {

                        return intersection;
                    }
                }
            }
        }
        return null;
    }

    /**
     * checks if the line and the input line are identical, if they have the same start and end points.
     * @param other the line we want to compare our line to
     * @return true if the lines are identical, false otherwise
     */
    public boolean equals(Line other) {
        return start.equals(other.start) &&
                end.equals(other.end);
    }

    // help functions

    /**
     * calculates the slope of a line.
     * @param other the line we want to calculates it's slope
     * @return the slope of the line in the input
     */
    public double calcSlope(Line other) {
        return (other.start.getY() - other.end.getY()) /
                (other.start.getX() - other.end.getX());
    }



    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     * @param rect rectangle
     * @return point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point closest = null;
        List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null;
        }
        for (Point p: points) {
            if (closest == null) {
                closest = p;
            }
            if (closest.distance(start) > p.distance(start)) {
                closest = p;
            }
        }
        return closest;
    }
}
