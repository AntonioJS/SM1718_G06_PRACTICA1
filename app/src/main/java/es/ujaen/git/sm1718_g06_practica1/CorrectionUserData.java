package es.ujaen.git.sm1718_g06_practica1;

/**
 * Created by usuario on 04/10/2017.
 */
//Realmente era connection, pero se me fue la r
public class CorrectionUserData extends PersonalData {
    protected String connectionIP="127.0.0.1";
    protected short connectionPort=6000;

    public CorrectionUserData(String usuario,String contraseña, short port, String ip){
        super(usuario, contraseña);
        this.connectionIP=ip;
        this.connectionPort=port;
    }

}
