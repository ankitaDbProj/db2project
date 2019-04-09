package db2project;

import java.sql.*;

public class DBManager {

    private Connection myConn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "voting_system";
    private static final String USER = "root";
    private static final String PASSWORD = null;


    public DBManager(){
         try {
            myConn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASSWORD);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Execute SELECT queries.
     *
     * @param query String
     * @return ResultSet
     */
    public ResultSet executeQuery(String query){
        try {
            Statement myStmt = this.myConn.createStatement();
            return myStmt.executeQuery(query);
        }catch (Exception ex ){
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Execute INSERT, UPDATE and DELETE queries.
     *
     * @param query String
     * @return int
     */
    public int executeUpdate(String query){
        try {
            Statement myStmt = this.myConn.createStatement();
            return myStmt.executeUpdate(query);
        }catch (Exception ex ){
            ex.printStackTrace();
        }

        return 0;
    }
}
