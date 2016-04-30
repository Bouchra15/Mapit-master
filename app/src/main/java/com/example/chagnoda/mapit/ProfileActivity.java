package com.example.chagnoda.mapit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 *
 * Fait par Bouchra
 */
public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button amis;
    Button events;
    TextView textView;
    ImageView imageView;
    String user;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageView_photoProfile_id);
        textView = (TextView) findViewById(R.id.profilename_id_text);

        amis=(Button)findViewById(R.id.button_Amis);
        events=(Button)findViewById(R.id.button_Events);

        Intent intent = getIntent();
        user=intent.getStringExtra("USER_NAME");
        imageUrl=intent.getStringExtra("PHOTO_URL");

        textView.setText(user);
        Picasso.with(this).load(imageUrl).into(imageView);



        amis.setOnClickListener(this);
        events.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.button_Amis:
                Intent intent =new Intent(ProfileActivity.this, FriendListActivity.class);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
                break;
            case R.id.button_Events:
                Intent intent1=new Intent(ProfileActivity.this, EventListActivity.class);
                intent1.putExtra("USERNAME", user);
                startActivity(intent1);
                break;
        }

    }


}
