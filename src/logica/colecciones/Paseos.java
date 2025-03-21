package logica.colecciones;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;
import logica.negocio.paseo;
import logica.valueobject.VOpaseolistado;

public class Paseos implements Serializable{
	
	private TreeMap <String, paseo> AVL_Paseos;
	public Paseos() {
        AVL_Paseos = new TreeMap<>();
    }
	public void insert(paseo p) {
		AVL_Paseos.put(p.getCodigo(),p);
	}
	public ArrayList<VOpaseolistado> listadoPaseos() {										
		ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(), pas.getMaxboletos(), pas.cantBoletosDisponibles());
	    								recorrido.add(vo);
	    								}
	    				  );
	    return recorrido;
	}
	public ArrayList<VOpaseolistado> listadoPaseosPorDestino(String dest) {				
		ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								if (pas.getDestino().equals(dest)) {
	    									VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(), pas.getMaxboletos(), pas.cantBoletosDisponibles());
	    									recorrido.add(vo);
	    									}
	    								}
	    				  );
	    return recorrido;
	}

    public ArrayList<VOpaseolistado> listadoPorDisponibilidad(int cant_Bol) {
    	ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								if (pas.getMaxboletos() >= cant_Bol) {
	    									VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(), pas.getMaxboletos(), pas.cantBoletosDisponibles());
	    									recorrido.add(vo);
	    									}
	    								}
	    				  );
	    return recorrido;
    }

    public String keyfinder() {
    	return AVL_Paseos.firstKey();
    }
	public boolean member(String cod) {
        return AVL_Paseos.containsKey(cod);	
        }
	
	public paseo find(String cod) {
		if(!member(cod))
			throw new NoSuchElementException("El paseo con codigo " + cod + " no existe");
		return AVL_Paseos.get(cod);
	}
	
	public int largo() {
		return AVL_Paseos.size();
	}
	
	public boolean chequearHorarios(LocalTime HP,LocalTime HL) {
		boolean bool = true;
		
		paseo aux = null;
		Iterator <paseo> iter = AVL_Paseos.values().iterator();
    	while(iter.hasNext() && bool) {
    		aux = iter.next();
    		if(!(HP.isAfter(aux.getHorallegada()) || HL.isBefore(aux.getHorasalida()))) {
    			bool = false;
    		}
    	}
		
		return bool;
	}
}