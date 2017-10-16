package es.ujaen.git.sm1718_g06_practica1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    //Creación de los datos volatiles.
    String datosvolatiles = "Hola";
    //Se declara como atributo de la clase para reutilizarlo.
    TextView volatil = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            datosvolatiles = savedInstanceState.getString("volatil", datosvolatiles);
        }
        volatil = (TextView) findViewById(R.id.volatil);
        volatil.setText(datosvolatiles);


    }

    //Estos parametros de la vista volátil siempre son los mismos, punto ultimo de la práctica.
    public void onIcon(View vista) {

        datosvolatiles.toUpperCase();
        volatil.setText(datosvolatiles);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("volatil", datosvolatiles);
    }
}
