package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    public int getShapesQuantity(){
        return shapes.size();
    }

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(shapes.contains(shape)){
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        Shape shape = null;
        if(n >= 0 && n < shapes.size()) {
            shape = shapes.get(n);
        }
        return shape;
    }

    public List<Shape> showFigures(){
        return null;
    }

}
