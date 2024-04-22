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
import com.example.shopmobile.Model.SanPham;
import com.example.shopmobile.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SPAdapter extends RecyclerView.Adapter<SPAdapter.ViewHolder>{
    Context context ;
    ArrayList<SanPham> listSP ;

    public SPAdapter(Context context, ArrayList<SanPham> listSP) {
        this.context = context;
        this.listSP = listSP;
    }

    @NonNull
    @Override
    public SPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SPAdapter.ViewHolder viewHolder, int i) {
        SanPham sanPham = listSP.get(i);
        viewHolder.textViewTSP.setText(sanPham.getNameSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.textViewGSP.setText("Giá : "+decimalFormat.format(Double.parseDouble(sanPham.getGiaSP())));
        //viewHolder.imageViewSP.setImageResource(sanPham.getHinhSP());
        Picasso.get().load(listSP.get(i).getHinhSP()).into(viewHolder.imageViewSP);

        viewHolder.cardViewSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MainActivitydt2.class);
                intent.putExtra("TSP",listSP.get(i).getNameSP());
                intent.putExtra("GSP",listSP.get(i).getGiaSP());
                intent.putExtra("MTSP",listSP.get(i).getMotaSP());
                intent.putExtra("IMGSP",listSP.get(i).getHinhSP());
      //          intent.putExtra("imageSP",listSP.get(i).getImageSP());
//
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(context, "Lỗi inteC", Toast.LENGTH_SHORT).show();
                }
               
            }
        });


    }

    @Override
    public int getItemCount() {
        return listSP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTSP , textViewGSP ;
        ImageView imageViewSP ;
        CardView cardViewSP ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTSP = (TextView) itemView.findViewById(R.id.txtTSP);
            textViewGSP = (TextView) itemView.findViewById(R.id.txtGSP);
            imageViewSP = (ImageView) itemView.findViewById(R.id.imageSP);
            cardViewSP = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
