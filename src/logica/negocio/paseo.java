package logica.negocio;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import logica.valueobject.VOboletolistado;
import logica.colecciones.*;
public class paseo {
		///Atributos
		private String Codigo;
		
		private String Destino;
		
		private LocalTime Horasalida;
		
		private LocalTime Horallegada;
		
		private float precio;
		
		private int maxboletos;
		
		private String minivanMatricula;

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
			//ListaPaseos = new Paseos();
			this.boletosVendidos = new Boletos();
		}
		/// Getters y Setters
		public String getMinivanMatricula() {
	        return minivanMatricula;
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
		
		public List<VOboletolistado> listarBoletos(String tipoBoleto) {
	        if (!existePaseo(this.Codigo)) {
	            throw new IllegalArgumentException("Error: el código no figura");
	        }

	        List<VOboletolistado> listado = new ArrayList<>();

	        boletosVendidos = null;
			for (int i = 0; i < boletosVendidos.size(); i++) {
	            boleto b = boletosVendidos.kesimo(i);
	            if (listado != null) {
	                VOboletolistado vo = new VOboletolistado(
	                    b.getNombrepasajero(),
	                    b.getEdad(),
	                    b.getCelular(),
	                    b.getNumero(),
	                    b.calcularMonto(precio) // Calculamos el monto del boleto
	                );
	                listado.add(vo);
	            }
	        }

	        // Ordenamos la lista por número de boleto
	        Collections.sort(listado, Comparator.comparingInt(VOboletolistado::getNumero));

	        return listado;
	    }

	    private boolean existePaseo(String codigo) {
	        // Aquí deberías implementar la lógica para verificar si el paseo existe
	        // Por ejemplo, buscar en una lista de paseos o en una base de datos
	        return true; // Asumimos que el paseo existe para este ejemplo
	    }
}

		