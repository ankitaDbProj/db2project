package services;

import db2project.DBManager;
import entities.Vote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoteService {
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "vote";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_CANDIDATE_ID = "candidate_id";
    private static final String COLUMN_USER_ID = "user_id";

    public VoteService() {
        this.dbManager = new DBManager();
    }

    public int create(Vote vote){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_DATE + "," + COLUMN_CANDIDATE_ID + "," + COLUMN_USER_ID + ") " +
                "VALUES ('" + vote.getDate() +"',"+ vote.getCandidateId() + "," + vote.getUserId() + ");";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<Vote> getAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Vote> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                new Vote(
                    rs.getInt(COLUMN_ID),
                    rs.getDate(COLUMN_DATE),
                    rs.getInt(COLUMN_CANDIDATE_ID),
                    rs.getInt(COLUMN_USER_ID)
                )
            );
        }

        return res;
    }

    public Vote getById(int voteId){
        String query = "SELECT * FROM " + TABLE + " WHERE id = '" + voteId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        try {
            if(rs.next()){
                return new Vote(voteId, rs.getDate(COLUMN_DATE), rs.getInt(COLUMN_CANDIDATE_ID), rs.getInt(COLUMN_USER_ID));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return new Vote();
    }

    public int delete(int voteId){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = '" + voteId + "'";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<Vote> getAllByCandidate(int candidateId) throws SQLException{
        String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_CANDIDATE_ID + " = '" + candidateId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Vote> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                new Vote(
                    rs.getInt(COLUMN_ID),
                    rs.getDate(COLUMN_DATE),
                    rs.getInt(COLUMN_CANDIDATE_ID),
                    rs.getInt(COLUMN_USER_ID)
                )
            );
        }

        return res;
    }

    public ArrayList<Vote> getAllByUser(int userId) throws SQLException {
        String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_USER_ID + " = '" + userId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Vote> res = new ArrayList<>();
        while(rs.next()){
            res.add(
                    new Vote(
                            rs.getInt(COLUMN_ID),
                            rs.getDate(COLUMN_DATE),
                            rs.getInt(COLUMN_CANDIDATE_ID),
                            rs.getInt(COLUMN_USER_ID)
                    )
            );
        }

        return res;
    }
}
