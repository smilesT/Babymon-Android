package com.smilest.babymon_android;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.smilest.babymon_android.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    String videoURL = "https://www.ebookfrenzy.com/android_book/movie.mp4";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private VideoView videoView;
    private ProgressBar progressBar;
    private ImageView thumbnail;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        progressBar = findViewById(R.id.progressBar);
        //thumbnail = findViewById(R.id.thumbnail);
        mediaController = new MediaController(this);

        // Set the thumbnail image
        //thumbnail.setImageResource(R.drawable.thumbnail_image);

        // Set the progress bar to be shown when the video is buffering
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
            }
        });
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
                    progressBar.setVisibility(View.VISIBLE);
                } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                    progressBar.setVisibility(View.GONE);
                }
                return false;
            }
        });

        // Set a custom media controller layout
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle next button click
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle previous button click
            }
        });

        // Set the media controller to the video view
        videoView.setMediaController(mediaController);

        // Set the video URI
        Uri uri = Uri.parse(videoURL);
        videoView.setVideoURI(uri);

        // Start playing the video
        videoView.start();
    }
}


//
//
//package com.smilest.babymon_android;
//
//import android.net.Uri;
//import android.os.Bundle;
//
//import com.google.android.material.snackbar.Snackbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import com.smilest.babymon_android.databinding.ActivityMainBinding;
//
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
//public class MainActivity extends AppCompatActivity {
//
//    //String videoURL = "android.resource://" + getPackageName() + "/" + R.raw.bigbuckbunny;
//
//    String videoURL = "https://www.ebookfrenzy.com/android_book/movie.mp4";
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
//
//    private VideoView videoView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        videoView = findViewById(R.id.videoView);
//
//        // Uri object to refer the
//        // resource from the videoUrl
//        Uri uri = Uri.parse(videoURL);
//
//        // sets the resource from the
//        // videoUrl to the videoView
//        videoView.setVideoURI(uri);
//
//        // creating object of
//        // media controller class
//        MediaController mediaController = new MediaController(this);
//
//        // sets the anchor view
//        // anchor view for the videoView
//        mediaController.setAnchorView(videoView);
//
//        // sets the media player to the videoView
//        mediaController.setMediaPlayer(videoView);
//
//        // sets the media controller to the videoView
//        videoView.setMediaController(mediaController);
//
//        // starts the video
//        videoView.start();
//
//    }


//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
 //   }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}