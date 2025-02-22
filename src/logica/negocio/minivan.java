package logica.negocio;
import java.util.Iterator;
import java.util.TreeMap;
import logica.colecciones.Paseos;
import logica.negocio.paseo;
import logica.valueobject.VOboletolistado;
import logica.valueobject.VOpaseolistado;

public class minivan {

		private String Matricula;
		
		private String Marca;
				
		private String Modelo;
		
		private int Cantasientos;
		
		private Paseos Dic_Paseos;

		public minivan(String matricula, String marca, String modelo, int cantasientos) {
			super();
			Matricula = matricula;
			Marca = marca;
			Modelo = modelo;
			Cantasientos = cantasientos;
			Dic_Paseos = new Paseos();
		}

		public String getMatricula() {
			return Matricula;
		}

		public void setMatricula(String matricula) {
			Matricula = matricula;
		}

		public String getMarca() {
			return Marca;
		}

		public void setMarca(String marca) {
			Marca = marca;
		}

		public String getModelo() {
			return Modelo;
		}

		public void setModelo(String modelo) {
			Modelo = modelo;
		}

		public int getCantasientos() {
			return Cantasientos;
		}

		public void setCantasientos(int cantasientos) {
			Cantasientos = cantasientos;
		}
		/*
		public void insertarPaseo(paseo p) {
			Dic_Paseos.insert(p);
		}
		*/
		public VOpaseolistado listarPaseo() {
		    // Llamar al método listadoPaseos de la clase Paseos
		    return Dic_Paseos.listadoPaseos(getMatricula());
		}
}
