package entities;

public class Party {
    private int id;
    private String name, slogan, logo;

    public Party(String name, String slogan, String logo) {
        init(name, slogan, logo);
    }

    public Party(int id, String name, String slogan, String logo) {
        init(name, slogan, logo);
        this.id = id;
    }

    public Party(){
    }

    private void init(String name, String slogan, String logo){
        if(name == null || slogan == null || logo == null){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.slogan = slogan;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

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
