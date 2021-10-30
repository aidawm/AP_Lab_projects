package v2;

import java.util.ArrayList;
/**
 * it holds the different shapes
 */
public class Paint {
    /// list of shapes
    private ArrayList<Shape> shapes;
    /**
     * create a instance of pain
     */
    public Paint(){
        shapes=new ArrayList<>();
    }
    /**
     * add a new shape to the list
     * @param shape
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    /**
     * draw all of the shapes
     */
    public void drawAll(){
        System.out.println("-------------drawAll-------------");
        for (Shape shape:shapes){
            shape.draw();
        }
    }
    /**
     * print the information of the shapes
     */
    public void printAll(){
        System.out.println("-------------printAll-------------");
        for (Shape shape:shapes){
            System.out.println(shape);
        }
    }

    /**
     * found a EqualSides shapes
     */
    public void describeEqualSides(){
        System.out.println("-------------describeEqualSides-------------");
        for (Shape shape:shapes){
            if(shape instanceof Triangle || shape instanceof Rectangle){
                if(((Polygon) shape).isRegular()){
                    System.out.println(shape);
                }
            }
        }
    }
}
