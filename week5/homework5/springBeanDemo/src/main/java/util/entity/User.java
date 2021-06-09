package util.entity;

public class User {
    private  String userName;
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String userName, String sex) {
        this.userName = userName;
        this.sex = sex;
    }
}
