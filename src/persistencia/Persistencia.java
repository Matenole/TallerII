package persistencia;
import java.io.*;
import logica.excepciones.*;

public class Persistencia{
		public void respaldar (String nombrearchivo,VOPersistencia vo) throws PersistenciaException{
			try
			{	FileOutputStream f = new FileOutputStream (nombrearchivo);
				ObjectOutputStream o = new ObjectOutputStream (f);
			
				o.writeObject(vo);
				o.close();
				f.close();
			}	
			catch (IOException e)
			{	e.printStackTrace();
			throw new PersistenciaException ("Error al respaldar");
		}
		}

		public VOPersistencia recuperar (String nombrearchivo) throws PersistenciaException{
		try
		{	FileInputStream f = new FileInputStream (nombrearchivo);
			ObjectInputStream o = new ObjectInputStream (f);
		
			VOPersistencia vo = (VOPersistencia) o.readObject();
			o.close();
			f.close();
		 	return vo;
		}	
		catch (IOException | ClassNotFoundException e)
		{	e.printStackTrace();
			throw new PersistenciaException ("Error al recuperar");
		}
	}

}
