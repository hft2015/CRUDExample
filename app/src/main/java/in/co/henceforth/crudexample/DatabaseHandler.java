package in.co.henceforth.crudexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akvin on 21-08-2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    int _id;
    String _fname,_lname,_email,_mobile,_password,_addr,_city,_state,_country;
    String _pic;
    int _pincode;
    boolean _terms;



    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "crud_example";
    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_DOB = "dob";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ADDR = "addr";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_PIC = "pic_uri";
    private static final String KEY_PINCODE = "pincode";
    private static final String KEY_TERMS = "terms";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + KEY_FNAME + " TEXT, "
                    + KEY_LNAME + " TEXT, "
                    + KEY_DOB + " TEXT, "
                    + KEY_GENDER + " TEXT, "
                    + KEY_EMAIL + " TEXT, "
                    + KEY_MOBILE + " TEXT, "
                    + KEY_PASSWORD + " TEXT, "
                    + KEY_ADDR + " TEXT, "
                    + KEY_CITY + " TEXT, "
                    + KEY_STATE + " TEXT, "
                    + KEY_COUNTRY + " TEXT, "
                    + KEY_PIC + " TEXT, "
                    + KEY_PINCODE + " INTEGER, "
                    + KEY_TERMS + " BOOLEAN"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    void addUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, user.get_fname());
        values.put(KEY_LNAME, user.get_lname());
        values.put(KEY_DOB, user.get_dob());
        values.put(KEY_GENDER, user.get_gender());
        values.put(KEY_EMAIL, user.get_email());
        values.put(KEY_MOBILE, user.get_mobile());
        values.put(KEY_PASSWORD, user.get_password());
        values.put(KEY_ADDR, user.get_addr());
        values.put(KEY_CITY, user.get_city());
        values.put(KEY_STATE, user.get_state());
        values.put(KEY_COUNTRY, user.get_country());
        values.put(KEY_PIC, user.get_pic());
        values.put(KEY_PINCODE, user.get_pincode());
        values.put(KEY_TERMS, user.is_terms());

        db.insert(TABLE_USERS, null, values);
        db.close();


        /*try {
            long id = db.insertOrThrow(TABLE_USERS, null, values);
            db.close();
            return id;
        }catch (SQLException e){
            db.close();
            return " "+e;

        }*/

    }

    User getUser(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        String query= "SELECT * FROM "+TABLE_USERS+" WHERE "+KEY_ID+" ="+id;

        Cursor cursor=db.rawQuery(query,null);

        if (cursor != null)
            cursor.moveToFirst();

        User user = new User();
        user.set_id(Integer.parseInt(cursor.getString(0)));
        user.set_fname(cursor.getString(1));
        user.set_lname(cursor.getString(2));
        user.set_dob(cursor.getString(3));
        user.set_gender(cursor.getString(4));
        user.set_email(cursor.getString(5));
        user.set_mobile(cursor.getString(6));
        user.set_fname(cursor.getString(7));
        user.set_password(cursor.getString(8));
        user.set_addr(cursor.getString(9));
        user.set_city(cursor.getString(10));
        user.set_state(cursor.getString(11));
        user.set_country(cursor.getString(12));
        user.set_pic(cursor.getString(13));
        user.set_pincode(Integer.parseInt(cursor.getString(14)));

        if(Integer.parseInt(cursor.getString(15)) == 1)
            user.set_terms(true);
        else
            user.set_terms(false);


        return user;
    }

    void updateUser(User user){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, user.get_fname());
        values.put(KEY_LNAME, user.get_lname());
        values.put(KEY_DOB, user.get_dob());
        values.put(KEY_GENDER, user.get_gender());
        values.put(KEY_EMAIL, user.get_email());
        values.put(KEY_MOBILE, user.get_mobile());
        values.put(KEY_PASSWORD, user.get_password());
        values.put(KEY_ADDR, user.get_addr());
        values.put(KEY_CITY, user.get_city());
        values.put(KEY_STATE, user.get_state());
        values.put(KEY_COUNTRY, user.get_country());
        values.put(KEY_PIC, user.get_pic());
        values.put(KEY_PINCODE, user.get_pincode());
        values.put(KEY_TERMS, user.is_terms());

        db.update(TABLE_USERS, values, "id=" + user.get_id(), null);
        db.close();
    }

    void deleteUser(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,"id=" + id,null);
        db.close();

    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<User>();

        String selectQuery = "SELECT "+KEY_ID+","+KEY_FNAME+","+KEY_LNAME+","+KEY_EMAIL+","+KEY_PIC+" FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                User user = new User();
                user.set_id(Integer.parseInt(cursor.getString(0)));
                user.set_fname(cursor.getString(1));
                user.set_lname(cursor.getString(2));
                user.set_email(cursor.getString(3));
                user.set_pic(cursor.getString(4));

                userList.add(user);
            } while (cursor.moveToNext());
        }

        return userList;
    }





    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }


}
