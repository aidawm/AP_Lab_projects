import java.util.Objects;

/**
 * its hold the information of a vote (voter+date)
 */
public class Vote {
    /// voter information
    private Person person;
    /// vote date
    private String date;

    /**
     * create a instance of Vote
     * @param person voter information
     * @param date vote date
     */
    public Vote(Person person, String date){
        this.person=person;
        this.date=date;
    }

    /**
     * get voter information
     * @return person field
     */
    public Person getPerson(){
        return person;
    }
    /**
     * get vote date
     * @return date field
     */
    public String getDate(){
        return date;
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
        Vote vote = (Vote) o;
        return Objects.equals(person, vote.person) &&
                Objects.equals(date, vote.date);
    }
}
