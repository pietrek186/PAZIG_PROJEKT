package com.example.aplikacjapomiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pomiary extends AppCompatActivity {

    EditText ciśnienie;
    EditText puls;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;


    void init (){
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomiary);

        init();

        Button wstecz_button = findViewById(R.id.wstecz_button);
        ciśnienie = findViewById(R.id.ciśnienie);
        puls = findViewById(R.id.puls);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        Button zatwierdz = (Button) findViewById(R.id.zatwierdz);
        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {pomiarCisnieniaIPulsu();}

        });



        wstecz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pomiary.this, MainActivity.class);
                        startActivity(intent);
            }
        });
    }

    public void pomiarCisnieniaIPulsu(){
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        String cis = ciśnienie.getText().toString();
        String pul = puls.getText().toString();
        addDataToFirebase(currentDate, currentTime, cis, pul);
    }

    private void addDataToFirebase(String data, String godzina, String ciśnienie, String puls){
        PomiaryBD pomiaryBD = new PomiaryBD();
        String dane = ciśnienie + "," + puls;
        pomiaryBD.setData(dane);
        databaseReference.child(data + godzina).setValue(pomiaryBD);
        Toast.makeText(Pomiary.this, "Dodano dane", Toast.LENGTH_SHORT).show();

    }
}
