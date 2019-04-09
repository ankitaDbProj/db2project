package entities;

import java.sql.Date;

public class Vote {
    private int id, candidateId, userId;
    private Date date;

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

    private void init(Date date, int candidateId, int userId){
        this.date = date;
        this.candidateId = candidateId;
        this.userId = userId;
    }

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
}
