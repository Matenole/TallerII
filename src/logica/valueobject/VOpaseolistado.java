package logica.valueobject;
import java.io.Serializable;
import java.time.*;

public class VOpaseolistado extends VOpaseoingreso implements Serializable{
		///Atributo
		private float monto;
		private int maxBol;
		private int bolDis;
		///Constructor
		public VOpaseolistado(String codigo, String destino, LocalTime horasalida, LocalTime horallegada, float precio, int maxbol, int boldis) {
			super(codigo, destino, horasalida, horallegada, precio);
			maxBol = maxbol;
			bolDis = boldis;
		}
		///Getter y Setter
		public float getMonto() {
			return monto;
		}

		public void setMonto(float monto) {
			this.monto = monto;
		}
		///Metodos
		public int getMaxBol() {
			return maxBol;
		}
		public void setMaxBol(int maxBol) {
			this.maxBol = maxBol;
		}
		public int getBolDis() {
			return bolDis;
		}
		public void setBolDis(int bolDis) {
			this.bolDis = bolDis;
		}
}
