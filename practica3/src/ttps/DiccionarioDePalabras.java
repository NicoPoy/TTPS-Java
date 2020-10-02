package ttps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DiccionarioDePalabras {

	public void generarPropertiesEspañol( File español ) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(español, true));		
		try {
			String str = ( "hola=Hola"  );
			writer.write(str);
			writer.newLine();
			str = ( "usuario=Usuario"  );
			writer.write(str);
			writer.newLine();
			str = ( "clave=Contraseña"  );
			writer.write(str);
			writer.newLine();	
			str = ( "enviar=Enviar"  );
			writer.write(str);
			writer.newLine();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
	public void generarPropertiesIngles( File ingles ) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(ingles, true));	
		
		try {
			String str = ( "hola=Hi"  );
			writer.write(str);
			writer.newLine();
			str = ( "usuario=Username"  );
			writer.write(str);
			writer.newLine();
			str = ( "clave=Password"  );
			writer.write(str);
			writer.newLine();	
			str = ( "enviar=Send"  );
			writer.write(str);
			writer.newLine();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}	
	
	
	
	
	

}
