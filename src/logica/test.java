package logica;

import java.time.LocalTime;

public class test {

	public static void main(String[] args) {
		// Definir las horas del paseo
        LocalTime paseoHoraPartida = LocalTime.of(8, 0);  // 8:00 AM
        LocalTime paseoHoraLlegada = LocalTime.of(12, 0); // 12:00 PM

        // Definir las horas a verificar
        LocalTime horaPartida = LocalTime.of(6, 0);  // 9:00 AM
        LocalTime horaLlegada = LocalTime.of(7, 0); // 11:00 AM

        // Verificar si alguna de las horas está dentro del rango
        /*boolean estaDentroDelRango =
                (horaPartida.isAfter(paseoHoraPartida) && horaPartida.isBefore(paseoHoraLlegada)) || // Hora de partida
                (horaLlegada.isAfter(paseoHoraPartida) && horaLlegada.isBefore(paseoHoraLlegada));    // Hora de llegada
		*/
        
        boolean estaDentroDelRango = (horaPartida.compareTo(paseoHoraLlegada)>=0) || (horaLlegada.compareTo(paseoHoraPartida)<=0);
        
        // Mostrar el resultado
        if (estaDentroDelRango) {
            System.out.println("La hora de partida o llegada está dentro del rango del paseo.");
        } else {
            System.out.println("La hora de partida y llegada NO están dentro del rango del paseo.");
	}

}
}