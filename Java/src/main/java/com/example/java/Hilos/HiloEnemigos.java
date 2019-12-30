package com.example.java.Hilos;

import com.example.java.Tablero.*;

 // Hilo que controla las acciones de los enemigos.

public class HiloEnemigos extends Thread { 
	
	private boolean gameOver;
	private int frozen;

	
	public void gameOver() {
		gameOver = true;
	}
	
	
	// Esta operaci�n se llama cuando se quiere "pausar" el hilo. La operaci�n run() sigue ejecut�ndose,pero no va a realizar ninguna acci�n mientras el hilo est� "pausado".
	public void frozen(int seg) {
		frozen = seg;
	}
	
	public void run() {
		gameOver = false;
		while(!gameOver){
			try {
				if (frozen>0) {
					Thread.sleep(1000);
					frozen--;
				}
				else {
					Thread.sleep(125);
					Tablero.getInstance().moverEnemigos();
				}				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
