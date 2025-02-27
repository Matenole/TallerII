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
	public void insert(paseo p) {
		AVL_Paseos.put(p.getCodigo(),p);
	}
	public ArrayList<VOpaseolistado> listadoPaseos() {										///LISTO
		ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(),pas.getMaxboletos(),pas.montoRecaudado());
	    								recorrido.add(vo);
	    								}
	    				  );
	    return recorrido;
	}
	public ArrayList<VOpaseolistado> listadoPaseosPorDestino(String dest) {					///CORREGIDO
		
		ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								if (pas.getDestino() == dest) {
	    									VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(),pas.getMaxboletos(),pas.montoRecaudado());
	    									recorrido.add(vo);
	    									}
	    								}
	    				  );
	    return recorrido;
		
		/*
        // Obtenemos la primera entrada del TreeMap (la de menor clave)
        String primerdestino = AVL_Paseos.firstKey();
        paseo el_paseo = AVL_Paseos.get(primerdestino);
        // Crear y devolver el VOminivan con los datos de la primera minivan
        return new VOpaseolistado(
            el_paseo.getCodigo(),
            el_paseo.getDestino(), 
            el_paseo.getHorasalida(),
            el_paseo.getHorallegada(),
            0,
            0,
            0
        );*/
	}
	 // Método para listar paseos según la cantidad de boletos disponibles
    public ArrayList<VOpaseolistado> listadoPorDisponibilidad(int cant_Bol) {					///CORREGIDO
    	ArrayList<VOpaseolistado> recorrido = new ArrayList<VOpaseolistado>();
	    AVL_Paseos.forEach((key,pas) ->	{
	    								if (pas.getMaxboletos() >= cant_Bol) {
	    									VOpaseolistado vo = new VOpaseolistado(pas.getCodigo(),pas.getDestino(),pas.getHorasalida(), pas.getHorallegada(),pas.getPrecio(),pas.getMaxboletos(),pas.montoRecaudado());
	    									recorrido.add(vo);
	    									}
	    								}
	    				  );
	    return recorrido;
    	
    	/*
        // Lista para almacenar paseos que cumplen con la condición
        ArrayList<paseo> paseosFiltrados = new ArrayList<>();
        // Recorrer todos los paseos en el TreeMap
        for (paseo p : AVL_Paseos.values()) {
            if (p.getMaxboletos() >= cant_Bol) { // Verificar si tiene suficientes boletos disponibles
                paseosFiltrados.add(p);
            }
        }
        // Si no hay paseos que cumplan la condición, devolver null o un objeto vacío
        if (paseosFiltrados.isEmpty()) {
            return null; // O podrías devolver un objeto VOpaseolistado con valores predeterminados
        }
        // Calcular datos agregados
        String codigoCombinado = "codigo-combinado"; // Puedes generar un código único si es necesario
        String destinoCombinado = "destino-combinado"; // Puedes combinar destinos si es necesario
        LocalTime primeraHoraSalida = paseosFiltrados.get(0).getHorasalida(); // Primera hora de salida
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
        );*/
    }
	public boolean member(String cod) {
		// Verificamos si el TreeMap es nulo o está vacío
        if (AVL_Paseos == null || AVL_Paseos.isEmpty()) {
            return false;
        }
        // Verificamos si el codigo existe en el TreeMap
        return AVL_Paseos.containsKey(cod);	
        }
	public paseo find(String cod) {
		//Controlamos que el arbol no sea nulo o este vacio
		if(AVL_Paseos == null || AVL_Paseos.isEmpty())
			throw new IllegalStateException("El TreeMap está vacío");
		//Verificamos si el paseo esta en el AVL
		if(!member(cod))
			throw new NoSuchElementException("El paseo con codigo " + cod + " no existe");
		//Obtenemos paseo asociado al codigo
		return AVL_Paseos.get(cod);
	}
}