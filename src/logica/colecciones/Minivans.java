package logica.colecciones;
import java.util.*;
import logica.negocio.minivan;
import logica.negocio.paseo;
import logica.valueobject.VOminivan;

public class Minivans {
	
	private TreeMap <String, minivan> AVL_Minivans;
	
	public VOminivan listarMinivan() {
		VOminivan vom = new VOminivan(null, null, null, 0);
		return vom;
	}
	
	public void insert(logica.negocio.paseo p) {
		
	}
	
	public logica.negocio.paseo find(String mat) {
		paseo p = null;
		return p;
	}
	
	public boolean member(String mat) {
		boolean b = false;
		return b;
	}
}