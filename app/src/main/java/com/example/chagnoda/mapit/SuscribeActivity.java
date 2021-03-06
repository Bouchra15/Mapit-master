package com.example.chagnoda.mapit;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.client.Firebase;

import org.w3c.dom.Text;

/**
 * Created by chengli on 2016-03-21.
 */
public class SuscribeActivity extends AppCompatActivity implements View.OnClickListener{
    Button suscribe;
    TextView username_view,email_view, password_view, confirmed_password_view;
    ImageButton profilepicture_view;
    ImageButton imagePick;
    private final static int SELECT_PHOTO = 12345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_suscribe);
        suscribe = (Button)findViewById(R.id.suscribebutton);
        suscribe.setOnClickListener(this);
        imagePick = (ImageButton)findViewById(R.id.profileimagebutton);
        imagePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Here we need to check if the activity that was triggers was the Image Gallery.
        // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
        // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
        if (requestCode == SELECT_PHOTO && resultCode == RESULT_OK && data != null) {
            // Let's read picked image data - its URI
            Uri pickedImage = data.getData();
            // Let's read picked image path using content resolver
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
            imagePick.setImageBitmap(bitmap);

            // Do something with the bitmap


            // At the end remember to close the cursor or you will end with the RuntimeException!
            cursor.close();
        }
    }

    @Override
    public void onClick(View v) {

        username_view = (TextView)findViewById(R.id.usernamebox);
        String username = username_view.getText().toString();
        email_view = (TextView)findViewById(R.id.emailbox);
        String email = email_view.getText().toString();
        password_view = (TextView)findViewById(R.id.passwordbox);
        String password = password_view.getText().toString();
        confirmed_password_view = (TextView)findViewById(R.id.confirmedpasswordbox);
        String confirmed_password = confirmed_password_view.getText().toString();
        profilepicture_view = (ImageButton) findViewById(R.id.profileimagebutton);
        //Image profilepicture = profilepicture_view.get();

        // note: a implementer, condition d'acceptation d'un nouvel acompte
        Profile new_user = new Profile(username,email,password);
        Firebase ref = new Firebase("https://sizzling-inferno-6141.firebaseio.com/Mapit/Profiles");
        ref.child(email).setValue(new_user);
        // a implementer, ajouter le profil a firebase
        startActivity(new Intent("com.example.chagnoda.mapit.MainActivity"));

    }
}
