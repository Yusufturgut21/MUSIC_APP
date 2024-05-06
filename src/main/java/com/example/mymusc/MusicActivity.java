package com.example.mymusc;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mymusc.R;
public class MusicActivity extends AppCompatActivity {
    private ListView musicListView;
    private Button playButton;
    private MediaPlayer mediaPlayer;
    private int currentSongIndex = -1;

    private String[] musicList = {
            "Şarkı 1",
            "Şarkı 2",
            "Şarkı 3",
            "Şarkı 4",
            "Şarkı 5",
            "Şarkı 6",
            "Şarkı 7",
            "Şarkı 8",
            "Şarkı 9",
            "Şarkı 10",
            "Şarkı 11",
            "Şarkı 12",
            "Şarkı 13"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);



        musicListView = findViewById(R.id.musicListView);
        playButton = findViewById(R.id.playButton);




        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, musicList);
        musicListView.setAdapter(adapter);

        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSongIndex = position;
                playMusic();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setText("Çal");
                } else {
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                        playButton.setText("Duraklat");
                    } else {
                        playMusic();
                    }
                }
            }
        });
    }

    private void playMusic() {
        if (currentSongIndex >= 0 && currentSongIndex < musicList.length) {
            int musicResourceId = getMusicResourceId(currentSongIndex);
            if (musicResourceId != 0) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(this, musicResourceId);
                mediaPlayer.start();
                playButton.setText("Duraklat");
            }
        }
    }

    private int getMusicResourceId(int index) {
        switch (index) {
            case 0:
                return R.raw.zey1;
            case 1:
                return R.raw.zey2;
            case 2:
                return R.raw.zey3;
            case 3:
                return R.raw.zey4;
            case 4:
                return R.raw.zey5;
            case 5:
                return R.raw.zey6;
            case 6:
                return R.raw.zey7;
            case 7:
                return R.raw.ses1;
            case 8:
                return R.raw.ses2;
            case 9:
                return R.raw.ses3;
            case 10:
                return R.raw.ses4;
            case 11:
                return R.raw.yen1;

            case 12:
                return R.raw.yen2;



            default:
                return 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
