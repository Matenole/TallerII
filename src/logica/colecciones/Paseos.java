package logica.colecciones;
import java.util.*;
import logica.negocio.paseo;
import logica.valueobject.VOpaseolistado;

public class Paseos {
	
	private TreeMap <String, paseo> AVL_Paseos;
	
	public VOpaseolistado listadoPaseos(String mat) {
		VOpaseolistado vopl = null;;
		return vopl;
	}
	
	public VOpaseolistado listadoPaseosPorDestino(String dest) {
		VOpaseolistado vopl = null;;
		return vopl;
	}
	
	public VOpaseolistado listadoPorDisponibilidad(int cant_Bol) {
		VOpaseolistado vopl = null;;
		return vopl;
	}
	
	public void insert(logica.negocio.paseo p) {
		Iterator<paseo> iter = AVL_Paseos.values().iterator();
		 //while (iter.hasNext()){
		//	 if(iter.next() == null) {
				 AVL_Paseos.values().add(p);
		//	 }
		//	 String elem = iter.next();
		//	 System.out.println (elem);
		 }
	}
	
	public logica.negocio.paseo find(String cod) {
		paseo p = null;
		return p;
	}
	
	public boolean member(String cod) {
		boolean b = false;
		return b;
	}
}