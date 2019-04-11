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

    public CandidateService(){
        dbManager = new DBManager();
    }

    public int create(Candidate candidate){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_AGE + "," + COLUMN_PICTURE + "," + COLUMN_ELECTION_ID + "," + COLUMN_PARTY_ID + ") " +
                "VALUES ('" + candidate.getName() +"',"+ candidate.getAge() + ",'" + candidate.getPicture() +
                "'," + candidate.getElectionId() +"," + candidate.getPartyId() + ");";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<Candidate> getAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Candidate> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                new Candidate(
                    rs.getInt(COLUMN_ID),
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

    public ArrayList<Candidate> getAllByParty(int partyId) throws SQLException {
        String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_PARTY_ID + " = '" + partyId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Candidate> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                new Candidate(
                    rs.getInt(COLUMN_ID),
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

    public ArrayList<Candidate> getAllByElection(int electionId) throws SQLException{
        String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_ELECTION_ID + " = '" + electionId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Candidate> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                    new Candidate(
                            rs.getInt(COLUMN_ID),
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
}
