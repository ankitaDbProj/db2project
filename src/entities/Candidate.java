package entities;

public class Candidate {
    private int id, age, electionId, partyId;
    private String name, picture;

    // DB structure...
    private static final String TABLE = "candidate";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PICTURE = "picture";
    private static final String COLUMN_ELECTION_ID = "election_id";
    private static final String COLUMN_PARTY_ID = "party_id";

    Candidate(String name, int age, String picture, int electionId, int partyId){
        init(name, age, picture, electionId, partyId);
    }

    Candidate(int id, String name, int age, String picture, int electionId, int partyId){
        init(name, age, picture, electionId, partyId);
        this.id = id;
    }

    Candidate(){
    }

    private void init(String name, int age, String picture, int electionId, int partyId){
        if(name == null || picture == null){
            throw new IllegalArgumentException();
        }
        if(age < 18 || age > 120){
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        this.name = name;
        this.age = age;
        this.picture = picture;
        this.electionId = electionId;
        this.partyId = partyId;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getElectionId() {
        return electionId;
    }

    public int getPartyId() {
        return partyId;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }
}
