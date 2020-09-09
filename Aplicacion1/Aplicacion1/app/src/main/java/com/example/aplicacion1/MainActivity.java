package com.example.aplicacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText x1,y1,x2,y2;
    Button pendiente;
    Random r=new Random();
    int RandomNumber= r.nextInt(100);
    int RandomNumber2= r.nextInt(100);
    int RandomNumber3= r.nextInt(100);
    int RandomNumber4= r.nextInt(100);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            x1 = findViewById(R.id.edtx1);
            y1 = findViewById(R.id.edty1);
            x2 = findViewById(R.id.edtx2);
            y2= findViewById(R.id.edty2);
            pendiente = findViewById(R.id.btn_pendiente);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_activity, m);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();


        if(id==R.id.Aleatorio){
            x1.setText(String.valueOf(RandomNumber));
            y1.setText(String.valueOf(RandomNumber2));
            x2.setText(String.valueOf(RandomNumber3));
            y2.setText(String.valueOf(RandomNumber4));
            Toast.makeText(getApplicationContext(),"Aleatorio", Toast.LENGTH_LONG).show();
        }

        if(id==R.id.Distancia){

            double valor_1= Double.parseDouble(x1.getText().toString());
            double valor_2= Double.parseDouble(y1.getText().toString());
            double valor_3= Double.parseDouble(x2.getText().toString());
            double valor_4= Double.parseDouble(y2.getText().toString());

            double dtcia= Math.hypot(valor_1-valor_2,valor_3-valor_4);

            Toast.makeText(getApplicationContext(),"La Distancia es: "+ dtcia, Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {

        double valor_1= Double.parseDouble(x1.getText().toString());
        double valor_2= Double.parseDouble(y1.getText().toString());
        double valor_3= Double.parseDouble(x2.getText().toString());
        double valor_4= Double.parseDouble(y2.getText().toString());

        switch (v.getId()){
            case R.id.btn_pendiente:
                    if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(y1.getText().toString()) ||
                    TextUtils.isEmpty(x2.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Digite todos los datos", Toast.LENGTH_LONG).show();
                    }else{
                        double pendiente=((valor_4-valor_3)/(valor_2-valor_1));
                        Toast.makeText(getApplicationContext(),"La Pendiente es: "+pendiente, Toast.LENGTH_LONG).show();
                    }
                    break;

            case R.id.btn_punto_med:
                if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(y1.getText().toString()) ||
                        TextUtils.isEmpty(x2.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Digite todos los datos", Toast.LENGTH_LONG).show();
                }else{
                    double xm=((valor_2 + valor_1)/2);
                    double ym=((valor_4 + valor_3)/2);
                    Toast.makeText(getApplicationContext(),"El punto medio es:"+"("+xm+" ,"+ym+")", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_cuadrante:

                break;


        }

    }
}