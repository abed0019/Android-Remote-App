package com.example.tactical9.lab01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {


    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    ImageButton imgButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
    // Button imageButton;

        // final int REQUEST_IMAGE_CAPTURE = 1;

        //public void dispatchTakePictureIntent() {
         //   Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         //   if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
          //      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
          //  }
      //  }

        imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
            }
        });

        Switch flipper = (Switch) findViewById(R.id.switch1);
        flipper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    CharSequence text = "Switch is ON";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(ListItemsActivity.this, text, duration);
                    toast.show();
                   // Toast.makeText(getApplicationContext(),"Switch is On", Toast.LENGTH_LONG.show());
                }else{
                    CharSequence text = "Switch is OFF";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(ListItemsActivity.this, text, duration);
                    toast.show();
                    //Toast.makeText(getApplicationContext(),"Switch is Off", Toast.LENGTH_LONG.show());
                }
            }
        });


        CheckBox box = (CheckBox) findViewById(R.id.checkBox);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {


                                    //NOT SURE WHAT IS GOING ON HERE ( STEP 10 - NEED HELP )

                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", "My information to share");
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish();

                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                }
                            })
                            .show();

                }

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgButton.setImageBitmap(imageBitmap);
        }
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
        Log.i(ACTIVITY_NAME,"In onPause)");
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
