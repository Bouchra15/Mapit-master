package com.example.chagnoda.mapit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chengli on 2016-03-21.
 */
public class ProfileActivity extends AppCompatActivity {

    Button amis;
    Button events;
    TextView profileName;
    ImageView photoProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        photoProfile=(ImageView)findViewById(R.id.PhotoProfile);
        profileName=(TextView)findViewById(R.id.profilename_text);

        amis=(Button)findViewById(R.id.button_Amis);
        events=(Button)findViewById(R.id.button_Events);
    }
}
