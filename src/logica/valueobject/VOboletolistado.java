package logica.valueobject;

import java.io.Serializable;

public class VOboletolistado extends VOboletoingreso implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		///Atributos
		private int numero;
		
		///Constructor
		public VOboletolistado(int numero, String nombrepasajero, int edad, String celular) {
			super(nombrepasajero, edad, celular);
			this.numero = numero;
		}
		///Getters y Setters
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}	
}
