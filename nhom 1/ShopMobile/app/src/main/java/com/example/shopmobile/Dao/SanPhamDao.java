package com.example.shopmobile.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shopmobile.Model.SanPham;

import java.util.ArrayList;

public class SanPhamDao {

    public static ArrayList<SanPham> getAll(Context context){
        ArrayList<SanPham> dssp = new ArrayList<>();
        DatabaseSP spData = new DatabaseSP(context);
        SQLiteDatabase db = spData.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SANPHAM",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idSP = cursor.getInt(0);
            String nameSPCs = cursor.getString(1);
            String giaSpCs = cursor.getString(2);
            String motaSP = cursor.getString(3);
            String imgSpCs = cursor.getString(4);
            SanPham sanPhamCs = new SanPham(idSP,nameSPCs,giaSpCs,motaSP,imgSpCs);
            dssp.add(sanPhamCs);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return dssp ;
    }

    public static boolean insertSPDAO(Context context,String nameSPD,String giaSPD,String motaSPD,String imgSPD){
        DatabaseSP spData = new DatabaseSP(context);
        SQLiteDatabase db = spData.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAMESP",nameSPD);
        values.put("GIASP",giaSPD);
        values.put("MOTASP",motaSPD);
        values.put("HINHSP",imgSPD);
        long row = db.insert("SANPHAM",null,values);
        return (row>0);
    }
}
