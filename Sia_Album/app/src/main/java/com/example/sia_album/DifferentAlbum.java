package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DifferentAlbum extends AppCompatActivity {

    ArrayList<Songs> songsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_album);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Blow It All WAy",R.raw.blow_it_all_away));
        songsArrayList.add(new Songs("Drink To Get Drunk",R.raw.drink_to_get_drunk));
        songsArrayList.add(new Songs("Fear",R.raw.fear));
        songsArrayList.add(new Songs("Get Me",R.raw.get_me));
        songsArrayList.add(new Songs("Healing Is Difficult",R.raw.healing_is_difficult));
        songsArrayList.add(new Songs("I'am Not Important To You",R.raw.iam_not_important_to_you));
        songsArrayList.add(new Songs("Insidiously",R.raw.insidiously));
        songsArrayList.add(new Songs("Judge Me",R.raw.judge_me));
        songsArrayList.add(new Songs("Little Man (Exemen Works)",R.raw.little_man_exemen_works));
        songsArrayList.add(new Songs("Sober and Unkissed",R.raw.sober_and_unkissed));
        songsArrayList.add(new Songs("Taken For Granted",R.raw.taken_for_granted));

        DifficultSongsAdapter difficultSongsAdapter=new DifficultSongsAdapter(getApplicationContext(),R.layout.diffcult_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(difficultSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DifferentAlbum.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DifferentAlbum.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }
}