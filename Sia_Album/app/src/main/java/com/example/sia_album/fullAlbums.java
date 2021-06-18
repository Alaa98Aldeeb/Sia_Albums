package com.example.sia_album;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fullAlbums extends AppCompatActivity {

    CardView together, acting, colour, difficult, christmas, born;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_albums);

        together=findViewById(R.id.togetherAlbum);
        acting=findViewById(R.id.actingAlbum);
        colour=findViewById(R.id.colourAlbum);
        difficult=findViewById(R.id.difficultAlbum);
        christmas=findViewById(R.id.christmasAlbum);
        born=findViewById(R.id.bornAlbum);

        together.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,TogetherAlbum.class);
                startActivity(tAlbum);
                finish();
            }
        });
        acting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,ActingAlbum.class);
                startActivity(tAlbum);
                finish();
            }
        });
        colour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,ColourActivity.class);
                startActivity(tAlbum);
                finish();
            }
        });
        difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,DifferentAlbum.class);
                startActivity(tAlbum);
                finish();
            }
        });
        christmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,ChristmasAlbum.class);
                startActivity(tAlbum);
                finish();
            }
        });
        born.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tAlbum = new Intent(fullAlbums.this,BornAlbum.class);
                startActivity(tAlbum);
                finish();
            }
        });
    }
}