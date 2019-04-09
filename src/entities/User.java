package entities;

public class User {
    private int id, gender, role;
    private String name, email;

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
    }

    public int getId() {
        return id;
    }

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



}
