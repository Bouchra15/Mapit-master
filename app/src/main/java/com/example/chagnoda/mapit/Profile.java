package com.example.chagnoda.mapit;
import android.media.Image;

import java.util.List;

/**
 * Created by David on 22/03/2016.
 */
public class Profile {

    private String email;
    private String password;
    private Image profilepicture;  //
   // private Profile[] friends;
    private Photo[] photos;
    private String Password;


    public String userName; //
    public String photoUrl;

    public List<Friend> friends; //
   // private Profile[] ;
    public List<Event> events;


   // public Groupe[] actualGroups;
   // public Groupe[] groupsHistory;

    public Profile(){}
    public Profile(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.password = password;
        //this.profilepicture = profilePicture;
    }
    public String getUserName(){
        return this.userName;
    }
    public Image getProfilePicture(){return this.profilepicture;}
    public void setUserName(String newUserName) {this.userName = newUserName;}
    public void setProfilePicture(Image newProfilePicture){this.profilepicture = newProfilePicture;}

    }




