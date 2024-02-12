package com.adi.notulen;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {

    private  List<ModelData> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();


    public AdapterList(List<ModelData>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public AdapterList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_file, parent, false);

        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.MyViewHolder holder, int position) {
        final ModelData data = mList.get(position);
        holder.nama.setText(data.getNama());
        holder.judul.setText("Judul  " + data.getJudul());
        holder.waktu.setText("Waktu  " + data.getWaktu());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama,judul,waktu;
        CardView card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            judul = itemView.findViewById(R.id.judul);
            waktu = itemView.findViewById(R.id.waktu);
            card = itemView.findViewById(R.id.card_list);
        }
    }
}

