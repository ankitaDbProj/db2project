package entities;

import java.sql.Date;

public class Vote {
    private int id, candidateId, userId, electionId;
    private Date date;

    public Vote(Date date, int candidateId, int userId, int electionId){
        init(date, candidateId, userId, electionId);
    }

    public Vote(int id, Date date, int candidateId, int userId, int electionId){
        init(date, candidateId, userId, electionId);
        this.id = id;
    }

    public Vote(){
    }

    private void init(Date date, int candidateId, int userId, int electionId){
        this.date = date;
        this.candidateId = candidateId;
        this.userId = userId;
        this.electionId = electionId;
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

    public int getElectionId() {
        return electionId;
    }
}
