package es.ujaen.git.sm1718_g06_practica1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    //Pondremos como parámetro 1 la dirección IP y como parámetro 2 el puerto.
    private static final String ARG_PARAM1 = "param_ip";
    private static final String ARG_PARAM2 = "param_port";

    // TODO: Rename and change types of parameters
    private String ip;
    private int port;


    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param ip Parameter 1.
     * @param port Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String ip, int port) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        // args.putString se utiliza para los parametros que son cadenas.
        args.putString(ARG_PARAM1,ip);
        //args.putInt se utiliza para los parámetros que son enteros.
        args.putInt(ARG_PARAM2,port);
        fragment.setArguments(args);
        return fragment;
    }
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ip = getArguments().getString(ARG_PARAM1);
            port = getArguments().getInt(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_login, container, false);
        //Situamos nuestros diferentes 'editText' según el parámetro al que hagan referencia.

        Button connect= (Button) fragment.findViewById(R.id.button2_login);
        //R.id es un identificador de TextView.
        //Con él referenciamos en el código el campo usuario con su campo de texto correspondiente, que
        //en nuestro caso es editText6.
        final EditText usuario = (EditText) fragment.findViewById(R.id.editText6);
        //Ocurre igual en los demás casos.
        final EditText contraseña = (EditText) fragment.findViewById(R.id.editText);
        final EditText ip = (EditText) fragment.findViewById(R.id.editText7);
        final EditText port = (EditText) fragment.findViewById(R.id.editText8);

        connect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s_usuario= usuario.getText().toString();
                String s_contraseña= contraseña.getText().toString();
                String s_ip= ip.getText().toString();
                String s_port= port.getText().toString();
                short port2 = 0;
                    try {
                        port2 = Short.parseShort(s_port);
                    }catch (java.lang.NumberFormatException ex){
                        port2 =6000;
                    }
                    //A pesar del error al llamarla, la clase 'ConnectionUserData' está bien nombrada para
                //cuando se llama.
                CorrectionUserData data=new CorrectionUserData(
                        s_usuario,s_contraseña,port2,s_ip
                );

                Toast.makeText(getContext(),"Hola" +s_usuario+ " " +s_contraseña+ " " + s_ip + " " +s_port ,Toast.LENGTH_LONG).show();


            }
        });


        return fragment;
    }

}
