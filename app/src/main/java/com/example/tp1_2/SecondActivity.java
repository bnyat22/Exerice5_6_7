package com.example.tp1_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    TextView nom , prenom , age , skill , numero;
    Button ok , retour;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.second_activity);

    nom = (TextView) findViewById(R.id.nom);
    prenom = (TextView) findViewById(R.id.prenom);
    age = (TextView) findViewById(R.id.age);
    skill = (TextView) findViewById(R.id.skill);
    numero = (TextView) findViewById(R.id.numero);
    ok = (Button) findViewById(R.id.ok);
    retour = (Button) findViewById(R.id.retour);


    nom.setText(getIntent().getStringExtra("nom"));
    prenom.setText(getIntent().getStringExtra("prenom"));
    age.setText(getIntent().getStringExtra("age"));
    skill.setText(getIntent().getStringExtra("skill"));
    numero.setText(getIntent().getStringExtra("numero"));

        final Intent intentOk = new Intent(this,ActivityTrois.class);
        final Intent intentRetour = new Intent(this,MainActivity.class);

    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           startActivity(intentOk);
        }
    });


    retour.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(intentRetour);
        }
    });

    }
}
