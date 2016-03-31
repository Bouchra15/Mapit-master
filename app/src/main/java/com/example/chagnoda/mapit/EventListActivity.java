package com.example.chagnoda.mapit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by chengli on 2016-03-21.
 */
public class EventListActivity extends AppCompatActivity{
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        list=(ListView)findViewById(R.id.listEvent);
    }
}
