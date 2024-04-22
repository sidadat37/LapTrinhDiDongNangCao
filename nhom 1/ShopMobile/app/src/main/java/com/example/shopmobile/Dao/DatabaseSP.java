package com.example.shopmobile.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseSP extends SQLiteOpenHelper {
    public DatabaseSP(@Nullable Context context) {
        super(context, "qlllbh.sqlite", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreat = "CREATE TABLE IF NOT EXISTS SANPHAM" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAMESP TEXT," +
                "GIASP TEXT," +
                "MOTASP TEXT," +
                "HINHSP TEXT);";
        sqLiteDatabase.execSQL(sqlCreat);

        String sqlCreatx = "CREATE TABLE IF NOT EXISTS DATHANG" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAMESP TEXT," +
                "TKH TEXT," +
                "SDT TEXT," +
                "DIACHI TEXT);";
        sqLiteDatabase.execSQL(sqlCreatx);


//        String sqlInsert = "INSERT INTO SANPHAM VALUES (1, 'IP 14 PROMAX','300000','https://inkythuatso.com/uploads/thumbnails/800/2022/12/kich-thuoc-anh-6x9-09-10-02-03.jpg');";
//        sqLiteDatabase.execSQL(sqlInsert);
//        sqlInsert = "INSERT INTO SANPHAM VALUES (2, 'oppo neo 7','500000','https://inkythuatso.com/uploads/thumbnails/800/2022/12/kich-thuoc-anh-6x9-09-10-02-03.jpg');";
//        sqLiteDatabase.execSQL(sqlInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SANPHAM");
        onCreate(sqLiteDatabase);
    }
}
