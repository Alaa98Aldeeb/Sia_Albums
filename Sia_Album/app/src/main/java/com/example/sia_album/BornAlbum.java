package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BornAlbum extends AppCompatActivity {

    ArrayList<Songs> songsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_born_album);

        songsArrayList=new ArrayList<>();
        songsArrayList.add(new Songs("Be Good To Me",R.raw.be_good_to_me));
        songsArrayList.add(new Songs("Big Girl Little Girl",R.raw.big_girl_little_girl));
        songsArrayList.add(new Songs("Bring Night",R.raw.bring_night));
        songsArrayList.add(new Songs("Clap Your Hand",R.raw.clap_your_hand));
        songsArrayList.add(new Songs("Cloud",R.raw.cloud));
        songsArrayList.add(new Songs("Hurting Me Now",R.raw.hurting_me_now));
        songsArrayList.add(new Songs("I'am In Here",R.raw.iam_in_here));
        songsArrayList.add(new Songs("Never Gonna Leave Me",R.raw.never_gonna_leave_me));
        songsArrayList.add(new Songs("Oh Father",R.raw.oh_father));
        songsArrayList.add(new Songs("Stop Trying",R.raw.stop_trying));
        songsArrayList.add(new Songs("The Co-dependent",R.raw.the_codependent));
        songsArrayList.add(new Songs("The Flight",R.raw.the_fight));
        songsArrayList.add(new Songs("You've Changed",R.raw.youve_changed));
        BornSongsAdapter bornSongsAdapter=new BornSongsAdapter(getApplicationContext(),R.layout.born_album_songs_item,songsArrayList);
        final ListView listView =findViewById(R.id.together_albun_songs_list);
        listView.setAdapter(bornSongsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BornAlbum.this, Player.class);
                intent.putParcelableArrayListExtra("songsList",songsArrayList);
                intent.putExtra("key",position);
                intent.putExtra("songName",songsArrayList.get(position).getSongSource());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BornAlbum.this, fullAlbums.class);
        startActivity(intent);
        finish();
    }
}