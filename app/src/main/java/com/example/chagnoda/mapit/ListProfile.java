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

public class ListProfile extends AppCompatActivity {

    ListView listView;

    Persons persons;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profile);



        //Firebase.setAndroidContext(this);
        listView=(ListView)findViewById(R.id.list_profiles);
        RunAPI run=new RunAPI();
        run.execute(); // va appeler  doInBackground



    }

    public class RunAPI extends AsyncTask<String, String, Persons> {

        @Override
        protected Persons doInBackground(String... params) {
            webAPI api = new webAPI();
            try{
                persons = api.run();
                Log.d("Dans asyncTask ", ((Integer)persons.listpersons.size()).toString());
            }catch (IOException e){}

            return persons;
        }

        @Override
        protected void onPostExecute(Persons persons) {
            super.onPostExecute(persons);
            adapter=new MyAdapter();
            listView.setAdapter(adapter);
            //listView.setOnItemClickListener((AdapterView.OnItemClickListener) ListProfile.this);
        }
    }

    public class MyAdapter extends BaseAdapter{

        LayoutInflater inflater;

        public MyAdapter() {
            inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return persons.listpersons.size();
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

            View v=convertView; // convertView d'un seul view
            if(v==null){

                v=inflater.inflate(R.layout.rangee_friend, parent, false);// on a crée notre propre layout
            }
            if(position%2==0) v.setBackgroundColor(0xFFE3B5B5);
            else v.setBackgroundColor(Color.WHITE);

            TextView tv=(TextView)v.findViewById(R.id.rangee_textFriend);
            ImageView im=(ImageView)v.findViewById(R.id.photoFriend);

            String user=persons.listpersons.get(position).getUserName();
           // String url=persons.listpersons.get(position).ImageUrl;

            tv.setText(user);
           // Picasso.with(getApplicationContext()).load(url).into(im);

            return v;
        }
    }
}
