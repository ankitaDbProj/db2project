package services;

import db2project.DBManager;
import entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ROLE = "role";

    public UserService() {
        this.dbManager = new DBManager();
    }

    public int create(User user){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + "," + COLUMN_GENDER + "," + COLUMN_EMAIL + "," + COLUMN_ROLE + ") " +
                "VALUES ('" + user.getName() +"',"+ user.getGender() + ",'" + user.getGender() + "', " + user.getRole() + ");";
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
}
