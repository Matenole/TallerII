package logica.valueobject;

import java.io.Serializable;

public class VOboletoespeciallistado extends VOboletoespecialingreso implements Serializable{
	///Constructor
	public VOboletoespeciallistado(int numero, String nombrepasajero, int edad, String celular, float descuento) {
		super(numero, nombrepasajero, edad, celular, descuento);
	}
}
