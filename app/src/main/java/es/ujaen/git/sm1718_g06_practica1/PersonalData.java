package es.ujaen.git.sm1718_g06_practica1;

/**
 * Created by usuario on 04/10/2017.
 */

public class PersonalData {
    protected String name="";
    protected String surname="";

    protected String usuario="";
    protected String contraseña="";

    //hara falta un constructor por defecto
    public PersonalData(String usuario,String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;

    }

    public PersonalData(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
