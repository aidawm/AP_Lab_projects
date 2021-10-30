package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
/**
 * it hold information of a triangle
 */
public class Triangle {
    /// list of the sides of triangle
    private ArrayList<Integer> sides;
    /**
     * create a new instance of Triangle
     * @param sides sides of the triangle
     */
    public Triangle(Integer... sides) {
        this.sides = new ArrayList<>(Arrays.asList(sides));
    }
    /**
     * get sides of the triangle
     * @return sides field
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }
    /**
     * check the triangle is equilateral or not
     * @return true if is equilateral
     */
    public boolean isEquilateral() {
        int s = sides.get(0);
        for (int side : sides) {
            if (side != s)
                return false;
        }
        return true;
    }
    /**
     * calculate perimeter of the triangle
     * @return perimeter of the triangle
     */
    public double calculatePerimeter() {
        int perimeter = 0;
        for (int side : sides)
            perimeter += side;
        return perimeter;
    }
    /**
     * calculate area of the triangle
     * @return area of the triangle
     */
    public double calculateArea() {
        double s = this.calculatePerimeter()/2;
        double a=s;
        for (int side:sides)
            a*=(s-side);
        return Math.sqrt(a);
    }
    /**
     * draw a triangle (print sides,perimeter,area)
     */
    public void draw() {
        System.out.println("Triangle::  perimeter:" + this.calculatePerimeter() + " area:" + this.calculateArea());
    }
    /**
     * convert information of the triangle to sting
     * @return information of the triangle
     */
    @Override
    public String toString() {
        String str = "Triangle::  ";
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
        Triangle triangle = (Triangle) o;
        return Objects.equals(sides, triangle.sides);
    }
}
