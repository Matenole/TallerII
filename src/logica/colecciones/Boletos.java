package logica.colecciones;
import java.util.*;
import logica.negocio.boleto;
import logica.valueobject.VOboletolistado;

public class Boletos {
    private ArrayList<boleto> Array_Boletos;

    public Boletos() {
        Array_Boletos = new ArrayList<>();
    }

    public void insert(boleto b) {
        Array_Boletos.add(b); // Agrega un boleto al ArrayList
    }

    public int size() {
        return Array_Boletos.size(); // Devuelve el tamaño del ArrayList
    }

    public boleto kesimo(int x) {
        if (x >= 0 && x < Array_Boletos.size()) {
            return Array_Boletos.get(x); // Devuelve el boleto en la posición x
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + x);
        }
    }

    public VOboletolistado listadoBoletos() {
        VOboletolistado vobl = new VOboletolistado(null, 0, null, 0, 0);
        return vobl;
    }
}