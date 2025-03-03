package logica.colecciones;
import java.util.*;
import logica.negocio.boleto;
import logica.negocio.especial;
import logica.valueobject.*;

public class Boletos {
	
	///Atributos
    private ArrayList<boleto> Array_Boletos;
    
    ///Constructor
    public Boletos() {
        Array_Boletos = new ArrayList<>();
    }
    ///Metodos
    public void insert(boleto b) {
        Array_Boletos.add(b); // Agrega un boleto al ArrayList
    }

    public int size() {
        return Array_Boletos.size(); // Devuelve el tamaño del ArrayList
    }

    public boleto kesimo(int x) {
        if (x >= 0 && x <= Array_Boletos.size()) {
            return Array_Boletos.get(x); // Devuelve el boleto en la posición x
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + x);
        }
    }

    public VOboletolistado listadoBoletos(int indice) {
        // Verificar si el índice es válido
        if (indice < 0 || indice >= Array_Boletos.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        // Obtener el boleto en la posición indicada
        boleto bol = Array_Boletos.get(indice);

        // Crear y devolver el VOboletolistado con los datos del boleto
        return new VOboletolistado(
        	bol.getNumero(),
            bol.getNombrepasajero(),
            bol.getEdad(),
            bol.getCelular()
        );
    }
}