package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActingAlbum extends AppCompatActivity {

    ArrayList<Songs> songsArrayList;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActingAlbum.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acting_album);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Alive",R.raw.alive));
        songsArrayList.add(new Songs("Bird Set Free",R.raw.bird_set_free));
        songsArrayList.add(new Songs("Broken Glass",R.raw.broken_glass));
        songsArrayList.add(new Songs("Cheap Thrills",R.raw.cheap_thrills));
        songsArrayList.add(new Songs("First Fighting",R.raw.first_fighting));
        songsArrayList.add(new Songs("Footprints",R.raw.footprints));
        songsArrayList.add(new Songs("House On Fire",R.raw.house_on_fire));
        songsArrayList.add(new Songs("Move Your Body",R.raw.move_your_body));
        songsArrayList.add(new Songs("One Million Bullets",R.raw.one_million_bullets));
        songsArrayList.add(new Songs("Reaper",R.raw.reaper));
        songsArrayList.add(new Songs("Space Between",R.raw.space_between));
        songsArrayList.add(new Songs("Summer Rain",R.raw.summer_rain));
        songsArrayList.add(new Songs("Sweet Design",R.raw.sweet_design));
        songsArrayList.add(new Songs("Unstoppable",R.raw.unstoppable));
        ActingSongsAdapter actingSongsAdapter=new ActingSongsAdapter(getApplicationContext(),R.layout.acting_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(actingSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActingAlbum.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });

    }
}