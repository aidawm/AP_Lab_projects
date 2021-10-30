package v1;

import java.util.ArrayList;

/**
 * it holds the different shapes
 */
public class Paint {
    /// list of circles
    private ArrayList<Circle> circles;
    /// list of triangles
    private ArrayList<Triangle> triangles;
    /// list of rectangles
    private ArrayList<Rectangle> rectangles;

    /**
     * create a instance of pain
     */
    public Paint(){
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * add a new triangle to the list
     * @param triangle
     */
    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }
    /**
     * add a new circle to the list
     * @param circle
     */
    public void addCircle(Circle circle){
        circles.add(circle);
    }
    /**
     * add a new rectangle to the list
     * @param rectangle
     */
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }

    /**
     * draw all of the shapes
     */
    public void drawAll(){
        for (Circle circle : circles)
            circle.draw();
        for (Rectangle rectangle:rectangles)
            rectangle.draw();
        for (Triangle triangle:triangles)
            triangle.draw();
    }

    /**
     * print the information of the shapes
     */
    public void printAll(){
        for (Circle circle : circles)
            System.out.println(circle);
        for (Rectangle rectangle:rectangles)
            System.out.println(rectangle);
        for (Triangle triangle:triangles)
            System.out.println(triangle);
    }
}
