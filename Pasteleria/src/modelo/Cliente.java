package modelo;

public class Cliente {

    private String dni;

    private String nombre;

    public Cliente() {
        this.dni = "";
        this.nombre = "";
    }
    
    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void estado() {
        System.out.println("DNI: " + this.dni + ", Nombre: " + this.nombre);
    }
}