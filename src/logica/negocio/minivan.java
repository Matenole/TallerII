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
		
		public void insertarPaseo(paseo p) {
			Dic_Paseos.insert(p);
		}
		
		public VOpaseolistado listarPaseo() {
			//Iterator <String> iter = Dic_Paseos.values().iterator()
			//while (AVL_Paseos.)
			VOpaseolistado vopl = null;	//Solo nos sirve CantAsientos verdad? De donde sacamos el resto de datos?
			return vopl;
		}
}
