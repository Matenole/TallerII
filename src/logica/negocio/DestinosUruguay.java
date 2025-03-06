package logica.negocio;
import java.util.*;

public class DestinosUruguay {
    private static final Map<String, List<String>> destinosMap = new HashMap<>();

    static {
        destinosMap.put("Canelones", Arrays.asList(
            "Costa de Oro", "Reserva Natural de Cangrejos del Arroyo Solís Chico", "Paseo de Esculturas en La Floresta",
            "Centro Isha en Costa Azul", "Parque Natural del Arroyo El Bagre", "Casa Museo de Artigas en Sauce",
            "Parque General Artigas en Sauce", "Quinta Capurro en Santa Lucía", "Parque Roosevelt", "Bodega Juanicó"
        ));

        destinosMap.put("Maldonado", Arrays.asList(
            "Punta del Este", "La Barra", "José Ignacio", "Piriápolis", "Cerro Pan de Azúcar", "Arboretum Lussich",
            "Museo Ralli", "Isla Gorriti", "Casapueblo", "Laguna del Sauce"
        ));

        destinosMap.put("Rocha", Arrays.asList(
            "Cabo Polonio", "La Paloma", "La Pedrera", "Laguna de Rocha", "Santa Teresa", "Valizas", "Laguna Garzón",
            "Punta del Diablo", "Bosque de Ombúes", "Fortaleza de Santa Teresa", "Castillos", "Estancia Guardia del Monte"
        ));
    }

    public static boolean esDestinoValido(String destino) {
        return destinosMap.values().stream().anyMatch(lista -> lista.contains(destino));
    }

    public static String obtenerDepartamento(String destino) {
        for (Map.Entry<String, List<String>> entry : destinosMap.entrySet()) {
            if (entry.getValue().contains(destino)) {
                return entry.getKey();
            }
        }
        return "Destino no encontrado";
    }

    public static List<String> obtenerDestinosPorDepartamento(String departamento) {
        return destinosMap.getOrDefault(departamento, Collections.emptyList());
    }
}