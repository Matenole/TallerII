package logica.colecciones;
import java.time.LocalTime;
import java.util.*;
import logica.negocio.paseo;
import logica.valueobject.VOpaseolistado;

public class Paseos {
	
	private TreeMap <String, paseo> AVL_Paseos;
	public Paseos() {
        AVL_Paseos = new TreeMap<>();
    }

	public VOpaseolistado listadoPaseos(String mat) {
	    ArrayList<paseo> paseosFiltrados = new ArrayList<>();

	    // Iterar sobre todos los paseos en el TreeMap
	    for (paseo p : AVL_Paseos.values()) {
	        if (p.getMinivanMatricula().equals(mat)) { // Verificar si el paseo pertenece a la minivan
	            paseosFiltrados.add(p);
	        }
	    }

	    // Si no hay paseos filtrados, devolver un objeto vacío o nulo
	    if (paseosFiltrados.isEmpty()) {
	        return null; // O podrías devolver un objeto VOpaseolistado con valores predeterminados
	    }

	    // Calcular datos agregados
	    String codigoCombinado = "codigo-combinado"; // Puedes generar un código único si es necesario
	    String destinoCombinado = "destino-combinado"; // Puedes combinar destinos si es necesario
	    LocalTime primeraHoraSalida = paseosFiltrados.get(0).getHorallegada(); // Primera hora de salida
	    LocalTime ultimaHoraLlegada = paseosFiltrados.get(paseosFiltrados.size() - 1).getHorallegada(); // Última hora de llegada
	    float montoTotal = 0.0f;
	    int maxBoletosTotal = 0;

	    for (paseo p : paseosFiltrados) {
	        montoTotal += p.getPrecio(); // Sumar el precio de cada paseo
	        maxBoletosTotal += p.getMaxboletos(); // Sumar el máximo de boletos de cada paseo
	    }

	    // Construir y devolver el objeto VOpaseolistado
	    return new VOpaseolistado(
	        codigoCombinado,
	        destinoCombinado,
	        primeraHoraSalida,
	        ultimaHoraLlegada,
	        montoTotal,
	        maxBoletosTotal,
	        montoTotal
	    );
	}
	
	public VOpaseolistado listadoPaseosPorDestino(String dest) {
		VOpaseolistado vopl = null;;
		return vopl;
	}
	
	public VOpaseolistado listadoPorDisponibilidad(int cant_Bol) {
		VOpaseolistado vopl = null;;
		return vopl;
	}
	
	//public void insert(logica.negocio.paseo p) {
	//	Iterator<paseo> iter = AVL_Paseos.values().iterator();
		 //while (iter.hasNext()){
		//	 if(iter.next() == null) {
		//		 AVL_Paseos.values().add(p);
		//	 }
		//	 String elem = iter.next();
		//	 System.out.println (elem);
		 //}
	//}
	
	public paseo find(String cod) {
		paseo p = null;
		return p;
	}
	
	public boolean member(String cod) {
		boolean b = false;
		return b;
	}
}