package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView i1,i2,i3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1 = findViewById(R.id.pause);
        i2 = findViewById(R.id.play);
        i3 = findViewById(R.id.stop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        https://tinyurl.com/rkuaudio
        String path = "android.resource://"+getPackageName()+"/raw/a";
        Uri path1 = Uri.parse(path);



        try {
            mp.setDataSource(this, path1);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();

                int current_position = mp.getCurrentPosition();
                Toast.makeText(MainActivity.this, ""+current_position, Toast.LENGTH_LONG);

            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}