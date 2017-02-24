package com.asdnamur.applicar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //variables
    boolean carplace;
    boolean keyplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* final CheckBox checkBox = (CheckBox) findViewById(R.id.CheckBox1);          POUR COCHER CHECKBOX --> XML HANDLE THIS

        if (checkBox.isChecked() ) {
            checkBox.setChecked(true);
        } */

        final EditText adressEdit = (EditText) findViewById(R.id.adressEdit);
        CheckBox CheckBox1 = (CheckBox) findViewById(R.id.CheckBox1);                // POUR QUE LA CHECKBOX ACTIVE/DESACTIVE LES TEXTVIEW & EDITTEXT
        final TextView adresse = (TextView) findViewById(R.id.adresse);
        CheckBox1.setOnCheckedChangeListener(new OnCheckedChangeListener()

        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    adressEdit.setEnabled(false);
                    adresse.setEnabled(false);
                } else {
                    adressEdit.setEnabled(true);
                    adresse.setEnabled(true);
                }
            }
        });
    }

    // Méthode d'envoi de mail
    public void onClick(View v) {

        // Instance des items présents dans le XML
        EditText plaque = (EditText) findViewById(R.id.plaqueEdit);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.CheckBox1);
        EditText adressEdit = (EditText) findViewById(R.id.adressEdit);
        EditText date1 = (EditText) findViewById(R.id.date_edit_1);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner2);
        EditText date2 = (EditText) findViewById(R.id.date_edit_2);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner1);
        EditText date3 = (EditText) findViewById(R.id.date_edit_3);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spin4 = (Spinner) findViewById(R.id.spinner);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        EditText remarque = (EditText) findViewById(R.id.remarque_edit);

        // Interprétation et conditions des CheckBoxes
        carplace = checkBox1.isChecked();
        StringBuilder testoMail = new StringBuilder();
        if (carplace) {
            testoMail.append("Voiture au domicile");
        } else {
            testoMail.append("Adresse où se trouvera la voiture : ");
        }

        keyplace = checkBox2.isChecked();
        StringBuilder testoMail2 = new StringBuilder();
        if (keyplace) {
            testoMail2.append("Le double de clé se trouve au centre.");
        } else {
            testoMail2.append("Le double de clé se trouve au domicile.");
        }

        // Items to String()
        String domicile = testoMail.toString();
        String body1 = plaque.getText().toString();
        String body2 = adressEdit.getText().toString();
        String dateA = date1.getText().toString();
        String dayA = spin1.getSelectedItem().toString();
        String dateB = date2.getText().toString();
        String dayB = spin2.getSelectedItem().toString();
        String dateC = date3.getText().toString();
        String dayC = spin3.getSelectedItem().toString();
        String typeIntervention = spin4.getSelectedItem().toString();
        String doubleClé = testoMail2.toString();
        String remarques = remarque.getText().toString();

        // Préparation de l'email avec intent + mise en forme sommaire
        Intent i = new Intent(Intent.ACTION_SEND);
        // i.setType("text/plain");
        i.setType("message/rfc822");
        i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"informatique@asd-namur.be"});
        i.putExtra(Intent.EXTRA_SUBJECT, "AppliCar - Demande [" + typeIntervention + "] pour " + body1);
        i.putExtra(android.content.Intent.EXTRA_TEXT, "Demande d'intervention d'un chauffeur-logisticien"

                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Type d'intervention : " + typeIntervention
                + System.getProperty("line.separator")
                + "Plaque : " + body1
                + System.getProperty("line.separator")
                + domicile + body2
                + System.getProperty("line.separator")
                + doubleClé
                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Dates de disponibilités :"
                + System.getProperty("line.separator")
                + dateA + " " + dayA
                + System.getProperty("line.separator")
                + dateB + " " + dayB
                + System.getProperty("line.separator")
                + dateC + " " + dayC
                + System.getProperty("line.separator")
                + System.getProperty("line.separator")
                + "Remarques : "
                + System.getProperty("line.separator")
                + remarques
        );

        startActivity(Intent.createChooser(i, "Choisissez l'application pour envoyer la demande"));

    }


}
