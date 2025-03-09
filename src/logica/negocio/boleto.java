package logica.negocio;

import java.io.Serializable;

import logica.excepciones.DescuentoException;

public class boleto implements Serializable{
		/**
	 * 
	 */
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
			float resu = 0;//Paseo recibe el float q es creado en el calcularmonto de la clase paseo
			if(getEdad() > 18)//Verificamos q la edad sea mayor q 18
				resu = resu + precio;//Le ponemos el precio normal
			else
				resu =  ((resu + precio) * 0.75f);//Le ponemos el precio mas el descuento indicado por la letra
			return resu;
		}
		/*public static especial convertirAEspecial(boleto boletoComun, float descuento) throws DescuentoException {
		        return new especial(
		                boletoComun.getNumero(),
		                boletoComun.getNombrepasajero(),
		                boletoComun.getEdad(),
		                boletoComun.getCelular(),
		                descuento
		        );
		}*/
}