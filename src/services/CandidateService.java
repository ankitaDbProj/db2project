package services;

import db2project.DBManager;
import entities.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateService {
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "candidate";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PICTURE = "picture";
    private static final String COLUMN_ELECTION_ID = "election_id";
    private static final String COLUMN_PARTY_ID = "party_id";

    CandidateService(){
        dbManager = new DBManager();
    }

    public boolean create(Candidate candidate){
        String query = "INSERT INTO " + candidate.TABLE + " ("
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



}
