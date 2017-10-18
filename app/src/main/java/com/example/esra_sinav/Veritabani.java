package com.example.esra_sinav;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani {

    private static final String DATABASE_ISIM = "hesaplamadb";
    private static final String DATABASE_TABLO = "sonuclartablosu";
    private static final int DATABASE_VERSION = 5;

    private final Context contextim;
    private VeritabaniHelper veritabanihelper;
    private SQLiteDatabase veritabanim;


    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_ISLEM = "_islem";
    public static final String KEY_SONUC = "_sonuc";


    public Veritabani(Context c) {
        this.contextim = c;
    }


    public Veritabani baglantiyiAc() throws SQLException {
        veritabanihelper = new VeritabaniHelper(contextim);
        veritabanim = veritabanihelper.getWritableDatabase();
        return this;
    }

    public void baglantiyiKapat() {
        veritabanihelper.close();
    }

    private static class VeritabaniHelper extends SQLiteOpenHelper {

        public VeritabaniHelper(Context context) {

            super(context, DATABASE_ISIM, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            db.execSQL("CREATE TABLE " + DATABASE_TABLO + "   (     " + KEY_ROW_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT,   " + KEY_ISLEM
                    + "  TEXT NOT NULL,   " + KEY_SONUC
                    + "  TEXT NOT NULL     );    ");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLO);

            onCreate(db);

        }

    }

    public void sonucKaydet(String islem, String sonuc) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ISLEM, islem);
        cv.put(KEY_SONUC, sonuc);

        veritabanim.insert(DATABASE_TABLO, null, cv);

    }


    public String tumKayitlar() {
        String[] sutunlar = new String[]{KEY_ROW_ID, KEY_ISLEM, KEY_SONUC};

        Cursor c = veritabanim.query(DATABASE_TABLO, sutunlar, null, null,
                null, null, null);

        String tk = "";

        int idSiraNo = c.getColumnIndex(KEY_ROW_ID);
        int islemSiraNo = c.getColumnIndex(KEY_ISLEM);
        int sonucSiraNo = c.getColumnIndex(KEY_SONUC);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
         tk = tk + c.getString(idSiraNo)                    + "                       " + c.getString(islemSiraNo)
                    + "                                       "                      +c.getString(sonucSiraNo) + "\n";
        }

        return tk;
    }







}




