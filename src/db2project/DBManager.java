package db2project;

import javax.swing.*;
import java.sql.*;


public class DBManager {

    private Connection myConn;

    DBManager(){
         try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", null);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String createQuery(String query){
        String resultString = "";

        try {
            Statement myStmt = this.myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from hotel");
            while(myRs.next()){
                resultString += myRs.getString("name") + "\n\r";
            }
        }catch (Exception ex ){
            ex.printStackTrace();
        }

        return resultString;
    }

}
