/**
 * 
 */
package nico.castleland.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nicks
 *
 */
public class Utils {
	

	public String loadFileAsString(String ruta) {
		
		StringBuilder constructor = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader (getClass().getResourceAsStream(ruta)));
			String linea;
			while((linea = br.readLine()) != null) {
				constructor.append(linea + "\n");
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return constructor.toString();
	}
	
	public static int parseInt(String numero) {
		
		try {
			return Integer.parseInt(numero);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
