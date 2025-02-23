package logica.negocio;
public class especial extends boleto{
		///Atributo
		private float Descuento;
		///Constructor
		public especial(int numero, String nombre, int edad, String celular, float descuento) {
			super(numero, nombre, edad, celular);
			Descuento = descuento;
		}
		///Getter y Setter
		public float getDescuento() {
			return Descuento;
		}

		public void setDescuento(float descuento) {
			Descuento = descuento;
		}
		///Metodo
		public float calcularMonto(float x,paseo p) {
			if(getEdad() < 18)
			 x = (float) ((x + p.getPrecio()- Descuento)* 0.75);
			else
				x = x + p.getPrecio() - Descuento;
				return x;	
		}
}