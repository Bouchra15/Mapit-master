package com.example.chagnoda.mapit;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by fananebo on 16-03-31.
 */
public class webAPI {

    public String url;
    public String typeProfile;

    public webAPI() {
      url = "https://sizzling-inferno-6141.firebaseio.com/Mapit.json";
      //typeProfile=NameProfile;
    }

    public Profile run() throws IOException {

        //récuperer le contenu hatml a partir d'un url
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Response response=client.newCall(request).execute();
        String json=response.body().string();

        //parser le contenu json à partir de la string json
        Moshi moshi=new Moshi.Builder().build();// MOSHI LIBRAIRIE QUI PERMET DE FAIRE PARSING
        JsonAdapter<Root> jsonAdapter=moshi.adapter(Root.class);                      // on lui donne la hierarchie qu'il est supposé à avoir comme
        Root root=jsonAdapter.fromJson(json); // mettre tout le contenu de json dans root et c'est moshi qui fait ça

        // Récupérer les films

        Profile profile;
        for(int i=0; i<root.Profiles.size(); i++){
            // if(root.Lineups.get(i).Title.equals("Films")){
                profile=root.Profiles.get(i);
                return profile;

        }
        return null;
    }
}
