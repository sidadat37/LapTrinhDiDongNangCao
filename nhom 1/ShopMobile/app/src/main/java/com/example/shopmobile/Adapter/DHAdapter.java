package com.example.shopmobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopmobile.Main.MainActivitydt2;
import com.example.shopmobile.Model.DanHang;
import com.example.shopmobile.Model.SanPham;
import com.example.shopmobile.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DHAdapter  extends RecyclerView.Adapter<DHAdapter.ViewHolder>{
    Context context ;
    ArrayList<DanHang> listDH ;

    public DHAdapter(Context context, ArrayList<DanHang> listDH) {
        this.context = context;
        this.listDH = listDH;
    }

    @NonNull
    @Override
    public DHAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dathang,parent,false);
        return new DHAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DanHang danHang = listDH.get(i);
        viewHolder.textViewTSP.setText("Tên Sản PHẩm  : " +listDH.get(i).getTenSPHang());
        viewHolder.txtKhangHang.setText("Tên KH  : " +listDH.get(i).getTenKhang());
        viewHolder.textViewSDTxx.setText("SDT : " +listDH.get(i).getSDT());
        viewHolder.textViewDC.setText("Địa Chỉ : " +listDH.get(i).getDIaCHi());
    }


    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTSP , txtKhangHang ,textViewSDTxx , textViewDC ;

        CardView cardViewSP ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTSP = (TextView) itemView.findViewById(R.id.txt_tenSanPham2);
            txtKhangHang = (TextView) itemView.findViewById(R.id.txtKhachhabg);
            textViewSDTxx = (TextView) itemView.findViewById(R.id.txtSDT222);
            textViewDC = (TextView) itemView.findViewById(R.id.txtDiaChi);
            cardViewSP = (CardView) itemView.findViewById(R.id.cardview2);
        }
    }
}
