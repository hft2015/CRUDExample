package in.co.henceforth.crudexample;


public class User {

    int _id;
    String _fname,_lname,_dob,_gender,_email,_mobile,_password,_addr,_city,_state,_country,_pic;
    int _pincode;
    boolean _terms;


    public User() {
    }

    public User(int _id, String _fname, String _lname, String _dob, String _gender, String _email, String _mobile, String _password, String _addr, String _city, String _state, String _country, String _pic, int _pincode, boolean _terms) {
        this._id = _id;
        this._fname = _fname;
        this._lname = _lname;
        this._dob = _dob;
        this._gender = _gender;
        this._email = _email;
        this._mobile = _mobile;
        this._password = _password;
        this._addr = _addr;
        this._city = _city;
        this._state = _state;
        this._country = _country;
        this._pic = _pic;
        this._pincode = _pincode;
        this._terms = _terms;
    }

    public User(String _fname, String _lname, String _dob, String _gender, String _email, String _mobile, String _password, String _addr, String _city, String _state, String _country, String _pic, int _pincode, boolean _terms) {
        this._fname = _fname;
        this._lname = _lname;
        this._dob = _dob;
        this._gender = _gender;
        this._email = _email;
        this._mobile = _mobile;
        this._password = _password;
        this._addr = _addr;
        this._city = _city;
        this._state = _state;
        this._country = _country;
        this._pic = _pic;
        this._pincode = _pincode;
        this._terms = _terms;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_fname() {
        return _fname;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public String get_lname() {
        return _lname;
    }

    public void set_lname(String _lname) {
        this._lname = _lname;
    }

    public String get_dob() {
        return _dob;
    }

    public void set_dob(String _dob) {
        this._dob = _dob;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_mobile() {
        return _mobile;
    }

    public void set_mobile(String _mobile) {
        this._mobile = _mobile;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_addr() {
        return _addr;
    }

    public void set_addr(String _addr) {
        this._addr = _addr;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public String get_pic() {
        return _pic;
    }

    public void set_pic(String _pic) {
        this._pic = _pic;
    }

    public int get_pincode() {
        return _pincode;
    }

    public void set_pincode(int _pincode) {
        this._pincode = _pincode;
    }

    public boolean is_terms() {
        return _terms;
    }

    public void set_terms(boolean _terms) {
        this._terms = _terms;
    }
}









