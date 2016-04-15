package com.example.chagnoda.mapit;

import android.util.Log;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by fananebo on 16-03-31.
 */
public class webAPI {

    public String url;
    public String typeProfile;

    public webAPI() {
     // url = "https://sizzling-inferno-6141.firebaseio.com/Mapit.json";
      //typeProfile=NameProfile;
    }

    public Persons run() throws IOException {

        final Persons persons = new Persons();
        final Person person = new Person();

        ///Mapit/Profiles.json
        Firebase myFirebaseRef = new Firebase("https://sizzling-inferno-6141.firebaseio.com/");

        myFirebaseRef.child("Mapit/Profiles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("firebase", String.valueOf(snapshot.getValue()));
                Log.d("firebase", "Compte = " + snapshot.getChildrenCount());

                for (DataSnapshot child : snapshot.getChildren()) {
                    //Log.d("firebase", "enfant : " + String.valueOf(child));
                  //  Log.d("firebase", "key    : " + child.getKey());
                   // Log.d("firebase", "value  : " + String.valueOf(child.getValue()));
                   // Log.d("firebase", "email  : " + String.valueOf(child.child("email").getValue()));

                    Person newperson=child.getValue(Person.class);
                    newperson.getUserName();
                    newperson.getEmail();
                    newperson.getPassword();
                   // person.key = child.getKey();
                  //  person.email = String.valueOf(child.child("email").getValue());
                   // person.username = String.valueOf(child.child("userName").getValue());
                  //  person.password = String.valueOf(child.child("password").getValue());

                    // a verifier
                    persons.listpersons.add(person);
                }
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }

            });
            Log.d("PERSONS SIZE ", ((Integer)persons.listpersons.size()).toString());
            return persons;

        }

}
