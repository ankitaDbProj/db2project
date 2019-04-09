package services;

import db2project.DBManager;
import entities.Election;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ElectionService {
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "election";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_TOPIC = "topic";
    private static final String COLUMN_RESLUT_DATE = "result_date";

    public ElectionService() {
        this.dbManager = new DBManager();
    }

    public int create(Election election){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_START_DATE + "," + COLUMN_TOPIC + "," + COLUMN_RESLUT_DATE + ") " +
                "VALUES ('" + election.getStartDate() +"','"+ election.getTopic() + "','" + election.getResultDate() + "');";
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
}
