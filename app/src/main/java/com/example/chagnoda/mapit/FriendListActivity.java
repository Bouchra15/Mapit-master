package com.example.chagnoda.mapit;


import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import com.firebase.client.ChildEventListener;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by chengli on 2016-03-21.
 */
public class FriendListActivity extends AppCompatActivity {

        ListView listView;
        //MyAdapder adapter;
        Profile friendsProfile;
        String typeProfile;  // nom du profile qui a la liste des amis
        public List<Profile> profileObject=new ArrayList<Profile>();
        private ArrayList<String> arrayList;
        private ArrayAdapter<String> adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_list);

            Intent intent=getIntent();
            //typeProfile=intent.getStringExtra("TYPELISTE");
            Firebase.setAndroidContext(this);
            listView=(ListView)findViewById(R.id.listFriends);
            //listView = (ListView)findViewById(R.id.FriendList);
            arrayList = new ArrayList<>();

            Firebase ref = new Firebase("https://sizzling-inferno-6141.firebaseio.com/Mapit/Profiles");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                    for (DataSnapshot profileSnapshot : snapshot.getChildren()) {
                        Profile copy_profile = profileSnapshot.getValue(Profile.class);
                        String username = copy_profile.getUserName();
                        arrayList.add(username);
                        Log.d("My App: ", copy_profile.getUserName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(FriendListActivity.this, android.R.layout.select_dialog_multichoice, arrayList);
                    listView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }

            });



        }




    }
