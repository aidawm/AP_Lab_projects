import ir.huri.jcal.JalaliCalendar;

import java.lang.reflect.Array;
import java.util.*;

/**
 * it's hold the voting information (question,polls,voters,...)
 */
public class Voting {
    /// type of the voting (single or multiple)
    private int type;
    /// the question of voting
    private String question;
    /// voter's information list
    private ArrayList<Person> voters = new ArrayList<>();
    /// collection of the voting result
    private HashMap<String, HashSet<Vote>> polls;
    /// it define voting date
    private String today;

    /**
     * create a instance of Voting class
     * @param type type of the voting (single or multiple)
     * @param question the question of voting
     */
    public Voting(int type ,String question){
        this.type=type;
        this.question=question;
        polls=new HashMap<>();
        JalaliCalendar date = new JalaliCalendar();
        today = date.toString();
    }

    /**
     * get the voting's question
     * @return question field
     */
    public String getQuestion(){
        return question;
    }

    /**
     * create a new poll of voting
     * @param poll the voting's poll
     */
    public void createPoll(String poll){
        polls.put(poll,new HashSet<>());
    }

    /**
     * create new vote for voting
     * if voter have voted , ignore the vote
     * if type=0 and votes have more than 1 elements , ignore them
     * @param person voter's information
     * @param votes votes list
     */
    public void vote(Person person , ArrayList<String> votes){
        Vote vote = new Vote(person,today);
        votes= checkVoteBeQualified(votes,vote);
        votes= randomVote(votes);
        System.out.println(votes);
        if(votes!=null) {
            for (String v : votes) {
                if(!polls.containsKey(v))
                    continue;
                HashSet<Vote> voteList = new HashSet<>(polls.get(v));
                voteList.add(vote);
                polls.put(v, voteList);
                voters.add(person);
            }
        }
    }

    /**
     * print voters list
     */
    public void printVoters(){
        System.out.println("-----------------Voters-----------------");
        for (Person p : voters){
            System.out.println(p);
        }
    }

    /**
     * calculate and get the total votes of voting
     * @return total votes of voting
     */
    public int totalVotes(){
        int total=0;
        for (String poll : polls.keySet()){
            total+=polls.get(poll).size();
        }
        return total;
    }

    /**
     * print poll's information
     */
    public void printVotes(){
        System.out.println("-----------------Votes-----------------");
        for (String poll : polls.keySet()){
            System.out.println(poll+" : "+polls.get(poll).size());
        }
        System.out.println("total votes : "+totalVotes());
    }

    /**
     * get the polls list + voters
     * @return polls field
     */
    public HashMap<String,HashSet<Vote>> getPools(){
        return polls;
    }

    /**
     * check the vote list
     * if voter have voted , ignore the vote (null)
     * if type=0 and votes have more than 1 elements , ignore them(only keep one element)
     * else return the input votes list
     * @param votes voting's vote list
     * @param vote vote's information (voter info + date)
     * @return vote list
     */
    private ArrayList<String> checkVoteBeQualified(ArrayList<String> votes, Vote vote){
        for (String poll : polls.keySet()){
            for(Vote v : polls.get(poll)){
                if(v.equals(vote)){
                    System.out.println("You have already voted!");
                    return null;
                }
            }
        }
        if(type==0 && votes.size()>1){
            System.out.println("you can't vote multiple times!");
            votes = new ArrayList<>(Arrays.asList(votes.get(0)));
        }
        return votes;
    }

    /**
     * make a random vote
     * @param votes vote list
     * @return vote list
     */
    private ArrayList<String> randomVote(ArrayList<String> votes){
        if(type==0&&votes.get(0).equals("random")){
            ArrayList<String> keys = new ArrayList<>(polls.keySet());
            Random random = new Random();
            int poll = random.nextInt(keys.size());
            return new ArrayList<>(Arrays.asList(keys.get(poll)));
        }
        return votes;
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
        Voting voting = (Voting) o;
        return type == voting.type &&
                Objects.equals(question, voting.question) &&
                Objects.equals(polls, voting.polls) &&
                Objects.equals(today, voting.today);
    }

}
