package com.elena.ejercicio5_tema2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Haz que al activar el toogle button uno de los checkboxes se desactive
        //y al desactivar el toogle button el checkbox se vuelva a activar
        CheckBox checkBox = findViewById(R.id.checkBox2);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                checkBox.setChecked(!isChecked);
            }
        });

        //Al desplazar la seekBar se muestre su valor en el campo de texto adyacente.

        //Al activar el botón switch se muestre en una etiqueta, el texto activo y al
        //desactivarlo de desactivo.

                Switch sw = findViewById(R.id.switch1);
                TextView tv7;
                tv7 = findViewById(R.id.textView7);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                        if(sw.isChecked()) {
                            tv7.setText("Activo");
                        }else {
                            tv7.setText("Desactivo");
                        }
                    }
                });

        /* Al pulsar el botón superior el valor se reinicien los valores de los elementos:
        el toogle button, los checkboxes, los radio button y el switch pasen a estar
        no marcados. El seekbar pase a tener un valor de 0. El rating bar pase a
        tener 0 estrellas seleccionadas y se borre el texto que pueda tener el
        editText.*/

        Button btn = findViewById(R.id.button);



        }
    }
