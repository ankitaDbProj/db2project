package db2project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Candidate {
    private int id, age, electionId, partyId;
    private String name, picture;

    private DBManager dbManager;

    // Configuration...
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

    public boolean create(){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_AGE + "," + COLUMN_PICTURE + "," + COLUMN_ELECTION_ID + "," + COLUMN_PARTY_ID + ") " +
                "VALUES ('" + name +"',"+ age + ",'" + picture + "'," + electionId +"," + partyId + ");";
        this.dbManager.executeUpdate(query);

        return true;
    }

    public ArrayList<Candidate> getAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);
        int i = 0;

        ArrayList<Candidate> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                new Candidate(
                    rs.getString(COLUMN_NAME),
                    rs.getInt(COLUMN_AGE),
                    rs.getString(COLUMN_PICTURE),
                    rs.getInt(COLUMN_ELECTION_ID),
                    rs.getInt(COLUMN_PARTY_ID)
                )
            );
        }

        return res;
    }

    public Candidate getById(int candidateId){
        String query = "SELECT * FROM " + TABLE + " WHERE id = '" + candidateId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        try {
            if(rs.next()){
                return new Candidate(candidateId, rs.getString(COLUMN_NAME), rs.getInt(COLUMN_AGE), rs.getString(COLUMN_PICTURE), rs.getInt(COLUMN_ELECTION_ID), rs.getInt(COLUMN_PARTY_ID));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return new Candidate();
    }

    public int delete(int candidateId){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = '" + candidateId + "'";
        return this.dbManager.executeUpdate(query);
    }

    // public Candidate update(Candidate candidate){ TODO implement? }


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

        this.dbManager = new DBManager();
    }
}
