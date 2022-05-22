package vsredkin.shapes.data;

import lombok.Getter;
import vsredkin.model.figures2d.Shape;

public record NamedShape(Shape shape, String name, int idx) {

}
