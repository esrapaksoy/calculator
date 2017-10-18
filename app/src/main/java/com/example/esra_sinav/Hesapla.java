package com.example.esra_sinav;



import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hesapla extends Activity implements OnClickListener{

	  Button topla,cikar,carp,bol,kaydet,veriGetir;
	  EditText sayi1,sayi2;
    int toplaSonuc;
    String islem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hesapla);
		
		
		 topla = (Button) findViewById(R.id.btopla);
	     cikar = (Button) findViewById(R.id.bcikar);
	     carp  =(Button) findViewById(R.id.bcarp);        
	     bol = (Button) findViewById(R.id.bbol);
        kaydet=(Button) findViewById(R.id.bKaydet);
        veriGetir=(Button) findViewById(R.id.bVeriGetir);
	     
	     sayi1 = (EditText) findViewById(R.id.etsayi1);
         sayi2 = (EditText) findViewById(R.id.etsayi2);


			topla.setOnClickListener(this);
			cikar.setOnClickListener(this);
			carp.setOnClickListener(this);
			bol.setOnClickListener(this);
			kaydet.setOnClickListener(this);
            veriGetir.setOnClickListener(this);
	     
	     
	     
	}

	@Override
	public void onClick(View v) {
        String num1 = sayi1.getText().toString();
        int number1 = Integer.parseInt(num1);
        String num2 = sayi2.getText().toString();
        int number2 = Integer.parseInt(num2);

	switch (v.getId()) {
	case R.id.btopla:
       int toplaSonuc=number1 + number2;
        try {

            Dialog dialog=new Dialog(this,R.style.myBackgroundStyle);
            dialog.setTitle("Toplama İşlemi");
            TextView tvGoster=new TextView(this);
            tvGoster.setText(" Sonuç : "+  toplaSonuc);
            dialog.setContentView(tvGoster);
            dialog.show();
            this.toplaSonuc=toplaSonuc;
            islem="Toplama İşlemi";


        } catch (Exception e) {
            Dialog hata = new Dialog(this,R.style.myBackgroundStyle);
            hata.setTitle("Hata");
            TextView tvHata = new TextView(this);
            tvHata.setText(e.toString());
            hata.setContentView(tvHata);
            hata.show();
        }
	break;

    case R.id.bcikar:

       int cikarSonuc=number1 - number2;
        try {

            Dialog dialog=new Dialog(this,R.style.myBackgroundStyle);
            dialog.setTitle("Çıkarma İşlemi");
            TextView tvGoster=new TextView(this);
            tvGoster.setText(" Sonuç: "+  cikarSonuc);
            dialog.setContentView(tvGoster);
            dialog.show();
            this.toplaSonuc=cikarSonuc;
            islem="Çıkarma İşlemi";

        } catch (Exception e) {
            Dialog hata = new Dialog(this,R.style.myBackgroundStyle);
            hata.setTitle("Hata");
            TextView tvHata = new TextView(this);
            tvHata.setText(e.toString());
            hata.setContentView(tvHata);
            hata.show();
        }
    break;

    case R.id.bcarp:
        int carpSonuc=number1 * number2;
        try {

            Dialog dialog=new Dialog(this,R.style.myBackgroundStyle);
            dialog.setTitle("Çarpma İşlemi");
            TextView tvGoster=new TextView(this);
            tvGoster.setText(" Sonuç:  "+ carpSonuc);
            dialog.setContentView(tvGoster);

            dialog.show();
            this.toplaSonuc=carpSonuc;
            islem="Çarpma İşlemi";
        } catch (Exception e) {
            Dialog hata = new Dialog(this,R.style.myBackgroundStyle);
            hata.setTitle("Hata");
            TextView tvHata = new TextView(this);
            tvHata.setText(e.toString());
            hata.setContentView(tvHata);
            hata.show();
        }
    break;

   case R.id.bbol:
      int bolSonuc=number1 / number2;
       try {

           Dialog dialog=new Dialog(this,R.style.myBackgroundStyle);
           dialog.setTitle("Bölme İşlemi");
           TextView tvGoster=new TextView(this);
           tvGoster.setText(" Sonuç: "+  bolSonuc);
           dialog.setContentView(tvGoster);
           dialog.show();
           this.toplaSonuc=bolSonuc;
           islem="Bölme İşlemi";

       } catch (Exception e) {
           Dialog hata = new Dialog(this,R.style.myBackgroundStyle);
           hata.setTitle("Hata");
           TextView tvHata = new TextView(this);
           tvHata.setText(e.toString());
           hata.setContentView(tvHata);
           hata.show();
       }
   break;
	
        case R.id.bKaydet:

            try{
                Veritabani db = new Veritabani(Hesapla.this);
                db.baglantiyiAc();


                db.sonucKaydet(islem,String.valueOf(this.toplaSonuc));
                db.baglantiyiKapat();
            }

            catch (Exception e){
                Dialog hata = new Dialog(this,R.style.myBackgroundStyle);
                hata.setTitle("Ekleme İşlemi");
                TextView tvHata = new TextView(this);
                tvHata.setText(e.toString());
                hata.setContentView(tvHata);
                hata.show();
            }

            finally{
                Dialog dialog = new Dialog(this,R.style.myBackgroundStyle);
                dialog.setTitle("Ekleme İşlemi");
                TextView tvSonuc = new TextView(this);
                tvSonuc.setText("Başarılı");
                dialog.setContentView(tvSonuc);

                dialog.show();
            }


            break;

        case R.id.bVeriGetir:
            Intent i= new Intent("com.example.esra_sinav.KAYITLIVERILER");
            startActivity(i);


        break;
	}
		
	}
	
	

}
