package v1;

/**
 * it hold information of a circl
 */
public class Circle {
    /// radius of circle
    private int radius;

    /**
     * create a new instance of Circle
     * @param redius radius of the circle
     */
    public Circle(int redius) {
        this.radius = redius;
    }

    /**
     * get radius of the circle
     * @return radius field
     */
    public int getRadius() {
        return radius;
    }

    /**
     * calculate perimeter of the circle
     * @return perimeter of the circle
     */
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * calculate area of the circle
     * @return area of the circle
     */
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * draw a circle (print radius,perimeter,area)
     */
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

    /**
     * check the 2 object are equal or not
     * @param o second object
     * @return true if are equal , false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

}
