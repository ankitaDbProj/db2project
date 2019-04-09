package db2project;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Vote {
    private int id, candidateId, userId;
    private Date date;

    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "vote";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_CANDIDATE_ID = "candidate_id";
    private static final String COLUMN_USER_ID = "user_id";

    Vote(Date date, int candidateId, int userId){
        init(date, candidateId, userId);
    }

    Vote(int id, Date date, int candidateId, int userId){
        init(date, candidateId, userId);
        this.id = id;
    }

    Vote(){
    }

    public boolean create(){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_DATE + "," + COLUMN_CANDIDATE_ID + "," + COLUMN_USER_ID + ") " +
                "VALUES ('" + date +"',"+ candidateId + "," + userId + ");";
        this.dbManager.executeUpdate(query);

        return true;
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

    // public Candidate update(Candidate candidate){ TODO implement? }


    public int getId() {
        return id;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    private void init(Date date, int candidateId, int userId){
        this.date = date;
        this.candidateId = candidateId;
        this.userId = userId;

        this.dbManager = new DBManager();
    }
}
