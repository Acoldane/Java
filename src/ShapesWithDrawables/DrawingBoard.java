package ShapesWithDrawables;

import java.util.ArrayList;
import java.util.List;

public class DrawingBoard {
    List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public DrawingBoard(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void DisplayAllShapesType(){
        for (Shape shape : this.shapes){
            shape.displayShapeType();
        }
    }
}
