package com.example.tp1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout nom, prenom, age, skill, numero;
    Button button , call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (TextInputLayout) findViewById(R.id.nom);
        prenom = (TextInputLayout) findViewById(R.id.prenom);
        age = (TextInputLayout) findViewById(R.id.age);
        skill = (TextInputLayout) findViewById(R.id.skill);
        numero = (TextInputLayout) findViewById(R.id.numero);
        button = (Button) findViewById(R.id.button) ;
        call = (Button) findViewById(R.id.call);


        final Intent intent = new Intent(this,SecondActivity.class);
        final Intent callIntent = new Intent(this,TelephoneActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nomValidate(nom)
                        && prenomValidate(prenom)
                        && ageValidate(age)
                        &&  skillValidate(skill)
                        && numeroValidate(numero)) {

               intent.putExtra("nom" , nom.getEditText().getText().toString());
                    intent.putExtra("prenom" , prenom.getEditText().getText().toString());
                    intent.putExtra("age" , age.getEditText().getText().toString());
                    intent.putExtra("skill" , skill.getEditText().getText().toString());
                    intent.putExtra("numero" , numero.getEditText().getText().toString());
                    startActivity(intent);
                }
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(callIntent);
            }
        });

    }

    private boolean nomValidate(TextInputLayout nom) {

        String name =nom.getEditText().getText().toString();
        if (name.isEmpty()) {
            nom.setError("Il faut remplir le nom");
            return false;
        } else {
            nom.setError(null);
            nom.setErrorEnabled(false);
            return true;
        }
    }

    private boolean prenomValidate(TextInputLayout prenom) {

        String firstName = prenom.getEditText().getText().toString();
        if (firstName.isEmpty()) {
            prenom.setError("Il faut remplir le prenom");
            return false;
        } else {
            prenom.setError(null);
            prenom.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ageValidate(TextInputLayout age) {

        String agee = age.getEditText().getText().toString();

        if (agee.isEmpty()) {
            age.setError("Il faut remplir l'age");
            return false;
        } else if (!agee.matches("\\d+(?:\\.\\d+)?"))
        {
            age.setError("il faut pas remplir les textes ici");
            return false;
        }
        else
        {
            age.setError(null);
            age.setErrorEnabled(false);
            return true;
        }
    }
    private boolean numeroValidate(TextInputLayout numero) {

        String number = numero.getEditText().getText().toString();

        if (number.isEmpty()) {
            numero.setError("Il faut remplir le numero");
            return false;
        } else if (!number.matches("\\d+(?:\\.\\d+)?"))
        {
            numero.setError("il faut pas remplir les textes ici");
            return false;
        }
        else
        {
            numero.setError(null);
            numero.setErrorEnabled(false);
            return true;
        }
    }
    private boolean skillValidate(TextInputLayout skill) {

        String competence = skill.getEditText().getText().toString();
        if (competence.isEmpty()) {
            skill.setError("Il faut remplir le competence");
            return false;
        } else {
            skill.setError(null);
            skill.setErrorEnabled(false);
            return true;
        }
    }
}
