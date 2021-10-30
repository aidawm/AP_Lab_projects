/**
 * it holds the voter info
 */
public class Person {
    /// voter's first name
    private String firstName;
    /// voter's last name
    private String lastName;

    /**
     * create a new voter
     * @param firstName voter's first name
     * @param lastName voter's last name
     */
    public Person(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * get voter's first name
     * @return firstName field
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * get voter's last name
     * @return lastName field
     */
    public String getLastNAme(){
        return lastName;
    }

    /**
     * convert the voter's info to string
     * @return string of first name and last name
     */
    public String toString(){
        return firstName+" "+lastName ;
    }
}
