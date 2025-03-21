
package logica.negocio;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import logica.valueobject.VOboletolistado;
import logica.valueobject.VOboletoespeciallistado;
import logica.colecciones.*;

public class paseo implements Serializable{

	private static final long serialVersionUID = 1L;

		///Atributos
		private String Codigo;
		
		private String Destino;
		
		private LocalTime Horasalida;
		
		private LocalTime Horallegada;
		
		private float precio;
		
		private int maxboletos;
		
		private String minivanAsignada;

		private Boletos boletosVendidos;
		
		///Constructor
		public paseo(String codigo, String destino, LocalTime horasalida, LocalTime horallegada, float precio, int maxboletos) {
			super();
			Codigo = codigo;
			Destino = destino;
			Horasalida = horasalida;
			Horallegada = horallegada;
			this.precio = precio;
			this.maxboletos = maxboletos;
			this.boletosVendidos = new Boletos();
		}
		/// Getters y Setters
		public String getMinivanMatricula() {
	        return minivanAsignada;
	    }
		public String getCodigo() {
			return Codigo;
		}

		public void setCodigo(String codigo) {
			Codigo = codigo;
		}

		public String getDestino() {
			return Destino;
		}

		public void setDestino(String destino) {
			Destino = destino;
		}

		public LocalTime getHorasalida() {
			return Horasalida;
		}

		public void setHorasalida(LocalTime horasalida) {
			Horasalida = horasalida;
		}

		public LocalTime getHorallegada() {
			return Horallegada;
		}

		public void setHorallegada(LocalTime horallegada) {
			Horallegada = horallegada;
		}

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public int getMaxboletos() {
			return maxboletos;
		}

		public void setMaxboletos(int maxboletos) {
			this.maxboletos = maxboletos;
		}
		
		public Boletos getBoletosVendidos() {
			return boletosVendidos;
		}
		public void setBoletosVendidos(Boletos boletosVendidos) {
			this.boletosVendidos = boletosVendidos;
		}
		///Metodos
		public void ventaBoleto(boleto B) {
			boletosVendidos.insert(B);
		}
		public float montoRecaudado() {
		    float mo = 0;
		    int i = boletosVendidos.size();
		    
		    while (i != 0) {
		        i--; 
		        boleto b = boletosVendidos.kesimo(i);
		        mo = mo + b.calcularMonto(precio);
		    }
		    return mo;
		}
		
		public ArrayList<VOboletolistado> listarBoletos() {
			ArrayList<VOboletolistado> listado = new ArrayList<>();
			for (int i = 0; i < boletosVendidos.size(); i++) {
	            boleto b = boletosVendidos.kesimo(i);
	            if (!(b instanceof especial)) {
	                VOboletolistado vo = new VOboletolistado(
	                	b.getNumero(),
	                    b.getNombrepasajero(),
	                    b.getEdad(),
	                    b.getCelular()
	                );
	                listado.add(vo);
	            }
	        }
	        return listado;
	    }
		
		public ArrayList<VOboletoespeciallistado> listarBoletosEspecial() {
			ArrayList<VOboletoespeciallistado> listado = new ArrayList<>();
			for (int i = 0; i < boletosVendidos.size(); i++) {
	            boleto b1 = boletosVendidos.kesimo(i);
	            if (b1 instanceof especial) {
	            	especial b = (especial) b1;
	                VOboletoespeciallistado vo = new VOboletoespeciallistado(
	                	b.getNumero(),
	                	b.getNombrepasajero(),
	                    b.getEdad(),
	                    b.getCelular(),
	                    b.getDescuento()
	                );
	                listado.add(vo);
	            }
	        }
	        return listado;
	    }
		
		public int cantBoletosDisponibles() {
			return maxboletos - boletosVendidos.size();
		}
}

		