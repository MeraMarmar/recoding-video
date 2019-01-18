package com.example.allinone.recodingvido;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView videoView;
int rq=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=(VideoView)findViewById(R.id.videoView);
    }


    public void camera(View view) {
        Intent take =new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (take.resolveActivity(getPackageManager())!=null){
           startActivityForResult(take,rq);
        }
    }
    protected void onActivityResult(int rquestcode,int resultcode,Intent data){
        if(rquestcode==rq&&resultcode==RESULT_OK){
            Uri vidoUri=data.getData();
            videoView.setVideoURI(vidoUri);
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();
        }
    }
}
