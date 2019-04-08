package db2project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Party {

    private int id;
    private String name, slogan, logo;
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "party";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SLOGAN = "slogan";
    private static final String COLUMN_LOGO = "logo";

    public Party(String name, String slogan, String logo) {
        if(name == null || slogan == null || logo == null){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.slogan = slogan;
        this.logo = logo;

        this.dbManager = new DBManager();
    }

    public Party(int id, String name, String slogan, String logo) {
        if(name == null || slogan == null || logo == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
        this.slogan = slogan;
        this.logo = logo;

        this.dbManager = new DBManager();
    }

    public Party(){

    }

    public int create(){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_SLOGAN + "," + COLUMN_LOGO + ") " +
                "VALUES ('" + name +"','"+ slogan + "','" + logo + "');";
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

    //public Party update(Party party, int partyId){
        // TODO check if implementation is needed
    //}

    public String getName() {
        return name;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getLogo() {
        return logo;
    }
}
