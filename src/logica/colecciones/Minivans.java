package logica.colecciones;
import java.util.*;
import java.util.function.Consumer;
import logica.excepciones.LogicaException;
import logica.negocio.minivan;
import logica.negocio.paseo;
import logica.valueobject.VOminivanlistado;
import logica.valueobject.VOpaseolistado;

public class Minivans {
	///Atributos
	private TreeMap <String, minivan> AVL_Minivans;
	private Consumer<? super VOpaseolistado> key;
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
	public void insert(minivan m) throws LogicaException {
		if(m.getMatricula().matches("[a-zA-Z0-9]+")) {
			AVL_Minivans.put(m.getMatricula(), m);
		}
		else {
			throw new LogicaException("La matricula ingresada no es Alfanumerica");
		}
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
        // Verificar si la matrícula existe en el TreeMap
        if (!(member(mat))) {
            throw new NoSuchElementException("La minivan con matrícula " + mat + " no existe");
        }
        else
        return AVL_Minivans.get(mat);
    }
    public boolean esta_asignado(String cod) {
    	minivan m = AVL_Minivans.get(0);
    	Paseos po = m.getDicPaseos();
    	if(po.member(cod))
    		return true;
    	else
    		return false;
    }
    public ArrayList<VOpaseolistado> listadoporasignacionpaseos(String mat){
    	minivan m = AVL_Minivans.get(mat);
    	Paseos po = m.getDicPaseos();
    	paseo p = po.find(mat);
    	ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
		if(esta_asignado(p.getCodigo()))
    		
    		 recorrido.forEach(key);	{
					VOpaseolistado vo = new VOpaseolistado(p.getCodigo(),p.getDestino(),p.getHorasalida(),p.getHorallegada(),p.getPrecio(),p.getMaxboletos(),p.montoRecaudado());
					recorrido.add(vo);
					}
    		 return recorrido;
    }
}