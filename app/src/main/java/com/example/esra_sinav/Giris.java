package com.example.esra_sinav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class Giris  extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giris);
		
		

		Thread zamanlayici = new Thread(){
			
			public void run(){
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					Intent anaEkranCagir = new Intent("com.example.esra_sinav.HESAPLA");					
					startActivity(anaEkranCagir);
					
				}
				
			}
			
		};
	
		zamanlayici.start();	
	
		
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	
	
	
	
}
