

public class Candidate {
    String name;
    Integer numberOfVotes;

    public Candidate(String name){
        this.name = name;
        this.numberOfVotes =0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public int getNumberOfVotes(){
        return numberOfVotes;
    }

    public int setNumberOfVotes(int votes){
        this.numberOfVotes= votes;
        return numberOfVotes;
    }

    public void incrmentVote(){
       this.numberOfVotes++;
    }



}
