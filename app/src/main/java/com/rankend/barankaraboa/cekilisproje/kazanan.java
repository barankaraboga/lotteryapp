package com.rankend.barankaraboa.cekilisproje;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Baran on 10.05.2016.
 */
public class kazanan extends Activity {

    private MediaPlayer ses;

    private TextView kazanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kazandi);

        ses = MediaPlayer.create(kazanan.this,R.raw.alkis);
        ses.start();

        kazanan = (TextView) findViewById(R.id.textViewKazanan);
        Bundle gelen = getIntent().getExtras();
        String gelenKazanan = gelen.getString("sansli");
        kazanan.setText(gelenKazanan);




    }
}
