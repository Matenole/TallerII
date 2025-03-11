package grafica;
import java.rmi.RemoteException;
import java.util.List;
import logica.excepciones.DescuentoException;
import logica.excepciones.DestinoException;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.fachada.Fachada;
import logica.negocio.*;
import logica.valueobject.*;
public class TestFachada {

	public static void main(String[] args) throws LogicaException, RegistroException, RemoteException, RegistroExceptionII, PersistenciaException, DescuentoException, DestinoException {
		///Inicio Prueba fachada
		Fachada f = new Fachada();
		///Prueba 1: venta boleto(testing positivo)
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		boleto b1 = new boleto(1122,"Josh Peck",14,"urrutia098588832");
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		*/
		///Acierto: ventaboleto funciona correctamente. 
		///Prueba 1.1:ingresar un boleto con descuento negativo(Testing negativo)
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		especial b1 = new especial(1122,"Josh Peck",14,"urrutia098588832",-10000.50000f);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		*/
		///Acierto:Efectivamente da error el ingresar un boleto especial con valores negativos.
		///Prueba 1.2:ingresar un boleto con edad menor o igual a 0
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		boleto b1 = new boleto(1122,"Josh Peck",-100,"urrutia098588832");
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		*/
		///Acierto: tanto para el caso de que sea 0 o negativo, el boleto no se ingresa y da error, como tiene que ser.
		///Prueba 1.3:ingresar un boleto 0 o con valores negqativos en el en su celular
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		boleto b1 = new boleto(1122,"Josh Peck",14,"-52066667879234");
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		*/
		///Acierto:Tanto para valores negativos como 0 dan error. es lo q se busca y efectivamente se logra.
		///Prueba 1.4: ingresar boletos cuando enrealidad no hay mas lugar:
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,2);
		boleto b1 = new boleto(1122,"Josh Peck",14,"urrutia098588832");
		boleto b2 = new boleto(3344,"Josh Peck",14,"urrutia098588832");
		boleto b3 = new boleto(5566,"Josh Peck",14,"urrutia098588832");
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		f.VentaBol(p3.getCodigo(),b2);
		f.VentaBol(p3.getCodigo(),b3);
		*/
		///Acierto:el ingresar un boleto cuando no hay mas lugar el error correspondiente salta cuando tiene que saltar
		///Prueba 2:Registrar un paseo en el sistema(testing positivo)
		///
		/*
		paseo p2 = new paseo("Salus1","",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		*/
		//Acierto: registrar un paseo en el sistema funciona correctamente.
		//Prueba 2.1: ingresar dos paseos con el mismo codigo(testing negativo)
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		paseo p3 = new paseo("Salus1","PuntaDelEste",LocalTime.of(15,06),LocalTime.of(02,45),10.5f,8);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		*/
		//Acierto:registrar dos paseos con el mismo codigo en el sistema da efectivamente error,como debe ser. buen trabajo para el que lo hizo. mi mas querido enhorabuena.
		//Prueba 2.2: agregar un paseo con datos no alfanumericos en su codigo
		/*
		paseo p2 = new paseo("++xxxAnonimoxx---","Arroyo Solis chico",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		 */	
		//Acierto:ingresar codigo NO alfanumerico en el sistema efectivamente dara error. muy bien hecho.
		
