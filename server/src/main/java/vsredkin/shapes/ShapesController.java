package vsredkin.shapes;

import one.util.streamex.EntryStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import vsredkin.model.figures2d.Shape;
import vsredkin.shapes.data.NamedShape;
import vsredkin.shapes.data.ShapeOut;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapesController {
    @Autowired
    private ShapeRepository shapes;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShapeOut> getShapes() {
        return with_name(this.shapes.list());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShapeOut> addShape(@RequestBody Shape s){
        this.shapes.add(s);
        return with_name(this.shapes.list());
    }

    @DeleteMapping
    public void dropShapes(){
        this.shapes.clear();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShapeOut getConcreteShapeData(@PathVariable int id) {
        try{
            return ShapeOut.fromShape(this.shapes.getOrError(id), id);
        }catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id}/area", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getShapeArea(@PathVariable int id) {
        try{
            return this.shapes.getOrError(id).area();
        }catch(IndexOutOfBoundsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id}/perimeter", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getShapePerimeter(@PathVariable int id) {
        try{
            return this.shapes.getOrError(id).length();
        }catch(IndexOutOfBoundsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShapeOut> deleteShape(@PathVariable int id) {
        try{
            this.shapes.delete(id);
            return with_name(this.shapes.list());
        }catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public static List<ShapeOut> with_name(List<Shape> shapes){
        return EntryStream.of(shapes).mapKeyValue ((i, s) -> ShapeOut.fromShape(s, i)).toList();
    }
}
