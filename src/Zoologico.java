import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Zoologico {
    private List<Animal> animales;
    private Map<String, Integer> conteoPorTipo;

    // Constructor de Zoologico
    public Zoologico() {
        animales = new ArrayList<>();
        conteoPorTipo = new HashMap<>();
    }

    // Método para agregar un animal y actualizar el conteo por tipo
    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        String tipo = animal.getClass().getSimpleName();
        conteoPorTipo.put(tipo, conteoPorTipo.getOrDefault(tipo, 0) + 1);
    }

    // Método para mostrar los sonidos de todos los animales
    public void mostrarSonidos() {
        for (Animal animal : animales) {
            System.out.print(animal.getNombre() + ": ");
            animal.hacerSonido();
        }
    }

    // Método para mostrar el conteo de animales por tipo
    public void mostrarConteoPorTipo() {
        System.out.println("Conteo de animales por tipo:");
        for (Map.Entry<String, Integer> entry : conteoPorTipo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Método para guardar la lista de animales en un archivo binario
    public void guardarAnimales(String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(animales);
            System.out.println("Lista de animales guardada en " + archivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los animales: " + e.getMessage());
        }
    }

    // Método para cargar la lista de animales desde un archivo binario
    public void cargarAnimales(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            animales = (List<Animal>) in.readObject();
            System.out.println("Lista de animales cargada desde " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los animales: " + e.getMessage());
        }
    }

    // Getter para obtener la lista de animales
    public List<Animal> getAnimales() {
        return animales;
    }
}
