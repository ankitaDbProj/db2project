package db2project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int id, gender, role;
    private String name, email;
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ROLE = "role";

    public User(String name, int gender, String email, int role) {
        init(name, gender, email, role);
    }

    public User(int id, String name, int gender, String email, int role) {
        init(name, gender, email, role);
        this.id = id;
    }

    public User(){
    }

    public int create(){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_GENDER + "," + COLUMN_EMAIL + "," + COLUMN_ROLE + ") " +
                "VALUES ('" + name +"',"+ gender + ",'" + email + "', " + role + ");";
        return this.dbManager.executeUpdate(query);
    }

    public ArrayList<User> getAll(){
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);

        ArrayList<User> res = new ArrayList<>();
        try {
            while(rs.next()){
                res.add(
                        new User(
                                rs.getInt(COLUMN_ID),
                                rs.getString(COLUMN_NAME),
                                rs.getInt(COLUMN_GENDER),
                                rs.getString(COLUMN_EMAIL),
                                rs.getInt(COLUMN_ROLE)
                        )
                );
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return res;
    }

    public User getById(int userId){
        String query = "SELECT * FROM " + TABLE + " WHERE id = '" + userId + "'";
        ResultSet rs = this.dbManager.executeQuery(query);

        try {
            if(rs.next()){
                return new User(userId, rs.getString(COLUMN_NAME), rs.getInt(COLUMN_GENDER), rs.getString(COLUMN_EMAIL), rs.getInt(COLUMN_ROLE));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return new User();
    }

    public int delete(int userId){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = " + userId;
        return this.dbManager.executeUpdate(query);
    }

    //public Party update(Party party, int partyId){
    // TODO check if implementation is needed
    //}


    public int getGender() {
        return gender;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private void init(String name, int gender, String email, int role){
        if(name == null || email == null){
            throw new IllegalArgumentException();
        }
        if(gender < 1 || gender > 3){
            throw new IllegalArgumentException("'Gender' has to be between 1 - 3!");
        }
        if(role < 1 || role > 3){
            throw new IllegalArgumentException("'Role' has to be between 1-3!");
        }

        this.name = name;
        this.gender = gender;
        this.email = email;
        this.role = role;

        this.dbManager = new DBManager();
    }
}
