package persistencia;
import java.io.*;
import sistema.logica.vehiculos.Vehiculo;
import sistema.logica.excepciones.PersistenciaException;
public class Persistencia
{
public void respaldar (String nomArch, Vehiculo arre[])
throws PersistenciaException ...
public Vehiculo [] recuperar (String nomArch)
throws PersistenciaException ...
}
public void respaldar (String nomArch, Vehiculo arre[])
throws PersistenciaException
{ try
{ // Abro el archivo y creo un flujo de comunicación hacia él
FileOutputStream f = new FileOutputStream(nomArch);
ObjectOutputStream o = new ObjectOutputStream(f);
// Escribo el arreglo de vehículos en el archivo a través del flujo
o.writeObject (arre);
o.close();
f.close();
}
catch (IOException e)
{ e.printStackTrace();
throw new PersistenciaException("error respaldar");
}
}
public Vehiculo [] recuperar (String nomArch)
throws PersistenciaException
{ try
{ // Abro el archivo y creo un flujo de comunicación hacia él
FileInputStream f = new FileInputStream(nomArch);
ObjectInputStream o = new ObjectInputStream(f);
// Leo el arreglo de vehículos desde el archivo a través del flujo
Vehiculo arre[] = (Vehiculo []) o.readObject();
o.close();
f.close();
return arre;
}
catch (IOException e)
{ e.printStackTrace();
throw new PersistenciaException("error recuperar");
}