package com.example.video_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView v1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = findViewById(R.id.video);

        String path = "android.resource://"+getPackageName()+"/raw/video";
        Uri path1 = Uri.parse(path);
        v1.setVideoURI(path1);

        MediaController controller = new MediaController(getApplicationContext());
        controller.setAnchorView(v1);
        v1.setMediaController(controller);

        // Start video playback
        v1.start();
    }
}