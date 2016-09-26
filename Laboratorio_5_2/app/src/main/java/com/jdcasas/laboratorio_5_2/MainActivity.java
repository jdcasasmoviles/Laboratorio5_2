package com.jdcasas.laboratorio_5_2;
/**
 * Created by Usuario on 25/09/2016.
 */
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Button btnVolver, btnSalvar;
    private Button imageButton;
    private RadioButton RadioButton1, RadioButton2;
    private EditText editText1;
    private CheckBox CheckBox1;
    private ToggleButton ToggleButton1;
    private RatingBar RatingBar1;
    private TextView TextView1, TextView2, TextView3, TextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews(){
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        imageButton = (Button) findViewById(R.id.imageButton);
        TextView1 = (TextView) findViewById(R.id.textView0);
        TextView2 = (TextView) findViewById(R.id.textView);
        TextView3 = (TextView) findViewById(R.id.textView2);
        TextView4 = (TextView) findViewById(R.id.textView3);

        editText1 = (EditText) findViewById(R.id.editText);
        CheckBox1 = (CheckBox) findViewById(R.id.checkBox);
        RadioButton1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        ToggleButton1 = (ToggleButton) findViewById(R.id.toggleButton);
        RatingBar1 = (RatingBar) findViewById(R.id.ratingBar);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void sendClick(View v) {
        // Perform action on clicks
        String allText = new String("campo:" + editText1.getText());
        allText = allText + ":checkbox:";
        if (CheckBox1.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + ":toggle:";
        if (CheckBox1.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + "radios:rojo:";
        String redtext = "";
        if (RadioButton1.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }

        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (RadioButton2.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }
        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = RatingBar1.getRating();
        allText = allText + Float.toString( f ) + ":";

        Log.d("app", allText);
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show();
    }

    public void checkBoxClick(View v) {
        String text = "";
        if (CheckBox1.isChecked()) {
            text = "Selected";
            btnSalvar.setEnabled(true);
            Toast.makeText(this,"Ya puedes Salvar",
                    Toast.LENGTH_LONG).show();
        } else {
            btnSalvar.setEnabled(false);
            Toast.makeText(this, "Hasta que no marques la casilla no podrás salvar",Toast.LENGTH_LONG).show();
            text = "Not selected";
        }
        Toast.makeText(this,text,
                Toast.LENGTH_SHORT).show();
    }

    public void radioClick(View v){
        if(RadioButton1.isChecked()){
            Toast toast=Toast.makeText(this, "Red activado", Toast.LENGTH_SHORT);
            TextView textv=(TextView)toast.getView().findViewById(android.R.id.message);
            textv.setTextColor(Color.CYAN);
            toast.getView().setBackgroundColor(Color.RED);
            toast.show();
        }
        if(RadioButton2.isChecked()){
            Toast toast=Toast.makeText(this, "Blue activado", Toast.LENGTH_SHORT);
            TextView textv=(TextView)toast.getView().findViewById(android.R.id.message);
            textv.setTextColor(Color.CYAN);
            toast.getView().setBackgroundColor(Color.BLUE);
            toast.show();
        }
    }

    public void toggleClick(View v){
        Toast.makeText(this, ToggleButton1.getText(), Toast.LENGTH_SHORT).show();
    }

    public void seccion12(View v) {

        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
        finish();
    }

}