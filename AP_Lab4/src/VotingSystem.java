import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * it keep the whole of the voting information
 */
public class VotingSystem {
    /// list of votings
    private ArrayList<Voting> votingList;

    /**
     * create a instance of VotingSystem
     */
    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    /**
     * create a new voting if it is not exist
     * @param question voting's question
     * @param type type of voting
     * @param polls polls of voting
     */

    public void createVoting(String question, int type,ArrayList<String> polls){
        Voting voting = new Voting(type,question);
        for (String p: polls){
            voting.createPoll(p);
        }
        for (Voting vo : votingList){
            if (vo.equals(voting))
                return;
        }
        votingList.add(voting);
    }

    /**
     * remove the voting
     * @param index index of voting in votingList
     */
    public void removeVoting(int index){
        if(!isIndexValid(index))
            return;
        votingList.remove(index);
    }

    /**
     * print the current voting list
     */
    public void getVotingList(){
        for (Voting v:votingList){
            System.out.println(v.getQuestion());
        }
    }

    /**
     * get the voting information
     * @param index index of voting in votingList
     */
    public void getVoting(int index){
        if(!isIndexValid(index))
            return;
        Voting v =votingList.get(index);
        HashSet<String> polls = new HashSet<>(v.getPools().keySet());
        System.out.println(v.getQuestion());
        for (String p : polls){
            System.out.println(p);
        }
    }

    /**
     * vote to the voting
     * @param index index of voting in votingList
     * @param person voters information
     * @param votes vote list
     */
    public void vote(int index ,Person person,ArrayList<String> votes){
        if(!isIndexValid(index))
            return;
        Voting v =votingList.get(index);
        v.vote(person,votes);
    }

    /**
     * show the result of the voting
     * @param index index of voting in votingList
     */
    public void getResult(int index){
        if(!isIndexValid(index))
            return;
        System.out.println("-----------------RESULT-----------------");
        Voting v = votingList.get(index);
        String result = null;
        int max =-1;
        for (String p : v.getPools().keySet()){
            int cnt = v.getPools().get(p).size();
            if(cnt > max){
                max=cnt;
                result=p;
            }
        }
        votingList.get(index).printVotes();
        votingList.get(index).printVoters();
        System.out.println(v.getQuestion()+" result= "+ result+" vote number= "+max);
    }

    /**
     * check the index be correct
     * @param index index of voting in votingList
     * @return true if its correct  false if not
     */
    private boolean isIndexValid(int index){
        if(index<votingList.size() && index>0)
            return true;
        System.out.println("incorrect index");
        return false;
    }


}
