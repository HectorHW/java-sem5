package vsredkin.model.figures2d;

import lombok.ToString;
import vsredkin.model.exceptions.PointMisalignmentException;
import vsredkin.model.figures2d.helpers.Vector2D;
import vsredkin.model.figures2d.helpers.annotations.Creatable;
import vsredkin.model.points.Point2D;

import java.util.Arrays;

@ToString
@Creatable
public class Trapeze extends vsredkin.model.figures2d.QGon {

    public Trapeze(){
        super();
    }

    public Trapeze(Point2D[] points) {
        super(points);
        if(
            ! Vector2D.fromPoints(points[0], points[1]).isParallel(Vector2D.fromPoints(points[2], points[3]))
        ){
            throw new PointMisalignmentException();
        }
    }

    @Override
    public double area() {
        Vector2D h_direction = Vector2D.fromPoints(this.getPoint(0), this.getPoint(1)).constructPerpendicular();
        Vector2D side = Vector2D.fromPoints(this.getPoint(1), this.getPoint(2));
        Vector2D h = side.project(h_direction);
        double h_value = h.abs();

        double a = Vector2D.fromPoints(this.getPoint(0), this.getPoint(1)).abs();
        double b = Vector2D.fromPoints(this.getPoint(2), this.getPoint(3)).abs();
        return (a+b)/2 * h_value;
    }
}
