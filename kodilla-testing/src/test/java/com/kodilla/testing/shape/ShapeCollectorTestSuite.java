package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);

        //When
        shapeCollector.addFigure(triangle);

        //Then
        Assert.assertEquals(1, shapeCollector.getShapes().size());
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);
        shapeCollector.addFigure(triangle);

        //When
        Shape retrievedFigure;
        retrievedFigure = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(triangle, retrievedFigure);
    }

    @Test
    public void testGetFigureArea(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);
        shapeCollector.addFigure(triangle);

        //When
        Shape retrievedFigure;
        retrievedFigure = shapeCollector.getFigure(0);
        double retrievedArea = retrievedFigure.getArea();

        //Then
        Assert.assertTrue(retrievedArea == 4);
    }

    @Test
    public void testRemoveFigureNotExisting(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);
        shapeCollector.addFigure(triangle);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4, 2);
        Circle circle = new Circle(10);
        Square square = new Square(4);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);

        //When
        List<Shape> expectedList= new ArrayList<>();
        expectedList.add(triangle);
        expectedList.add(circle);
        expectedList.add(square);

        //Then
        Assert.assertEquals(expectedList, shapeCollector.getShapes());
    }
}
