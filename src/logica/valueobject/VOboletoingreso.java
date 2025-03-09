package logica.valueobject;

import java.io.Serializable;

public class VOboletoingreso implements Serializable{
		///Atributos
		private int codigo;
		private String nombrepasajero;
		
		private int edad;
		
		private String celular;
		///Constructor
		public VOboletoingreso(int codigo,String nombrepasajero, int edad, String celular) {
			super();
			this.codigo = codigo;
			this.nombrepasajero = nombrepasajero;
			this.edad = edad;
			this.celular = celular;
		}
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		///Getters y Setters
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
		
		
}
