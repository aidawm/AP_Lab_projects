package v2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * it hold information of a polygon
 */
public class Polygon extends Shape{
    /// list of the sides of polygon
    private ArrayList<Integer> sides;

    /**
     * create a new instance of polygon
     * @param sides sides of the polygon
     */
    public Polygon(Integer... sides){
        this.sides= new ArrayList<>(Arrays.asList(sides));
    }
    /**
     * get sides of the polygon
     * @return sides field
     */
    public ArrayList<Integer> getSides(){
        return sides;
    }

    /**
     * check if the polygon is regular
     * @return true if is regular
     */
    public boolean isRegular() {
        int s = sides.get(0);
        for (int side : sides) {
            if (side != s)
                return false;
        }
        return true;
    }
    /**
     * calculate perimeter of the polygon
     * @return perimeter of the polygon
     */
    @Override
    public double calculatePerimeter(){
        int perimeter=0;
        for (int side:sides)
            perimeter+=side;
        return perimeter;
    }
    /**
     * convert information of the polygon to sting
     * @return information of the polygon
     */
    @Override
    public String toString(){
        String str ="";
        for (int i=1;i<=sides.size();i++){
            str+="side"+i+":"+sides.get(i-1);
            if(i!=sides.size())
                str+=", ";
        }
        return str;
    }
}
