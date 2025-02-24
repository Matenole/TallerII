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
		public float calcularMonto(float precio) {
			float resu = 0;//Paseo recibe el float q es creado en el calcularmonto de la clase paseo
			if(getEdad() > 18)//Verificamos q la edad sea mayor q 18
				resu = resu + precio;//Le ponemos el precio normal
			else
				resu = (float) ((resu + precio) * 0.75);//Le ponemos el precio mas el descuento indicado por la letra
			resu = resu - Descuento;
			return resu;
		}
}