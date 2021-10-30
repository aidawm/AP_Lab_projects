package v2;
/**
 * it hold information of a circl
 */
public class Circle extends Shape{
    /// radius of circle
    private int radius;
    /**
     * create a new instance of Circle
     * @param radius radius of the circle
     */

    public Circle(int radius){
        this.radius=radius;
    }
    /**
     * get radius of the circle
     * @return radius field
     */
    public int getRadius(){
        return radius;
    }
    /**
     * calculate perimeter of the circle
     * @return perimeter of the circle
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    /**
     * calculate area of the circle
     * @return area of the circle
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    /**
     * draw a circle (print radius,perimeter,area)
     */
    @Override
    public void draw() {
        System.out.println("Circle::  perimeter:" + this.calculatePerimeter() + " area:" + this.calculateArea());
    }
    /**
     * convert information of the circle to sting
     * @return information of the circle
     */
    @Override
    public String toString() {
        return "Circle::  radius:" + radius;
    }
}
