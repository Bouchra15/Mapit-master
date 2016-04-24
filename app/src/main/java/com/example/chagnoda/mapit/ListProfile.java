package com.example.chagnoda.mapit;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListProfile extends AppCompatActivity {

    ListView listView;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profile);

        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef= new Firebase("https://sizzling-inferno-6141.firebaseio.com/");

        myFirebaseRef.child("Mapit/Profiles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {


                List<NewProfil> profiles = new ArrayList<NewProfil>();

                for (DataSnapshot child : snapshot.getChildren()) {

                    NewProfil newProfil = new NewProfil();

                    newProfil.email = String.valueOf(child.child("email").getValue());
                    newProfil.userName = String.valueOf(child.child("userName").getValue());
                    newProfil.password = String.valueOf(child.child("password").getValue());

                    profiles.add(newProfil);


                }
                adapter=new MyAdapter(profiles);
                listView.setAdapter(adapter);

            }
                @Override
            public void onCancelled(FirebaseError error) {
            }
        });
        listView=(ListView)findViewById(R.id.list_profiles);
    }



    public class MyAdapter extends BaseAdapter{

        LayoutInflater inflater;
        List<NewProfil> profiles=new ArrayList<NewProfil>();

        public MyAdapter(List<NewProfil> profiles) {
            this.profiles=profiles;
            inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return profiles.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v=convertView;
            if(v==null){

                v=inflater.inflate(R.layout.rangeeprofile, parent, false);// on a crée notre propre layout
            }
            if(position%2==0) v.setBackgroundColor(0xFFE3B5B5);
            else v.setBackgroundColor(Color.WHITE);

            TextView tv=(TextView)v.findViewById(R.id.textView_user_id);
            TextView tv1=(TextView)v.findViewById(R.id.textView_email_id);
            TextView tv2=(TextView)v.findViewById(R.id.textView_password_id);


            String user=profiles.get(position).userName;
            String email=profiles.get(position).email;
            String password=profiles.get(position).password;


            tv.setText(user);
            tv1.setText(email);
            tv2.setText(password);


            return v;
        }
    }
}
