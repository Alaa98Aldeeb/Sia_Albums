package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColourActivity extends AppCompatActivity {
    ArrayList<Songs> songsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Breath Me",R.raw.breathe_me));
        songsArrayList.add(new Songs("Butterflies",R.raw.butterflies));
        songsArrayList.add(new Songs("Don't Bring Me Down",R.raw.do_not_bring_me_down));
        songsArrayList.add(new Songs("Moon",R.raw.moon));
        songsArrayList.add(new Songs("Natale's Song",R.raw.natales_song));
        songsArrayList.add(new Songs("Numb",R.raw.numb));
        songsArrayList.add(new Songs("Rewrite",R.raw.rewrite));
        songsArrayList.add(new Songs("Sunday",R.raw.sunday));
        songsArrayList.add(new Songs("Sweet Potato",R.raw.sweet_potato));
        songsArrayList.add(new Songs("The Bully",R.raw.the_bully));
        songsArrayList.add(new Songs("The Church Of What Happening Now",R.raw.the_church_of_what_happening_now));
        songsArrayList.add(new Songs("Where I Belong",R.raw.where_i_belong));
        ColourSongsAdapter colourSongsAdapter=new ColourSongsAdapter(getApplicationContext(),R.layout.colour_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(colourSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ColourActivity.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ColourActivity.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }
}