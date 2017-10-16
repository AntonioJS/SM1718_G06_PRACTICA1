package es.ujaen.git.sm1718_g06_practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity{

    public static final String PARAM_USUARIO= "param_usuario";
        public static final String PARAM_CONTRASEÑA= "param_contraseña";
        public static final String PARAM_IP= "param_ip";
        public static final String PARAM_PORT= "param_port";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        String usuario = getIntent().getStringExtra(PARAM_USUARIO);
        String contraseña= getIntent().getStringExtra( PARAM_CONTRASEÑA);
        String ip= getIntent().getStringExtra(PARAM_IP);
        short port= getIntent().getShortExtra(PARAM_PORT,(short)6000);


        TextView title= (TextView) findViewById(R.id.textView);
        title.setText("Hola " +usuario);
    }
}
