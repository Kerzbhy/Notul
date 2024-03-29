package com.adi.notulen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton tambah;
    AdapterList adapterlist;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelData> listdata;
    RecyclerView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);

            }
        });

        card = findViewById(R.id.recyler);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        card.setLayoutManager(mLayout);
        card.setItemAnimator(new DefaultItemAnimator());

        tampilData();


    }

    private void tampilData() {
        database.child("list").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listdata = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    ModelData mdl = item.getValue(ModelData.class);
                    mdl.setKey(item.getKey());
                    listdata.add(mdl);
                }
                adapterlist = new AdapterList(listdata,MainActivity.this);
                card.setAdapter(adapterlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}