package logica.negocio;

import logica.excepciones.DescuentoException;

public class especial extends boleto{

	private static final long serialVersionUID = 1L;
		///Atributo
		private float Descuento;
		///Constructor
		public especial(int numero, String nombre, int edad, String celular, float descuento) throws DescuentoException {
			super(numero, nombre, edad, celular);
			Descuento = descuento;
			if(descuento <= 0)
				throw new DescuentoException("el descuento ingresado no puede ser menor o igual a 0");
		}
		///Getter y Setter
		public float getDescuento() {
			return Descuento;
		}

		public void setDescuento(float descuento) {
			Descuento = descuento;
		}
		///Metodo
		public float calcularMonto(float precio) {
			float resu = 0;
			if(getEdad() > 18)
				resu = resu + precio;
			else
				resu = (float) ((resu + precio) * 0.75);
			resu = resu - Descuento;
			return resu;
		}
}