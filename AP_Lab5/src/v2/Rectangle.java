package v2;

import v1.Paint;

import java.util.Objects;
/**
 * it hold information of a rectangle
 */
public class Rectangle extends Polygon {
    /**
     * create a new instance of Rectangle
     * @param sides sides of the rectangle
     */
    public Rectangle(Integer... sides){
        super(sides);

    }
    /**
     * check the sides could draw a rectangle or not
     * @param sides sides of the rectangle
     * @return true if could draw
     */
    private boolean isRectangle(Integer... sides){
        if(sides.length != 4) {
            System.out.println("rectangle must have 4 sides!");
            return false;
        }
        if(sides[0].equals(sides[2]) && sides[1].equals(sides[3]))
            return true;
        else {
            System.out.println("it isn't a rectangle!");
            return false;
        }
    }
    /**
     * calculate area of the rectangle
     * @return area of the rectangle
     */
    @Override
    public double calculateArea() {
        return super.getSides().get(0) * super.getSides().get(1);
    }
    /**
     * draw a rectangle (print sides,perimeter,area)
     */
    @Override
    public void draw() {
        System.out.println("Rectangle::  perimeter:" + this.calculatePerimeter() + " area:" + this.calculateArea());
    }
    /**
     * convert information of the rectangle to sting
     * @return information of the rectangle
     */
    @Override
    public String toString(){
        return "Rectangle:: "+super.toString();
    }
    /**
     * check the 2 object are equal or not
     * @param o second object
     * @return true if are equal , false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        v1.Rectangle rectangle = (v1.Rectangle) o;
        return Objects.equals(super.getSides(), rectangle.getSides());
    }

}
