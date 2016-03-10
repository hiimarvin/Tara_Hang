package tarahang.dto;

/**
 * Created by user on 3/10/2016.
 */
public class User {

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_USERID = "userId";
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";

    private int userId;
    private String fName;
    private String lName;
    private String username;
    private String email;

    public User(){}

    public User(int userId, String fName, String lName, String username, String email) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
