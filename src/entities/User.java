package entities;

public class User {
    private int id, gender, role, age;
    private String name, email, password;

    public User(String name, int gender, String email, int role, int age, String password) {
        init(name, gender, email, role, age, password);
    }

    public User(int id, String name, int gender, String email, int role, int age, String password) {
        init(name, gender, email, role, age, password);
        this.id = id;
    }

    public User(){
    }

    private void init(String name, int gender, String email, int role, int age, String password){
        if(name == null || email == null){
            throw new IllegalArgumentException();
        }
        if(gender < 1 || gender > 3){
            throw new IllegalArgumentException("'Gender' has to be between 1 - 3!");
        }
        if(role < 1 || role > 3){
            throw new IllegalArgumentException("'Role' has to be between 1-3!");
        }
        if(age >= 120){
            throw new IllegalArgumentException("'Age' is invalid!");
        }

        this.name = name;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.age = age;
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
