package es.ujaen.git.sm1718_g06_practica1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    String datosvolatiles = "Hola";
    //se declara como atributo de la clase para reutilizarlo.
    TextView volatil=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView volatil = (TextView) findViewById(R.id.volatil);
        volatil.setText(datosvolatiles);

        if(savedInstanceState!=null){
           datosvolatiles=savedInstanceState.getString("volatil",datosvolatiles);
        }



    }

    //estos parametros siempre son los mismo, punto ultimo de la practoica
    public void onIcon(View visita){

        datosvolatiles.toUpperCase();
        volatil.setText(datosvolatiles);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("volatil",datosvolatiles);
    }

    //esto pertenece a la p2

    public class TareaAutentica extends AsyncTask<CorrectionUserData,Void,String>{

        public String doInBackground(CorrectionUserData... param){
            //los ... significan que param pueden ser uno o varios parametros
            return null;
        }

        /**
         *
         * @param result Ok si la operacion fue correcta y si no otro valor
         *
         */
        public void onPostExecute(String result) {

            if (result.compareToIgnoreCase("OK") == 0) {
                Intent nueva = new Intent(MainActivity.this, ServiceActivity.class);


                nueva.putExtra(ServiceActivity.PARAM_USER,data.getUsuario());
                nueva.putExtra("param_port", data.getSurname());
               // nueva.putExtra("param_user", data.get());
                nueva.putExtra("param_user", data.getConnectionPort());

                startActivity(nueva);
            } else
            {


            }
        }

    }
}
