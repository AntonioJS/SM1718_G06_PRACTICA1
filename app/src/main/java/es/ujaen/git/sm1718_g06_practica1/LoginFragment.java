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
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String ip;
    private String port;


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
        args.putString(ARG_PARAM1, ip);
        //Pa parametro entero
        args.putInt(ARG_PARAM2,port);
        fragment.setArguments(args);
        return fragment;
    }
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ip = getArguments().getString(ARG_PARAM1);
            port = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_login, container, false);
//cambiar los edittext6
        Button connect= (Button) fragment.findViewById(R.id.button2_login);
        final EditText usuario= (EditText) fragment.findViewById(R.id.editText6);
        final EditText contraseña= (EditText) fragment.findViewById(R.id.editText6);
        final EditText ip= (EditText) fragment.findViewById(R.id.editText6);
        final EditText port= (EditText) fragment.findViewById(R.id.editText6);

        connect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s_usuario= usuario.getText().toString();
                String s_contraseña= contraseña.getText().toString();
                String s_ip= ip.getText().toString();
                String s_port= port.getText().toString();
                short port2=0;
                    try {
                        port2 = Short.parseShort(s_port);
                    }catch (java.lang.NumberFormatException ex){
                        port2 =6000;
                    }
                CorrectionUserData data=new CorrectionUserData(s_usuario,s_contraseña,port2,s_ip){

                };

                Toast.makeText(getContext(),"hola "+s_usuario+" "+s_contraseña+"",Toast.LENGTH_LONG).show();

                 TareaAutentica tarea = new TareaAutentica();

                 tarea.execute(data);

              Intent nueva=new Intent(getActivity(),ServiceActivity.class);


             nueva.putExtra("param_user",data.getName());
            nueva.putExtra("param_user",data.getSurname());
               nueva.putExtra("param_user",data.getUsuario());
              nueva.putExtra("param_user",data.getContraseña());
                startActivity(nueva);


            }
        });


        return fragment;
    }

}
