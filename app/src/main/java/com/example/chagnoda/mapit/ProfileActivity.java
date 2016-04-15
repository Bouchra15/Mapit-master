package com.example.chagnoda.mapit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by chengli on 2016-03-21.
 */
public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button amis;
    Button events;
    TextView profileName;
    ImageView photoProfile;
    Firebase fire=new Firebase("https://sizzling-inferno-6141.firebaseio.com/Mapit/Profiles");
    Profile Profiles;
    Persons persons;

   // public List<FriendListActivity> friendsProfile;
    //public List<EventListActivity> Events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Firebase.setAndroidContext(this);

        photoProfile = (ImageView) findViewById(R.id.PhotoProfile);
        profileName = (TextView) findViewById(R.id.profilename_text);

        Intent intent = getIntent();
        Profile profile = new Profile();
        String strProfile = fire.child("https://sizzling-inferno-6141.firebaseio.com/Mapit/Profiles").getKey();

        profileName.setText(strProfile);
                //Picasso.with(this).load(sphotoProfile).into(photoProfile);

            // snapshot.getValue().toString()

        amis=(Button)findViewById(R.id.button_Amis);
        events=(Button)findViewById(R.id.button_Events);

        amis.setOnClickListener(this);
        events.setOnClickListener(this);

        //RunAPI run = new RunAPI();
       // run.execute();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_Amis:
                startActivity(new Intent("com.example.chagnoda.mapit.FriendListActivity"));

                break;
            case R.id.button_Events:
                startActivity(new Intent("com.example.chagnoda.mapit.EventListActivity"));

                break;

        }




    }


}
