package logica.colecciones;
import java.util.*;
import logica.negocio.minivan;
import logica.valueobject.VOminivan;

public class Minivans {
	
	private TreeMap <String, minivan> AVL_Minivans;
	//Constructor
	 public Minivans() {
	        AVL_Minivans = new TreeMap<>();
	}

	///Metodos
	 // Método para listar la primera minivan
	    public VOminivan listarMinivan(Minivans a) {
	        // Verificar si el TreeMap está vacío
	        if (a.AVL_Minivans == null || a.AVL_Minivans.isEmpty()) {
	            throw new IllegalStateException("El TreeMap está vacío");
	        }

	        // Obtener la primera entrada del TreeMap (la de menor clave)
	        String primeraMatricula = a.AVL_Minivans.firstKey();
	        minivan primeraMinivan = a.AVL_Minivans.get(primeraMatricula);

	        // Crear y devolver el VOminivan con los datos de la primera minivan
	        return new VOminivan(
	            primeraMinivan.getMatricula(),
	            primeraMinivan.getMarca(),
	            primeraMinivan.getModelo(),
	            primeraMinivan.getCantasientos()
	        );
	    }
	//Metodo para insertar una minivan en el AVL
	public void insert(minivan m,Minivans a) {
		a.AVL_Minivans.put(m.getMatricula(), m);
	}
	
	 // Método para buscar una minivan por matrícula
    public minivan find(String mat, Minivans a) {
        // Verificar si el TreeMap está vacío
        if (a.AVL_Minivans == null || a.AVL_Minivans.isEmpty()) {
            throw new IllegalStateException("El TreeMap está vacío");
        }
        // Verificar si la matrícula existe en el TreeMap
        if (!a.member(mat, a)) {
            throw new NoSuchElementException("La minivan con matrícula " + mat + " no existe");
        }
        // Obtener la minivan asociada a la matrícula
        return a.AVL_Minivans.get(mat);
    }
	
    public boolean member(String mat, Minivans a) {
        // Verificar si el TreeMap es nulo o está vacío
        if (a.AVL_Minivans == null || a.AVL_Minivans.isEmpty()) {
            return false;
        }
        // Verificar si la matrícula existe en el TreeMap
        return a.AVL_Minivans.containsKey(mat);
    }
}