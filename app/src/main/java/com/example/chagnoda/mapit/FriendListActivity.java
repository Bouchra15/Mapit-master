package com.example.chagnoda.mapit;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by chengli on 2016-03-21.
 */
public class FriendListActivity extends AppCompatActivity{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        listView=(ListView)findViewById(R.id.listFriends);
    }
}
