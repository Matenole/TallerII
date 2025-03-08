package logica.valueobject;
import java.io.Serializable;
import java.time.*;

public class VOpaseolistado extends VOpaseoingreso implements Serializable{
		///Atributo
		private float monto;
		///Constructor
		public VOpaseolistado(String codigo, String destino, LocalTime horasalida, LocalTime horallegada, float precio) {
			super(codigo, destino, horasalida, horallegada, precio);
		}
		///Getter y Setter
		public float getMonto() {
			return monto;
		}

		public void setMonto(float monto) {
			this.monto = monto;
		}
		///Metodos
		public int cantMaxBoletos(int x) {
			return x;
		}
		
		public int cantBoletosDisponibles(int x) {
			return x;
		}
}
