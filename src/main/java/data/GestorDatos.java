package data;
import controller.RegistroController;
import model.Cuenta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
	private RegistroController registroController;

	public static List<Cuenta> leerArchivoCuentas(String direccion) {
		List<Cuenta> cuentas = new ArrayList<>();
		String textoArchivo = "";
		try {
			File archivo = new File(direccion);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = br.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				cuentas.add(new Cuenta(data[0], data[1],data[2]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Documento no disponible, favor contactar con administrador");
		}
		return cuentas;
	}

	public static void registroCuenta(Object objeto,String direccion) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(objeto.toString());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
		}
	}
}