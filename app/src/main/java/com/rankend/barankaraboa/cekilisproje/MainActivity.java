package com.rankend.barankaraboa.cekilisproje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button butonKaydet,butonCek;
    private ListView liste;
    private EditText veriAl;
    private TextView isimListGoruntu;
    private ArrayList<String>listeVeri;
    private  ArrayAdapter<String> verilerim;
    private  AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Hata !");
        builder.setMessage("Lütfen isim giriniz.");
        builder.setCancelable(true);

        setTitle("Çekiliş YAP");
        listeVeri = new ArrayList<>();
        butonCek = (Button)findViewById(R.id.buttonCek);
        butonKaydet = (Button)findViewById(R.id.buttonKaydet);
        liste = (ListView) findViewById(R.id.listView);
        isimListGoruntu = (TextView)findViewById(R.id.textView);
        veriAl = (EditText) findViewById(R.id.editText);


       verilerim = new ArrayAdapter<String>(
         this,android.R.layout.simple_list_item_1
                ,android.R.id.text1,listeVeri


        );
        verilerim.notifyDataSetChanged();


        butonCek.setEnabled(false);

        butonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(veriAl.getText().toString().trim().equals(""))
                {
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else {
                   isimListGoruntu.setText("");
                    listeVeri.add(veriAl.getText().toString());
                    liste.setAdapter(verilerim);
                    butonCek.setEnabled(true);
                    veriAl.setText("");
                }
            }
        });

        butonCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kazan = cek();
                Intent gecisim = new Intent(MainActivity.this,kazanan.class);
                gecisim.putExtra("sansli",kazan);
                startActivity(gecisim);


            }
        });


    }

    int rasSayi=0;
    String sansli;
    public String cek()
    {
        rasSayi = (int)(Math.random()*listeVeri.size());
        sansli = listeVeri.get(rasSayi);
        return sansli;

    }


}
