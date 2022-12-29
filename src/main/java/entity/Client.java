package entity;

public class Client extends MyEntity{

    private final int ID;

    private String fullName;

    private String email;

    public Client(int ID, String fullName, String email) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
