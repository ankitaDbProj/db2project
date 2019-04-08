package db2project;

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
        String query = "INSERT INTO " + this.TABLE + " ("
                + this.COLUMN_FIRSTNAME + "," + this.COLUMN_LASTNAME + "," + this.COLUMN_AGE + "," + this.COLUMN_PICTURE + ") " +
                "VALUES ('" + candidate.getFirstname()+"','"+ candidate.getLastname() + "'," +
                candidate.getAge() + ",'" + candidate.getPicture()+"');";
        this.dbManager.executeUpdate(query);

        return true;
    }

    public Candidate getByFirstname(String name){
        //TODO implement
    }

    public Candidate delete(String name){
        //TODO implement
    }

    public Candidate getAll(){
        //TODO implement
    }

    public Candidate update(Candidate candidate){
        //TODO implement
    }


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
