package logica.valueobject;

import java.io.Serializable;

public class VOboletoespeciallistado extends VOboletoespecialingreso implements Serializable{
	private int numero;
	///Constructor

	public int getNumero() {
		return numero;
	}
	public VOboletoespeciallistado(int numero,String nombrepasajero, int edad, String celular, float descuento) {
		super(nombrepasajero, edad, celular, descuento);
		this.numero = numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
