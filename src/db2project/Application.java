package db2project;

import javax.swing.*;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        // EntryPoint of the app
        // Start UI here...


        // test
        Candidate c = new Candidate("nils", "weber", 31, "test");
        // c.create(c);
        // c.getAll();
        c.delete("nils");
    }
}
