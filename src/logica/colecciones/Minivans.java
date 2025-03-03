package logica.colecciones;
import java.util.*;
import logica.excepciones.RegistroException;
import logica.negocio.minivan;
import logica.negocio.paseo;
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
	    public ArrayList<VOpaseolistado> listadoporasignacionpaseos(String mat,String cod){
	    	minivan m = AVL_Minivans.get(mat);
	    	Paseos po = m.getDicPaseos();
	    	paseo p = po.find(cod);
	    	return po.listadoPaseos();
	    		 
	    }
	//Metodo para insertar una minivan en el AVL
	public void insert(minivan m) throws RegistroException {
		if(m.getMatricula().matches("[a-zA-Z0-9]+")) {
			AVL_Minivans.put(m.getMatricula(), m);
		}
		else {
			throw new RegistroException("La matricula ingresada no es Alfanumerica");
		}
	}
    public boolean member(String mat) {
      if(AVL_Minivans.containsKey(mat))
    	  return true;
      else 
    	  return false;
    }
    // Método para buscar una minivan por matrícula
    public minivan find(String mat) {
        // Verificar si la matrícula existe en el TreeMap
        if (!(member(mat))) {
            throw new NoSuchElementException("La minivan con matrícula " + mat + " no existe");
        }
        else
        return AVL_Minivans.get(mat);
    }
}