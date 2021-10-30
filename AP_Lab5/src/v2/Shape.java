package v2;
/**
 * it hold information of a shape
 */
public class Shape {
    /**
     * calculate perimeter of the shape
     * @return perimeter of the shape
     */
    public double calculatePerimeter(){
        return -1;
    }
    /**
     * calculate area of the shape
     * @return area of the shape
     */
    public double calculateArea(){
        return -1;
    }

    /**
     * draw a shape
     */
    public void draw(){
        System.out.println("drawing a shape :)");
    }

    /**
     * convert information of the shape to sting
     * @return information of the shape
     */
    @Override
    public String toString(){
        return "shape's information";
    }
}
