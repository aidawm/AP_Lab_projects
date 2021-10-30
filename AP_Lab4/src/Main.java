import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        VotingSystem voteSys = new VotingSystem();
        ArrayList<String> polls = new ArrayList<>(Arrays.asList("1","2","3","4"));

        voteSys.createVoting("Question 1",1,polls);
        voteSys.getVotingList();
        voteSys.getVoting(0);

        Person person = new Person("aida","mobli");
//        voteSys.vote(0,person,new ArrayList<>(Arrays.asList()));
        ArrayList<String> vote = new ArrayList<>();
        vote.add("random");
        voteSys.vote(0,person,vote);
//        voteSys.getResult(0);
//        voteSys.vote(0,person,new ArrayList<>(Arrays.asList("3")));
        voteSys.getResult(0);

    }
}
