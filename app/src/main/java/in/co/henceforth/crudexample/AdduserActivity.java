package in.co.henceforth.crudexample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Calendar;


public class AdduserActivity extends ActionBarActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    Uri uri;
    Boolean URI_FLAG=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);


        EditText fnameField = (EditText) findViewById(R.id.fname);
        fnameField.setText("vinodkumar");

        EditText lnameField = (EditText) findViewById(R.id.lname);
        lnameField.setText("yerramsetty");

        EditText dobField = (EditText) findViewById(R.id.dob);
        dobField.setText("31/10/1989");

        EditText emailField = (EditText) findViewById(R.id.email);
        emailField.setText("vinodkumar937@gmail.com");

        EditText mobileField = (EditText) findViewById(R.id.mobile);
        mobileField.setText("7842434444");

        EditText passField = (EditText) findViewById(R.id.password);
        passField.setText("Vinod@937");

        EditText vpassField = (EditText) findViewById(R.id.vpassword);
        vpassField.setText("Vinod@937");

        EditText addrField = (EditText) findViewById(R.id.address);
        addrField.setText("4-156/2, pandaripuram 3-lane");

        EditText pincodeField = (EditText) findViewById(R.id.pincode);
        pincodeField.setText("522616");

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @SuppressWarnings("deprecation")
    public void SetDate(View view){
        showDialog(1);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }


    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int day) {
            AssignDate(year, month+1, day);
        }
    };

    private void AssignDate(int year, int month, int day) {
        EditText dob=(EditText) findViewById(R.id.dob);
        dob.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }

    public void UploadImage(View view) {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            uri = data.getData();
            URI_FLAG=true;

            ImageView imageView = (ImageView) findViewById(R.id.profile_pic);
            imageView.setImageURI(uri);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adduser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.save_user) {

            EditText fnameField = (EditText) findViewById(R.id.fname);
            String fname = fnameField.getText().toString();

            EditText lnameField = (EditText) findViewById(R.id.lname);
            String lname = lnameField.getText().toString();

            EditText dobField = (EditText) findViewById(R.id.dob);
            String dob = dobField.getText().toString();

            RadioGroup genderGroup=(RadioGroup)findViewById(R.id.gender);
            RadioButton genderChecked = (RadioButton) findViewById(genderGroup.getCheckedRadioButtonId());
            String gender = genderChecked.getText().toString();

            EditText emailField = (EditText) findViewById(R.id.email);
            String email = emailField.getText().toString();

            EditText mobileField = (EditText) findViewById(R.id.mobile);
            String mobile = mobileField.getText().toString();

            EditText passField = (EditText) findViewById(R.id.password);
            String password = passField.getText().toString();

            EditText addrField = (EditText) findViewById(R.id.address);
            String addr = addrField.getText().toString();

            Spinner cityField = (Spinner) findViewById(R.id.city);
            String city = cityField.getSelectedItem().toString();

            Spinner stateField = (Spinner) findViewById(R.id.state);
            String state = stateField.getSelectedItem().toString();

            Spinner countryField = (Spinner) findViewById(R.id.country);
            String country = countryField.getSelectedItem().toString();

            String pic;

            if(URI_FLAG) {
                pic = uri.toString();
            }
            else {
                pic = "noimage";
            }

            EditText pincodeField = (EditText) findViewById(R.id.pincode);
            int pincode = Integer.parseInt(pincodeField.getText().toString());

            CheckBox termsField = (CheckBox) findViewById(R.id.terms);
            Boolean terms = termsField.isChecked();


            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
            db.addUser(new User(fname, lname, dob, gender, email, mobile, password, addr, city, state, country, pic, pincode, terms));
            db.close();

             //Toast.makeText(this,"_"+ids,Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}
