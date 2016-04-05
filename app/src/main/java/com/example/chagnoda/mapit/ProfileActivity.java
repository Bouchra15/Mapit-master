package com.example.chagnoda.mapit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chengli on 2016-03-21.
 */
public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button amis;
    Button events;
    TextView profileName;
    ImageView photoProfile;

    Profile Profiles;

   // public List<FriendListActivity> friendsProfile;
    //public List<EventListActivity> Events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        photoProfile=(ImageView)findViewById(R.id.PhotoProfile);
        profileName=(TextView)findViewById(R.id.profilename_text);

        Intent intent=getIntent();

        String sprofileName=intent.getStringExtra("NAME");
        String sphotoProfile=intent.getStringExtra("PHOTO");


        profileName.setText(sprofileName);
        Picasso.with(this).load(sphotoProfile).into(photoProfile);

        amis=(Button)findViewById(R.id.button_Amis);
        events=(Button)findViewById(R.id.button_Events);

        amis.setOnClickListener(this);
        events.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_Amis:
                startActivity(new Intent("com.example.chagnoda.mapit.FriendListActivity"));
               // Intent intent1=new Intent(this, FriendListActivity.class);
               // intent1.putExtra("TYPELISTE", getText(R.id.profilename_text)); // friends identique à la variable du firebase
               // startActivity(intent1);
                break;
            case R.id.button_Events:
                startActivity(new Intent("com.example.chagnoda.mapit.EventListActivity"));
                //Intent intent2=new Intent(this,EventListActivity.class);
               // intent2.putExtra("TYPELISTE", "events"); // events identique à la variable du firebase
               // startActivity(intent2);
                break;

        }




    }
}
