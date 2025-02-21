package logica.negocio;

public class especial extends boleto{

		private float Descuento;

		public especial(int numero, String nombre, int edad, String celular, float descuento) {
			super(numero, nombre, edad, celular);
			Descuento = descuento;
		}

		public float getDescuento() {
			return Descuento;
		}

		public void setDescuento(float descuento) {
			Descuento = descuento;
		}
		
		public float calcularMonto(float x) {
			return x - Descuento;
		}
}