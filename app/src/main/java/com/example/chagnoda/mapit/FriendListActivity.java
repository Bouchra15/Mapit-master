package com.example.chagnoda.mapit;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by chengli on 2016-03-21.
 */
public class FriendListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

        ListView listView;
        MyAdapder adapter;
        Profile friendsProfile;
        String typeProfile;  // nom du profile qui a la liste des amis
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_list);

            Intent intent=getIntent();
            //typeProfile=intent.getStringExtra("TYPELISTE");

            listView=(ListView)findViewById(R.id.listFriends);
            RunAPI run=new RunAPI();
            run.execute(); // va appeler  doInBackground

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }

        public class RunAPI extends AsyncTask<String, Object, Profile> {


            @Override
            protected Profile doInBackground(String... params) {

                webAPI web=new webAPI();

                try{
                    friendsProfile=web.run();
                }catch (IOException e){}
                return friendsProfile;

            }

            @Override
            protected void onPostExecute(Profile lineup) {
                super.onPostExecute(lineup);
                adapter=new MyAdapder();
                listView.setAdapter(adapter);
                //listView.setOnItemClickListener(FriendListActivity.this);
            }
        }

        public class MyAdapder extends BaseAdapter {

            LayoutInflater inflater; // récuperer un layout pour un seul item

            public MyAdapder(){
                inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            }


            @Override
            public int getCount() {
                return friendsProfile.friends.size();
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
                return null;
            }
        }

    }
