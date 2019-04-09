package entities;

import java.sql.Date;

public class Vote {
    private int id, candidateId, userId;
    private Date date;

    public Vote(Date date, int candidateId, int userId){
        init(date, candidateId, userId);
    }

    public Vote(int id, Date date, int candidateId, int userId){
        init(date, candidateId, userId);
        this.id = id;
    }

    public Vote(){
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
