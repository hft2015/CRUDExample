package in.co.henceforth.crudexample;


public class User {

    int _id;
    String _name;
    String _email;
    String _mobile;

    public User() {
    }

    public User(int id, String name, String email, String mobile) {
        this._id = id;
        this._name = name;
        this._email = email;
        this._mobile = mobile;
    }

    public User(String name, String email, String mobile) {
        this._name = name;
        this._email = email;
        this._mobile = mobile;
    }

    public int getID() {
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getEmail() {
        return this._email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public String getMobile() {
        return this._mobile;
    }

    public void setMobile(String mobile) {
        this._mobile = mobile;
    }


}
