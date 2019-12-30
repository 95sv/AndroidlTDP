package com.example.java.Hilos;

import com.example.java.Objeto.Objeto;
import com.example.java.Tablero.Tablero;


 //Hilo que controla la duraci�n de un objeto que existe temporalmente.
 
public class HiloTiempo extends Thread {

	private Objeto obj;
	private int segundos;
	
	public HiloTiempo(Objeto o, int seg) {
		obj = o;
		this.segundos = seg;
	}
	
	public void run() {
		int contador = 0;
		while (contador<segundos) {
			try {
				Thread.sleep(1000);
				contador++;				
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Tablero.getInstance().eliminarObjeto(obj);
	}
	
}
