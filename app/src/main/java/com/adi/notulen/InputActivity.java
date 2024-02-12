package com.adi.notulen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {

    EditText nama,judul,waktu;
    Button simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        nama = findViewById(R.id.nama);
        judul = findViewById(R.id.judul);
        waktu = findViewById(R.id.waktu);

        simpan = findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = nama.getText().toString();
                String getJudul = judul.getText().toString();
                String getWaktu = waktu.getText().toString();


                if(getNama.isEmpty()){
                    nama.setError("Masukkkan nama anda");
                }else if(getJudul.isEmpty()){
                    judul.setError("Masukkan Judul");
                }else if(getWaktu.isEmpty()){
                    waktu.setError("Masukkan Waktunya");
                }else{
                    database.child("list").push().setValue(new ModelData(getNama, getJudul, getWaktu)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(InputActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(InputActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputActivity.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });



    }
}

