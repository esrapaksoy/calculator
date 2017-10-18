package com.example.esra_sinav;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class KayitliVeriler extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.kayitliveriler);

        TextView tv=(TextView) findViewById(R.id.tvTumKayitlar);
        Veritabani db=new Veritabani(KayitliVeriler.this);

        db.baglantiyiAc();

        String kayitlar=db.tumKayitlar();

        db.baglantiyiKapat();
        tv.setText(kayitlar);

    }
	

}
