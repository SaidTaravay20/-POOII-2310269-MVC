package models;

public class Invitado {
    private String nombre;
    private String correo;

    public Invitado(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + ";" + correo;
    }
}
