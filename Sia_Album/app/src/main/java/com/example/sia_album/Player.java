package com.example.sia_album;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Player extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView playPause, next, previous;
    int currentSec, song, positionItem, remainTime;
    String title;
    TextView songName;
    ArrayList<Songs> arrayList;
    SeekBar seekBarTime;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Player.this,fullAlbums.class);
        startActivity(intent);
        mediaPlayer.stop();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        song = intent.getIntExtra("songName",0);
        positionItem = intent.getIntExtra("key",0);
        arrayList = intent.getParcelableArrayListExtra("songsList");

        playPause=findViewById(R.id.pausePlay);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        songName = findViewById(R.id.songTitle);
        seekBarTime = findViewById(R.id.seekBar);

        reserMusicPlayer(positionItem);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()){
                    currentSec=mediaPlayer.getCurrentPosition();
                    playPause.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                }else{
                    playPause.setImageResource(R.drawable.pause);
                    mediaPlayer.seekTo(currentSec);
                    mediaPlayer.start();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPause.setImageResource(R.drawable.pause);
                if (positionItem < arrayList.size()-1){
                    positionItem++;
                }else{
                    positionItem = 0;
                }
                reserMusicPlayer(positionItem);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPause.setImageResource(R.drawable.pause);

                if (positionItem == 0){
                    positionItem = arrayList.size()-1;
                }else {
                    positionItem--;
                }
                reserMusicPlayer(positionItem);

            }
        });

    }
    public void reserMusicPlayer(final int position){
        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }
        title = arrayList.get(position).getSongName();
        songName.setText(title);

        song= arrayList.get(position).getSongSource();
        mediaPlayer = mediaPlayer.create(getApplicationContext(),song);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBarTime.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                reserMusicPlayer(arrayList.indexOf(arrayList.get(position)));
            }
        });

        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    playPause.setImageResource(R.drawable.pause);
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null){
                    try {
                        if (mediaPlayer.isPlaying()){
                            Message message = new Message();
                            message.what = mediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            seekBarTime.setProgress(msg.what);
        }
    };
}