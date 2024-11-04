import java.io.Serializable;

abstract class Animal implements Serializable {
    private String nombre;
    private int edad;

    // Constructor de Animal
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método abstracto hacerSonido
    public abstract void hacerSonido();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método que devuelve el nombre en mayúsculas
    public String getNombreEnMayusculas() {
        return nombre.toUpperCase();
    }
}


