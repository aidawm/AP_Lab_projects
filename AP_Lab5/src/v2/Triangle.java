package v2;


import java.util.Objects;
/**
 * it hold information of a triangle
 */

public class Triangle extends Polygon{
    /**
     * create a new instance of Triangle
     * @param sides sides of the triangle
     */
    public Triangle(Integer... sides){
        super(sides);
        isTriangle(sides);
    }
//    public boolean isEquilateral() {
//        int s = super.getSides().get(0);
//        for (int side : super.getSides()) {
//            if (side != s)
//                return false;
//        }
//        return true;
//    }

    /**
     * check the sides could draw a triangle or not
     * @param sides sides of the triangle
     * @return true if could draw
     */
    private boolean isTriangle(Integer... sides){
        if(sides.length != 3){
            System.out.println("triangle must have 3 sides!");
            return false;
        }
        if(sides[0]<sides[1]+sides[2]&& sides[1]<sides[0]+sides[2] &&sides[2]<sides[1]+sides[0])
            return true;
        else {
            System.out.println("couldn't draw a triangle with this sides");
            return false;
        }

    }
    /**
     * draw a triangle (print sides,perimeter,area)
     */
    @Override
    public void draw() {
        System.out.println("Triangle::  perimeter:" + this.calculatePerimeter() + " area:" + this.calculateArea());
    }
    /**
     * calculate area of the triangle
     * @return area of the triangle
     */
    @Override
    public double calculateArea() {
        double s = this.calculatePerimeter()/2;
        double a=s;
        for (int side:super.getSides())
            a*=(s-side);
        return Math.sqrt(a);
    }
    /**
     * convert information of the triangle to sting
     * @return information of the triangle
     */
    @Override
    public String toString(){
        return "Triangle:: "+super.toString();
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
        v1.Triangle triangle = (v1.Triangle) o;
        return Objects.equals(super.getSides(), triangle.getSides());
    }
}
