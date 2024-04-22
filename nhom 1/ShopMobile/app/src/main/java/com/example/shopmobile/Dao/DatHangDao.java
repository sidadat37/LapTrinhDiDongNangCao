package com.example.shopmobile.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import com.example.shopmobile.Main.MainActivity_gioHang;
import com.example.shopmobile.Model.DanHang;
import com.example.shopmobile.Model.SanPham;

import java.util.ArrayList;

public class DatHangDao {
    public static ArrayList<DanHang> getAll(Context context){
        ArrayList<DanHang> dssp = new ArrayList<>();
        DatabaseSP spData = new DatabaseSP(context);
        SQLiteDatabase db = spData.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DATHANG",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int idSP = cursor.getInt(0);
            String nameDPCs = cursor.getString(1);
            String giaDpCs = cursor.getString(2);
            String motaDP = cursor.getString(3);
            String imgDCs = cursor.getString(4);
            DanHang sanPhamCDs = new DanHang(idSP,nameDPCs,giaDpCs,motaDP,imgDCs);
            dssp.add(sanPhamCDs);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return dssp ;
    }

    public static boolean insertDHDAO(Context context,String nameSPD,String tkhh,String sdtt,String diachi){
        DatabaseSP spData = new DatabaseSP(context);
        SQLiteDatabase db = spData.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAMESP",nameSPD);
        values.put("TKH",tkhh);
        values.put("SDT",sdtt);
        values.put("DIACHI",diachi);
        long row = db.insert("DATHANG",null,values);
        return (row>0);
    }

}
