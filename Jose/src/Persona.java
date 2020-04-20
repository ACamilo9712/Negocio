public class Persona {

    private int edad;
    private String Sexo;
    private double estatura;
    private String nombre;

    public Persona (int edad, String sexo, double estatura, String nombre){
        this.edad = edad;
        this.Sexo =sexo;
        this.estatura=estatura;
        this.nombre= nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
