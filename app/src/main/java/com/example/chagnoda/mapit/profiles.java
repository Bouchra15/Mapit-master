package com.example.chagnoda.mapit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.firebase.client.Firebase;

public class profiles extends AppCompatActivity {

    ListView listProfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        listProfiles=(ListView)findViewById(R.id.listView_profiles);
        Firebase firebase=new Firebase("https://docs-examples.firebaseio.com/web/data.json");
        Firebase.setAndroidContext(this);

        firebase.child("https://docs-examples.firebaseio.com/web/data/members");


    }
}
