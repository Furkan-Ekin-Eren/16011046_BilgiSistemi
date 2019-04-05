package com.example.asdf;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    ArrayList<Dersler> mDataList;
    LayoutInflater inflater;
    Context lel;
    public Adapter(Context context,ArrayList<Dersler> data){
        this.lel=context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDataList=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=inflater.inflate(R.layout.list_item,viewGroup,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Dersler tiklanılanDers=mDataList.get(i);
        myViewHolder.setData(tiklanılanDers,i);
        myViewHolder.mDersAdı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent istek = new Intent(lel,Ayrinti.class);
                String[] dizi={tiklanılanDers.getAd(),tiklanılanDers.getNotOrt(),tiklanılanDers.getSay()};
            istek.putExtra("dizi",dizi);
            lel.startActivity(istek);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void deleteItem(int i){
        mDataList.remove(i);
        notifyItemRemoved(i);
    }

    public void addItem(int i,Dersler kopya){
       mDataList.add(i,kopya);
       notifyItemInserted(i);
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mDersAdı,mDersNotu;
        ImageView mDersResmi,mSilResmi,mKopyalaResmi;
        int position=0;
        Dersler dersKopya;

        public MyViewHolder(View itemView){
            super(itemView);
            mDersAdı=itemView.findViewById(R.id.ders_Adı);
            mDersNotu=itemView.findViewById(R.id.ders_notu);
            mDersResmi=itemView.findViewById(R.id.ders_resmi);
            mSilResmi=itemView.findViewById(R.id.sil_image);
            mKopyalaResmi=itemView.findViewById(R.id.kopyala_image);

            mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                deleteItem(position);
                }
            });

            mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                addItem(position,dersKopya);
                }
            });


        }

        public void setData(Dersler tiklanılanDers, int i) {
            this.mDersAdı.setText(tiklanılanDers.getAd());
            this.mDersNotu.setText(tiklanılanDers.getNot());
            this.mDersResmi.setImageResource(tiklanılanDers.getImageID());
            this.position=i;
            this.dersKopya=tiklanılanDers;
        }
    }

}
