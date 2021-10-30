package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
/**
 * it hold information of a rectangle
 */
public class Rectangle {
    /// list of the sides of rectangle
    private ArrayList<Integer> sides;
    /**
     * create a new instance of Rectangle
     * @param sides sides of the rectangle
     */
    public Rectangle(Integer... sides) {
        this.sides = new ArrayList<>(Arrays.asList(sides));
    }
    /**
     * get sides of the rectangle
     * @return sides field
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check the rectangle is square or not
     * @return true if is square
     */
    public boolean isSquare() {
        int s = sides.get(0);
        for (int side : sides) {
            if (side != s)
                return false;
        }
        return true;
    }
    /**
     * calculate perimeter of the rectangle
     * @return perimeter of the rectangle
     */
    public double calculatePerimeter() {
        int perimeter = 0;
        for (int side : sides)
            perimeter += side;
        return perimeter;
    }
    /**
     * calculate area of the rectangle
     * @return area of the rectangle
     */
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     *  (print sides,perimeter,area)
     */
    public void draw() {
        System.out.println("Rectangle::  perimeter:" + this.calculatePerimeter() + " area:" + this.calculateArea());
    }
    /**
     * convert information of the rectangle to sting
     * @return information of the rectangle
     */
    @Override
    public String toString() {
        String str = "Rectangle::  ";
        for (int i = 1; i <= sides.size(); i++) {
            str += "side" + i + ":" + sides.get(i - 1);
            if (i != sides.size())
                str += ", ";
        }
        return str;
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
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(sides, rectangle.sides);
    }
}
