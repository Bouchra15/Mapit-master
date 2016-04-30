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
        MyAdapter adapter;
        List<Friend> friendlist=new ArrayList<Friend>();
        public List<NewProfil> profiles=new ArrayList<NewProfil>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_list);

            Firebase.setAndroidContext(this);
            listView=(ListView)findViewById(R.id.listFriends);

            Intent intent=getIntent();
            String user=intent.getStringExtra("USERNAME");

            Firebase firebase= new Firebase("https://sizzling-inferno-6141.firebaseio.com/Mapit/Profiles");
            Firebase ref=firebase.child(user);
            ref.child("friendsList").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        Friend friend = new Friend();
                        //friend.name = child.getKey().toString();
                        friend.name = child.child("name").getValue().toString();
                        friend.photoUrl=child.child("photoUrl").getValue().toString();
                        friendlist.add(friend);

                    }
                    adapter = new MyAdapter(friendlist);
                    listView.setAdapter(adapter);

                }


                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

        }

    public class MyAdapter extends BaseAdapter{

        List<Friend> friendlist=new ArrayList<Friend>();

        LayoutInflater inflater;
        public MyAdapter(List<Friend> friendlist) {
            this.friendlist=friendlist;
            inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return friendlist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            if(v==null){
                v=inflater.inflate(R.layout.rangee_friend, parent, false);
            }
            if(position%2==0) v.setBackgroundColor(0xFFE3B5B5);
            else v.setBackgroundColor(Color.WHITE);

            TextView tv=(TextView)v.findViewById(R.id.rangee_textFriend);
            ImageView image=(ImageView)v.findViewById(R.id.photoFriend_id);

            String ami=friendlist.get(position).name;
            String photoUrl=friendlist.get(position).photoUrl;

            tv.setText(ami);
            Picasso.with(getApplicationContext()).load(photoUrl).into(image);
            return v;
        }
    }




    }
