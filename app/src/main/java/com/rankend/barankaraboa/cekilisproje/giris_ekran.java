package com.rankend.barankaraboa.cekilisproje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Baran on 10.05.2016.
 */
public class giris_ekran extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girisekran);

        Timer zaman = new Timer();

        zaman.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent gecis = new Intent(giris_ekran.this,MainActivity.class);
                startActivity(gecis);
                finish();
            }
        },3000);

    }
}
