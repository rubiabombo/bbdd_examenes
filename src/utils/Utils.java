package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Utils {
	
	public static void main(String args[]) {
		int num = Utils.obtenerNumeroAzar(10, 20);
		System.out.println(num);
	}

	/**
	 * Método que obtiene y devuelve un número al azar, entre 0 y 100.
	 * 
	 * @return Número generado al azar entre 0 y 100
	 */
	public static int obtenerNumeroAzar() {
		return (int) Math.round(Math.random() * 100);
	}

	/**
	 * 
	 * @param min Límite inferior de generación del número al azar
	 * @param max Límite superior de generación del número al azar
	 * @return Número generado al azar entre dos límites.
	 */
	public static int obtenerNumeroAzar(int min, int max) {
		return (int) Math.round(Math.random() * (max - min)) + min;
	}

	/**
	 * Obtiene un número entero introducido por el usuario, por el método de
	 * InputStreamReader
	 * 
	 * @return Número entero introducido por el usuario.
	 */
	public static int obtenerEnteroPorInputStreamReader() {
		int numero = 0;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			numero = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numero;
	}

	/**
	 * Obtiene un número entero a través de un objeto Scanner
	 * 
	 * @return Número entero introducido por el usuario.
	 */
	public static int obtenerEnteroPorScanner() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	/**
	 * Obtiene un número entero a través de un JOptionPane
	 * 
	 * @return Número entero introducido a través de un JOptionPane.
	 */
	public static int obtenerEnteroPorJOptionPaneConDescripcion(String desc) {
		String str = JOptionPane.showInputDialog(desc);
		int numEntero = Integer.parseInt(str);
		return numEntero;
	}
	
	public static String obtenerStringPorJOptionPaneConDescripcion(String desc) {
		String str = JOptionPane.showInputDialog(desc);
		return str;
	}
	
	
	public static float obtenerFloatPorJOptionPaneConDescripcion(String desc) {
		String str = JOptionPane.showInputDialog(desc);
		float num = Float.parseFloat(str);
		return num;
	}

	public static int obtenerEnteroPorJOptionPaneEntreLimitesYDescripcion(int min, int max, String desc) {
		
		int numEntero;
		do {
			numEntero = Utils.obtenerEnteroPorJOptionPaneConDescripcion(desc);
		} while (numEntero <= min || numEntero >= max);
		
		return numEntero;

	}

	public static int obtenerEnteroConDescripcion(String desc) {
		System.out.println(desc);
		int num = obtenerEnteroPorScanner();
		return num;
	}

	/**
	 * 
	 * @return Número entero introducido por el usuario
	 */
	public static int obtenerEntero() {
		return obtenerEnteroPorScanner();
	}
	
	public static Date parseoFecha(String fechaSinParseo) {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

		String fecha = fechaSinParseo;

		Date fechaParseada = null;

		try {
			fechaParseada = formatoFecha.parse(fecha);
		} catch (ParseException e) {
			System.out.println("Error en el parseo de la fecha");
			e.printStackTrace();
		}
		
		return fechaParseada;
		
		
	}

}
