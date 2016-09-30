package com.example.tactical9.lab01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*RelativeLayout layout = new RelativeLayout(this);
        Button button = new Button(this);
        layout.addView(button);
        setContentView(layout);*/
        setContentView(R.layout.activity_login);

final EditText nameField = (EditText)findViewById(R.id.editText);
        //open the file
        final SharedPreferences prefs = getSharedPreferences("storeddata", Context.MODE_PRIVATE);
        final String storedName = prefs.getString("LoginName", "email@domain.com");


nameField.setText(storedName);

        loginButton = (Button)findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get an object to write to the file:
                SharedPreferences.Editor writer = prefs.edit();

                //Write put a number:
                writer.putString("LoginName", nameField.getText().toString()  );

                //Write the file:
                writer.commit();
LoginActivity.this.startActivity(new Intent( LoginActivity.this, StartActivity.class   ));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }

}
