package db2project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Election {
    private int id;
    private Date startDate, resultDate;
    private String topic;
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "election";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_TOPIC = "topic";
    private static final String COLUMN_RESLUT_DATE = "result_date";

    public Election(Date startDate, String topic, Date resultDate) {
        if(startDate == null || topic == null || resultDate == null){
            throw new IllegalArgumentException();
        }

        this.startDate = startDate;
        this.topic = topic;
        this.resultDate = resultDate;

        this.dbManager = new DBManager();
    }

    public Election(int id, Date startDate, String topic, Date resultDate) {
        if(startDate == null || topic == null || resultDate == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.startDate = startDate;
        this.topic = topic;
        this.resultDate = resultDate;

        this.dbManager = new DBManager();
    }

    public Election(){

    }

    public int create(){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_START_DATE + "," + COLUMN_TOPIC + "," + COLUMN_RESLUT_DATE + ") " +
                "VALUES ('" + startDate +"','"+ topic + "','" + resultDate + "');";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<Election> getAll(){
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Election> res = new ArrayList<>();
        try {
            while(rs.next()){
                res.add(
                        new Election(
                                rs.getInt(COLUMN_ID),
                                rs.getDate(COLUMN_START_DATE),
                                rs.getString(COLUMN_TOPIC),
                                rs.getDate(COLUMN_RESLUT_DATE)
                        )
                );
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return res;
    }

    public Election getById(int electionId){
        String query = "SELECT * FROM " + TABLE + " WHERE id = '" + electionId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        try {
            if(rs.next()){
                return new Election(electionId, rs.getDate(COLUMN_START_DATE), rs.getString(COLUMN_TOPIC), rs.getDate(COLUMN_RESLUT_DATE));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return new Election();
    }

    public int delete(int electionId){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = " + electionId;
        return this.dbManager.executeUpdate(query);
    }

    //public Party update(Party party, int partyId){
    // TODO check if implementation is needed
    //}


    public Date getStartDate() {
        return startDate;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public String getTopic() {
        return topic;
    }
}
