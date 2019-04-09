package services;

import db2project.DBManager;
import entities.Party;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartyService {
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "party";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SLOGAN = "slogan";
    private static final String COLUMN_LOGO = "logo";

    public PartyService() {
        this.dbManager = new DBManager();
    }

    public int create(Party party){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_SLOGAN + "," + COLUMN_LOGO + ") " +
                "VALUES ('" + party.getName() +"','"+ party.getSlogan() + "','" + party.getLogo() + "');";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<Party> getAll(){
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<Party> res = new ArrayList<>();
        try {
            while(rs.next()){
                res.add(
                        new Party(
                                rs.getInt(COLUMN_ID),
                                rs.getString(COLUMN_NAME),
                                rs.getString(COLUMN_SLOGAN),
                                rs.getString(COLUMN_LOGO)
                        )
                );
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }


        return res;
    }

    public Party getById(int partyId){
        String query = "SELECT * FROM " + TABLE + " WHERE id = '" + partyId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        try {
            if(rs.next()){
                return new Party(partyId, rs.getString(COLUMN_NAME), rs.getString(COLUMN_SLOGAN), rs.getString(COLUMN_LOGO));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return new Party();
    }

    public int delete(int partyId){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = " + partyId;
        return this.dbManager.executeUpdate(query);
    }
}
