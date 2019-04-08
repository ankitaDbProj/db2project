package db2project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Candidate {

    private String firstname, lastname, picture;
    private int age;
    private DBManager dbManager;

    // Configuration...
    private static final String TABLE = "candidate";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PICTURE = "picture";

    Candidate(String firstname, String lastname, int age, String picture){
        if(firstname == null || lastname == null || picture == null){
            throw new IllegalArgumentException();
        }
        if(age < 18 || age > 120){
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.picture = picture;

        this.dbManager = new DBManager();
    }

    public boolean create(Candidate candidate){
        String query = "INSERT INTO " + TABLE + " ("
                + COLUMN_FIRSTNAME + "," + COLUMN_LASTNAME + "," + COLUMN_AGE + "," + COLUMN_PICTURE + ") " +
                "VALUES ('" + candidate.getFirstname()+"','"+ candidate.getLastname() + "'," +
                candidate.getAge() + ",'" + candidate.getPicture()+"');";
        this.dbManager.executeUpdate(query);

        return true;
    }

    public ArrayList<Candidate> getAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;
        ResultSet rs = this.dbManager.executeQuery(query);
        int i = 0;

        ArrayList<Candidate> resCandidates = new ArrayList<>();
        while(rs.next()){
            resCandidates.add(
                new Candidate(
                    rs.getString(COLUMN_FIRSTNAME),
                    rs.getString(COLUMN_LASTNAME),
                    rs.getInt(COLUMN_AGE),
                    rs.getString(COLUMN_PICTURE)
                )
            );
        }

        return resCandidates;
    }

    // public Candidate getByFirstname(String name){ TODO implement }

    public int delete(String name){
        String query = "DELETE FROM " + TABLE + " WHERE " + COLUMN_FIRSTNAME + " = '" + name + "'";
        return this.dbManager.executeUpdate(query);
    }

    // public Candidate update(Candidate candidate){ TODO implement }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPicture() {
        return picture;
    }

    public int getAge() {
        return age;
    }
}