		//Prueba 3: Registrar una minivan en el sistema(Testing positivo):
		/*
		minivan m1= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		*/
		///Acierto: el ingreso normal de una minivan funciona correctamente.
		///Prueba 3.1:Registrar dos minivanes con el mismo codigo.
		/*
		minivan m1= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		minivan m2= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vl = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		f.RegisMin(vl);
		*/
		///Acierto: efectivamente salta un error en el sistema al ingresar dos minivanes con el mismo codigo.
		///Prueba 3.2: Registrar una minivan con digitos no alfanumericos en su codigo.
		/*
		minivan m1= new minivan("+kernelloverrrr098","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		*/
		///Acierto: is se ingresa una matricula con digistos no alfanumericos efectivamente salta error. bien ahi pa.
		///Prueba 4:Listado de una minivan(Testing positivo)
		/*
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		minivan m2= new minivan("LOA4522","Toyota","Prius",30);
		VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		minivan m3= new minivan("MMC5566","Toyota","Prius",30);
		VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
		minivan m4= new minivan("NOPA99","Toyota","Prius",30);
		VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
		f.RegisMin(vom);
		f.RegisMin(vom1);
		f.RegisMin(vom2);
		f.RegisMin(vom3);
		List<VOminivanlistado> l= f.LisMin();
		System.out.println("=== Detalles de las Minivans ===");
        for (VOminivan minivan : l) {
            System.out.println("Matricula: " + minivan.getMatricula());
            System.out.println("Marca: " + minivan.getMarca());
            System.out.println("Modelo: " + minivan.getModelo());
            System.out.println("Cantidad de Asientos: " + minivan.getCantasientos());
            System.out.println("-----------------------------");
        }
        */
		///Acierto:lista funciona correctamente.
		///Prueba 5: listar una minivan que no tiene asignado ningun paseo:(Testing negativo)
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		minivan m2= new minivan("LOA4522","Toyota","Prius",30);
		VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		minivan m3= new minivan("MMC5566","Toyota","Prius",30);
		VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
		minivan m4= new minivan("NOPA99","Toyota","Prius",30);
		VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
		f.RegisMin(vom);
		f.RegisMin(vom1);
		f.RegisMin(vom2);
		f.RegisMin(vom3);
		List<VOpaseolistado> l= f.LisPasAsMin(m1.getMatricula(),p2.getCodigo());
		*/
		//Acierto: efectivamente da error.
		///Prueba 5.1:listar una minivan si asignada al sistema(Testing positivo):
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		paseo p3 = new paseo("Kloe456","Rocha",LocalTime.of(11,20),LocalTime.of(18,40),100.5f,12);
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.asignar(m1.getMatricula(),p2.getCodigo());
		List<VOpaseolistado> l= f.LisPasAsMin(m1.getMatricula(),p2.getCodigo());
		for (VOpaseolistado pas : l) {
            System.out.println("Codigo: " + pas.getCodigo());
            System.out.println("Destino: " + pas.getDestino());
            System.out.println("Salida: " + pas.getHorasalida());
            System.out.println("Llegada: " + pas.getHorallegada());
            System.out.println("Precio: " + pas.getPrecio());
            System.out.println("Cantidadmaximadeboletos: " + pas.getMaxboletos());
            System.out.println("-----------------------------");
        }
        */
		///Acierto: Listar paseos asignados a su correspondiente minivan funciona correctamente. el que esta asignado se lista y el paseo que no esta asignado a esa minivan no se lista. perfecto, mejor imposible.
		///Prueba 6:Listar paseos por su destino:(Testing positivo)
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		paseo p3 = new paseo("NegroDelTunel11","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		paseo p4 = new paseo("PokimaneCheta0456","PuntaDelDiablo",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p4.getCodigo(),p4.getDestino(),p4.getHorallegada(),p4.getHorasalida(),p4.getPrecio(),p4.getMaxboletos());
		List<VOpaseolistado> l= f.LisPasDes(p2.getDestino());
		 for (VOpaseolistado pas : l) {
	            System.out.println("Codigo: " + pas.getCodigo());
	            System.out.println("Destino: " + pas.getDestino());
	            System.out.println("Salida: " + pas.getHorasalida());
	            System.out.println("Llegada: " + pas.getHorallegada());
	            System.out.println("Precio: " + pas.getPrecio());
	            System.out.println("Cantidadmaximadeboletos: " + pas.getMaxboletos());
	            System.out.println("-----------------------------");
	        }
	    */
		//Acierto: imprime correctamente la cantidad correcta de paseos por pantalla de los paseos con el destino correcto.
		 ///Para poder probar listarboletospordisponibilidad,listadoporvoletosvendidos y montorecaudado hay que arreglar ventaboleto y verificar la insercion de boletos a los paseos correspondientes.
	///Prueba 7:Guardar la realidad en un archivo respaldando los datos(Testing positivo)
			/*
		 	paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
			paseo p3 = new paseo("NegroDelTunel11","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
			paseo p4 = new paseo("PokimaneCheta0456","PuntaDelDiablo",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p4.getCodigo(),p4.getDestino(),p4.getHorallegada(),p4.getHorasalida(),p4.getPrecio(),p4.getMaxboletos());
			minivan m1= new minivan("GAB7654","Toyota","Prius",30);
			VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
			minivan m2= new minivan("LOA4522","Toyota","Prius",30);
			VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
			minivan m3= new minivan("MMC5566","Toyota","Prius",30);
			VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
			minivan m4= new minivan("NOPA99","Toyota","Prius",30);
			VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
			f.RegisMin(vom);
			f.RegisMin(vom1);
			f.RegisMin(vom2);
			f.RegisMin(vom3);
			f.respaldardatos();
			*/
			///Acierto
			///Prueba 8:Recuperacion de los datos:(Testing positivo):
			/*
			f.recuperardatos();
			*/
			///Acierto
			///Prueba 9: listar por disponibilidad de boletos:
			/*
			paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,8);
			f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
			paseo p3 = new paseo("NegroDelTunel11","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,07);
			f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
			paseo p4 = new paseo("PokimaneCheta0456","PuntaDelDiablo",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p4.getCodigo(),p4.getDestino(),p4.getHorallegada(),p4.getHorasalida(),p4.getPrecio(),p4.getMaxboletos());
			int op = 7;
			VOpaseoingreso l = f.LisDisBol(op, p2.getBoletosVendidos());
			System.out.println("Codigo: " + l.getCodigo());
		    System.out.println("Destino: " + l.getDestino());
		    System.out.println("Salida: " + l.getHorasalida());
		    System.out.println("Llegada: " + l.getHorallegada());
		    System.out.println("Precio: " + l.getPrecio());
		    System.out.println("Cantidadmaximadeboletos: " + l.getMaxboletos());
		    System.out.println("-----------------------------");
		    */
		    ///Acierto: el codigo esta bien y cuando se cumple la condicion de error salta correctamente y no salta cuando no. eso esta perfecto.
		    ///Sugerencia: en vez de devolver un VOpaseolistado devolver una lista del mismo como de costumbre con los demas listados.
		    ///Prueba 10:Monto recaudado(Testing positivo):
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,8);
		boleto b = new boleto(7788,"Tarzan",18,"pochoclo89100");
		boleto c = new boleto(6733,"George de la selva",18,"Atuctuc1122");
		especial d = new especial(1122,"Cenicienta",22,"hermanastra043",10.5f);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		f.VentaBol(p2.getCodigo(),b);
		f.VentaBol(p2.getCodigo(),c);
		f.VentaBol(p2.getCodigo(),d);
		float i = f.MonRec(p2.getCodigo());
		System.out.println("Precio: " + i);
		*/
		///Acierto: el boleto modifica su monto correctamente. incluso modificando la edad a un numero mayor que 18 tambien modifica correctamente la edad
		///Prueba 11:listar  por boletos vendidos(Testing positivo):
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,3);
		boleto b = new boleto(7788,"Tarzan",18,"pochoclo89100");
		boleto c = new boleto(6733,"George de la selva",15,"Atuctuc1122");
		especial d = new especial(9999,"Cenicienta",22,"hermanastra043",109.5f);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorasalida(),p2.getHorallegada(),p2.getPrecio(),p2.getMaxboletos());
		paseo p3 = new paseo("Lucerna6433","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,2);
		boleto e = new boleto(77,"Tarzan",18,"pochoclo89100");
		especial g = new especial(7,"Cenicienta",22,"hermanastra043",10.5f);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorasalida(),p3.getHorallegada(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p2.getCodigo(), b);
		f.VentaBol(p2.getCodigo(), c);
		f.VentaBol(p2.getCodigo(), d);
		f.VentaBol(p3.getCodigo(), e);
		f.VentaBol(p3.getCodigo(), g);
		Boletos l= f.LisPasBolVen(p2.getCodigo());
		 for (boleto pas : l) {
	            System.out.println("Codigo: " + pas.getNumero());
	            System.out.println("Destino: " + pas.getNombrepasajero());
	            System.out.println("Salida: " + pas.getEdad());
	            System.out.println("Llegada: " +pas.getCelular());
	            System.out.println("-----------------------------");
	        }
		 Boletos o= f.LisPasBolVen(p3.getCodigo());
			 for (boleto pes : o) {
		            System.out.println("Codigo: " + pes.getNumero());
		            System.out.println("Destino: " + pes.getNombrepasajero());
		            System.out.println("Salida: " + pes.getEdad());
		            System.out.println("Llegada: " + pes.getCelular());
		            System.out.println("-----------------------------");
		        }
		 */
	  ///Acierto: se lista correctamente los paseos que poseen misma cantidad de boletos y maxima cantidad de boletos vendidos. el paseo salus1 se listo dos veces, igual de momento no jode mucho eso. venimos bien
	}
}

