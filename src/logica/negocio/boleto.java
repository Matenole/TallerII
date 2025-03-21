package logica.negocio;

import java.io.Serializable;

import logica.excepciones.DescuentoException;

public class boleto implements Serializable{

	private static final long serialVersionUID = 1L;
		///Atributos
		private int numero;
		private String nombrepasajero;
		private int edad;
		private String celular;
		
		///Constructor
		public boleto(int numero, String nombrepasajero, int edad, String celular) {
			super();
			this.numero = numero;
			this.nombrepasajero = nombrepasajero;
			this.edad = edad;
			this.celular = celular;
		}
		///Getters y Setters
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getNombrepasajero() {
			return nombrepasajero;
		}

		public void setNombrepasajero(String nombrepasajero) {
			this.nombrepasajero = nombrepasajero;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getCelular() {
			return celular;
		}

		public void setCelular(String celular) {
			this.celular = celular;
		}
		///Metodos
		public float calcularMonto(float precio) {
			float resu = 0;
			if(getEdad() > 18)
				resu = resu + precio;
			else
				resu =  ((resu + precio) * 0.75f);
			return resu;
		}
}