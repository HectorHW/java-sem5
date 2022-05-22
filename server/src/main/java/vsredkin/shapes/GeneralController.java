package vsredkin.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vsredkin.model.figures2d.Shape;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {
    @Autowired
    private ShapeRepository shapes;

    @GetMapping(value = "/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shape> getShapes() {
        return this.shapes.list();
    }

    @PostMapping(value = "/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shape> uploadShapes(@RequestBody Shape[] shapes) {
        this.shapes.set(Arrays.stream(shapes).toList());
        return this.shapes.list();
    }
}
