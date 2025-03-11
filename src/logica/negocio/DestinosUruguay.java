package logica.negocio;
import java.util.*;

public class DestinosUruguay {
    private static final Map<String, List<String>> destinosMap = new HashMap<>();

    static {
        destinosMap.put("Canelones", Arrays.asList(
            "atlantida", "costa de oro", "reserva natural de cangrejos del arroyo solis chico", "paseo de esculturas en la floresta",
            "centro isha en costa azul", "parque natural del arroyo el bagre", "casa museo de artigas en sauce",
            "parque general artigas en sauce", "quinta capurro en santa lucia", "parque roosevelt", "bodega juanico"
        ));

        destinosMap.put("Maldonado", Arrays.asList(
        		"punta del este", "la barra", "jose ignacio", "piriapolis", "cerro pan de azucar", "arboretum lussich",
                "museo ralli", "isla gorriti", "casapueblo", "laguna del sauce"
        ));

        destinosMap.put("Rocha", Arrays.asList(
        		"cabo polonio", "la paloma", "la pedrera", "laguna de rocha", "santa teresa", "valizas", "laguna garzon",
                "punta del diablo", "bosque de ombues", "fortaleza de santa teresa", "castillos", "estancia guardia del monte"
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