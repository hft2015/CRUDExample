package in.co.henceforth.crudexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AdduserActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameField = (EditText) findViewById(R.id.name);
                String name = nameField.getText().toString();

                EditText emailField = (EditText) findViewById(R.id.email);
                String email = emailField.getText().toString();

                EditText mobileField = (EditText) findViewById(R.id.email);
                String mobile = mobileField.getText().toString();


                DatabaseHandler db = new DatabaseHandler(getApplicationContext());

                db.addUser(new User(name, email, mobile));



                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);






            }
        });
    }


}
