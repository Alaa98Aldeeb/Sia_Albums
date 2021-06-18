package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChristmasAlbum extends AppCompatActivity {

    ArrayList<Songs> songsArrayList;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChristmasAlbum.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas_album);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Candy Can Lan",R.raw.candy_cane_lane));
        songsArrayList.add(new Songs("Every Day Is Christmas",R.raw.everyday_is_christmas));
        songsArrayList.add(new Songs("Ho Ho Ho",R.raw.ho_ho_ho));
        songsArrayList.add(new Songs("Puppies Are Forever",R.raw.puppies_are_forever));
        songsArrayList.add(new Songs("Santa's Coming For Us",R.raw.santas_coming_for_us));
        songsArrayList.add(new Songs("Snowflake",R.raw.snowflake));
        songsArrayList.add(new Songs("Snowman",R.raw.snowman));
        songsArrayList.add(new Songs("Sunshine",R.raw.sunshine));
        songsArrayList.add(new Songs("Underneath The Mistletoe",R.raw.underneath_the_mistletoe));
        songsArrayList.add(new Songs("Underneath The Christmas Ligth",R.raw.underneaththe_christmas_lights));
        ChristmasSongsAdapter christmasSongsAdapter=new ChristmasSongsAdapter(getApplicationContext(),R.layout.christmas_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(christmasSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChristmasAlbum.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });
    }
}