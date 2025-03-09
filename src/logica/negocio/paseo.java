
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
		/**
	 * 
	 */
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
		
		//private Paseos ListaPaseos;
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
		    int i = boletosVendidos.size(); // Obtener el tamaño real del ArrayList
		    
		    while (i != 0) {
		        i--; // Decrementar antes de acceder al elemento
		        boleto b = boletosVendidos.kesimo(i); // Obtener el boleto en la posición i
		        mo = mo + b.calcularMonto(precio); // Calcular el monto para este boleto
		    }
		    return mo;
		}
		
		public ArrayList<VOboletolistado> listarBoletos() {
			ArrayList<VOboletolistado> listado = new ArrayList<>();
			for (int i = 0; i < boletosVendidos.size(); i++) {
	            boleto b = boletosVendidos.kesimo(i);
	            if (listado != null) {
	                VOboletolistado vo = new VOboletolistado(
	                	b.getNumero(),
	                    b.getNombrepasajero(),
	                    b.getEdad(),
	                    b.getCelular()
	                );
	                listado.add(vo);
	            }
	        }
	        //Collections.sort(listado, Comparator.comparingInt(VOboletolistado::getNumero));
	        return listado;
	    }
		
		public ArrayList<VOboletoespeciallistado> listarBoletosEspecial() {
			ArrayList<VOboletoespeciallistado> listado = new ArrayList<>();
			for (int i = 0; i < boletosVendidos.size(); i++) {
	            especial b = (especial) boletosVendidos.kesimo(i);
	            if (listado != null) {
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

		