package logica.colecciones;
import java.io.Serializable;
import java.util.*;
import logica.negocio.boleto;
import logica.negocio.especial;
import logica.valueobject.*;

public class Boletos implements Serializable{
	
	///Atributos
    private ArrayList<boleto> Array_Boletos;
    
    ///Constructor
    public Boletos() {
        Array_Boletos = new ArrayList<>();
    }
    ///Metodos
    public void insert(boleto b) {
        Array_Boletos.add(b);
    }

    public int size() {
        return Array_Boletos.size();
    }

    public boleto kesimo(int x) {
        if (x >= 0 && x <= Array_Boletos.size()) {
            return Array_Boletos.get(x);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + x);
        }
    }
}