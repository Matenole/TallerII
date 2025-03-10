package logica.valueobject;

import java.io.Serializable;

public class VOboletoespecialingreso extends VOboletoingreso implements Serializable{
	///Atributos
	private float Descuento;
	///Constructor
	public VOboletoespecialingreso(String nombrepasajero, int edad, String celular, float descuento2) {
		super(nombrepasajero, edad, celular);
		Descuento = descuento2;
	}

	///Getters y Setters
	public float getDescuento() {
		return Descuento;
	}

	public void setDescuento(float descuento) {
		Descuento = descuento;
	}


}
