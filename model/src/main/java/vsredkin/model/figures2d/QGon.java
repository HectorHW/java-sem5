package vsredkin.model.figures2d;

import lombok.ToString;
import vsredkin.model.exceptions.PointAmountMismatchException;
import vsredkin.model.figures2d.helpers.annotations.Creatable;
import vsredkin.model.points.Point2D;

import java.util.Arrays;

@ToString
@Creatable
public class QGon extends vsredkin.model.figures2d.NGon {

    public QGon(){
        super();
    }

    public QGon(Point2D[] points) {
        super(points);
        if (points.length !=4) throw new PointAmountMismatchException();
    }


}
