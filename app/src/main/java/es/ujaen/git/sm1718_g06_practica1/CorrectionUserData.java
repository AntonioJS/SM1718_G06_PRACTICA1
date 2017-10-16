package es.ujaen.git.sm1718_g06_practica1;

/**
 * Created by usuario on 04/10/2017.
 */
// Aclarar que el nombre de esta clase es ConnectionUserData, pero en clase vi 'r' en vez de 's'.
public class CorrectionUserData extends PersonalData {
    protected String connectionIP="127.0.0.1";
    protected short connectionPort=6000;

    public CorrectionUserData(String usuario,String contraseña, short port, String ip){
        super(usuario, contraseña);
        this.connectionIP=ip;
        this.connectionPort=port;
    }

    // Métodos set u get para la obtención de los parámetros.
    public String getConnectionIP() {
        return connectionIP;
    }

    public void setConnectionIP(String connectionIP) {
        this.connectionIP = connectionIP;
    }

    public short getConnectionPort() {
        return connectionPort;
    }

    public void setConnectionPort(short connectionPort) {
        this.connectionPort = connectionPort;
    }

}
