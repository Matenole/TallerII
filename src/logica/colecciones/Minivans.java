package logica.colecciones;
import java.util.*;
import logica.negocio.minivan;
import logica.valueobject.VOminivanlistado;
import logica.valueobject.VOpaseolistado;

public class Minivans {
	///Atributos
	private TreeMap <String, minivan> AVL_Minivans;
	///Constructor
	 public Minivans() {
	        AVL_Minivans = new TreeMap<>();
	}
	///Metodos
	 // Método para listar la primera minivan
	    public List<VOminivanlistado> listarMinivan() {
	    	ArrayList<VOminivanlistado> minivans = new ArrayList<VOminivanlistado>();
		    AVL_Minivans.forEach((key,min) ->	{
		    								VOminivanlistado vo = new VOminivanlistado(min.getMatricula(), min.getMarca(), min.getModelo(), min.getCantasientos(), min.getCantidadPaseosAsignados());
		    								minivans.add(vo);
		    								}
		    				  );
		    return minivans;
	    }
	//Metodo para insertar una minivan en el AVL
	public void insert(minivan m) {
		AVL_Minivans.put(m.getMatricula(), m);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public boolean member(String mat) {
        // Verificar si el TreeMap es nulo o está vacío
        if (AVL_Minivans == null || AVL_Minivans.isEmpty()) {
            return false;
        }
        // Verificar si la matrícula existe en el TreeMap
        return AVL_Minivans.containsKey(mat);
    }
    // Método para buscar una minivan por matrícula
    public minivan find(String mat) {
        // Verificar si el TreeMap está vacío
        if (AVL_Minivans == null || AVL_Minivans.isEmpty()) {
            throw new IllegalStateException("El TreeMap está vacío");
        }
        // Verificar si la matrícula existe en el TreeMap
        if (!(member(mat))) {
            throw new NoSuchElementException("La minivan con matrícula " + mat + " no existe");
        }
        // Obtener la minivan asociada a la matrícula
        return AVL_Minivans.get(mat);
    }
	
}