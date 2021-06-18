package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class TogetherAlbum extends AppCompatActivity {
    ArrayList<Songs> songsArrayList;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TogetherAlbum.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_together_album);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Beautiful Things Can Happen",R.raw.beautiful_things_can_happen));
        songsArrayList.add(new Songs("Courage To Change",R.raw.courage_to_change));
        songsArrayList.add(new Songs("Eye To Eye",R.raw.eye_to_eye));
        songsArrayList.add(new Songs("Floating Through Space",R.raw.floating_through_space));
        songsArrayList.add(new Songs("Hey Boy",R.raw.hey_boy));
        songsArrayList.add(new Songs("Lie To Me",R.raw.lie_to_me));
        songsArrayList.add(new Songs("Miracle",R.raw.miracle));
        songsArrayList.add(new Songs("Music",R.raw.music));
        songsArrayList.add(new Songs("Oblivion",R.raw.oblivion));
        songsArrayList.add(new Songs("Play Dumb",R.raw.play_dumb));
        songsArrayList.add(new Songs("Saved My Life",R.raw.saved_my_life));
        songsArrayList.add(new Songs("Together",R.raw.together));
        songsArrayList.add(new Songs("1+1",R.raw.one_plus_one));
        TogetherSongsAdapter togetherSongsAdapter=new TogetherSongsAdapter(getApplicationContext(),R.layout.together_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(togetherSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TogetherAlbum.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });
      //intent.putExtra("song",songsArrayList.get(position).getSongSource());
    }
}