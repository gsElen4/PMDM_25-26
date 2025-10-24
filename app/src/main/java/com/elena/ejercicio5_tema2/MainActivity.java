package com.elena.ejercicio5_tema2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher <Intent> launcher;
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
                if (sw.isChecked()) {
                    tv7.setText("Activo");
                } else {
                    tv7.setText("Desactivo");
                }
            }
        });

        /* Al pulsar el botón superior el valor se reinicien los valores de los elementos:
        el toogle button, los checkboxes, los radio button y el switch pasen a estar
        no marcados. El seekbar pase a tener un valor de 0. El rating bar pase a
        tener 0 estrellas seleccionadas y se borre el texto que pueda tener el
        editText.

        Button btn = findViewById(R.id.button);
        //COMPONENTES A DESCONECTAR

        ToggleButton toggleButton1 = findViewById(R.id.toggleButton);

        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);

        RadioGroup radioGroup = findViewById(R.id.radioGroup2);

        Switch sw1 = findViewById(R.id.switch1);

        SeekBar sb = findViewById(R.id.seekBar);

        RatingBar rb = findViewById(R.id.ratingBar);

        EditText et = findViewById(R.id.editTextTextEmailAddress);});
        ImageButton ib = findViewById(R.id.imageButton);

   */
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode()==RESULT_OK){
                    Intent it = o.getData();
                    Toast.makeText(MainActivity.this, ""+it.getIntExtra("valor", -1),Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ImageButton ib = findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent it = new Intent(MainActivity.this, Secundaria.class);
               launcher.launch(it);
                
            }
        });


        //MENU

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tema 2"); //Título
        actionBar.setSubtitle("Ejercicio 5");  //Subtitulo

        //ICONO
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(android.R.drawable.ic_menu_camera); //icono


        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    int id=item.getItemId();
    if (id==R.id.meditar){
        Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
        return true;
    }else if (id==R.id.mborrar){
        Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
        return true;
    }else if (id==R.id.motro){
        Toast.makeText(this, "Otro", Toast.LENGTH_SHORT).show();
        return true;
    };
    return super.onOptionsItemSelected(item);
}




}