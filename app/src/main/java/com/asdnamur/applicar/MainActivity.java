package com.asdnamur.applicar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* final CheckBox checkBox = (CheckBox) findViewById(R.id.CheckBox1);          CODE JAVA POUR COCHER CHECKBOX --> XML HANDLE THIS

        if (checkBox.isChecked() ) {
            checkBox.setChecked(true);
        } */

        final EditText adressEdit = (EditText)findViewById( R.id.adressEdit);
        CheckBox CheckBox1 = (CheckBox) findViewById( R.id.CheckBox1);                // CODE JAVA POUR QUE LA CHECKBOX ACTIVE/DESACTIVE LES TEXTVIEW & EDITTEXT
        final TextView adresse = (TextView)  findViewById( R.id.adresse);
        CheckBox1.setOnCheckedChangeListener(new OnCheckedChangeListener()

        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    adressEdit.setEnabled(false);
                    adresse.setEnabled(false);
                }
                else{
                    adressEdit.setEnabled(true);
                    adresse.setEnabled(true);
                }
            }
        });




    }



}
