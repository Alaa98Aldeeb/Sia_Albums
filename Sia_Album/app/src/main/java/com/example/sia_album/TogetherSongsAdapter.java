package com.example.sia_album;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TogetherSongsAdapter extends ArrayAdapter<Songs> {
    private ArrayList<Songs> songsList;
    public TogetherSongsAdapter(@Nullable Context context, int resource, ArrayList<Songs> songsList){
        super(context, resource,songsList);
        this.songsList=songsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.together_album_songs_item,parent,false);
        }
        TextView tSongName = convertView.findViewById(R.id.song_name);
        tSongName.setText(songsList.get(position).getSongName());
        return convertView;
    }
}
