package logica.negocio;
import logica.negocio.paseo;
public class boleto {

		private int numero;
		
		private String nombrepasajero;
		
		private int edad;
		
		private String celular;

		public boleto(int numero, String nombrepasajero, int edad, String celular) {
			super();
			this.numero = numero;
			this.nombrepasajero = nombrepasajero;
			this.edad = edad;
			this.celular = celular;
		}

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
		
		public float calcularMonto(float x,paseo p) {
			if(getEdad() < 18)
				x = x + p.getPrecio();
			else
				x = (float) ((x + p.getPrecio()) * 0.75);
			return x;
		}
}