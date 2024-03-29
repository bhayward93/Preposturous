package dataStructures;

/**
 * A data class to store the results of the measurements between two points.
 * Stores the points and the distance and angle between them.
 */
public class PointMeasurement {
    private Point p1;
    private Point p2;
    private double distance;
    private double angle;

    public PointMeasurement(Point p1, Point p2, double distance, double angle) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
        this.angle = angle;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
