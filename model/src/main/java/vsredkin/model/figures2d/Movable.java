package vsredkin.model.figures2d;

import vsredkin.model.points.Point2D;

public interface Movable {
    public Movable shift(Point2D a);

    public Movable rotate(double angle);

    public Movable symAxis(int i);
}
