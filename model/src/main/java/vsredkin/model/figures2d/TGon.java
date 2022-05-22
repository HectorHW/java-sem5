package vsredkin.model.figures2d;

import lombok.ToString;
import vsredkin.model.exceptions.PointAmountMismatchException;
import vsredkin.model.figures2d.helpers.annotations.Creatable;
import vsredkin.model.points.Point2D;

import java.util.Arrays;

@ToString
@Creatable
public class TGon extends vsredkin.model.figures2d.NGon {

    public TGon(){
        super();
    }

    public TGon(Point2D[] points) {
        super(points);
        if (points.length!=3) throw new PointAmountMismatchException();
    }

    @Override
    public double area() {
        double a = this.getPoint(0).sub(this.getPoint(1)).abs();
        double b = this.getPoint(0).sub(this.getPoint(2)).abs();
        double c = this.getPoint(1).sub(this.getPoint(2)).abs();

        //формула Герона

        double p = (a+b+c)/2;

        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }
}
