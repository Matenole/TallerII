package logica.colecciones;
import java.util.*;
import logica.negocio.boleto;
import logica.valueobject.VOboletolistado;

public class Boletos {
	
	private ArrayList<boleto> Array_Boletos;
	
	public void insert(boleto b) {
		
	}
	
	public int size(int tam) {
		return tam;
	}
	
	public boleto kesimo(int x) {
		boleto b = new boleto(x, null, x, null);
		return b;
	}
	
	public VOboletolistado listadoBoletos() {
		VOboletolistado vobl = new VOboletolistado(null, 0, null, 0, 0);
		return vobl;
	}
}