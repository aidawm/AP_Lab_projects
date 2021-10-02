/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 */

public class Student {

    // The student's first name
    private String fistName;
    // The student's last name
    private String lastName;
    // The student's ID
    private String id;
    // The student's grade
    private int grade;

    /**
     *  Create a new student with a given name and ID number.
     * @param fName first name of students
     * @param lName last name of students
     * @param sID   ID of students
     */
    public Student(String fName , String lName,String sID){
        fistName=fName;
        lastName=lName;
        id=sID;
        grade=0;
    }

    /**
     *get the first name of student
     * @return  firstName field
     */
    public String getFistName(){
        return fistName;
    }

    /**
     * @param fName set first name of a student
     */
    public void setFistName(String fName){
        fistName=fName;
    }

    /**
     * get the last name of student
     * @return lastName field
     */
    public String getLastName(){
        return lastName;
    }

    /**
     *
     * @param lName set last name of a student
     */
    public void setLastName(String lName){
        lastName=lName;
    }

    /**
     * get the id of a student
     * @return id field
     */
    public String getId(){
        return id;
    }

    /**
     * set and check the student id
     * @param sID set student id
     */
    public void setId(String sID){
        if(sID.length()==7)
            id=sID;
        else
            System.out.println("student id must have 7 digits");
    }

    /**
     * get the grade of student
     * @return grade
     */
    public int getGrade(){
        return grade;
    }

    /**
     * grade must be positive
     * @param sGrade set grade of student
     */
    public void setGrade(int sGrade){
        if(sGrade>0){
            grade=sGrade;
        }
        else {
            System.out.println("unvalid grade");
        }
    }

    /**
     * print student's information
     */
    public void print(){
        System.out.println(fistName+" "+lastName+", student ID="+id+", grade="+grade);
    }
}
