package com.example.java.Mapa;

import java.util.Random;

import javax.swing.ImageIcon;

import com.example.java.Hilos.HiloTiempo;
import com.example.java.Objeto.Agua;
import com.example.java.Objeto.Piedra;
import com.example.java.Tablero.Tablero;

 //Mapa que representa el segundo nivel del juego.

public class Nivel2 extends Mapa {

	public Nivel2() {
		super();
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Fondo2.jpg"));			
		Random rnd = new Random();	
		int x;
		int y;
		int lago = 0;
		int piedra = 0;
		while (lago<1) {
			x = rnd.nextInt(6) + 2; //Entre 2 y 7
			y = rnd.nextInt(6);
			if (celdas[x][y].getEntidad()==null) {				
				Agua l = new Agua(x*PIXEL, y*PIXEL);
				lago++;
				celdas[x][y].setEntidad(l);
				Tablero.getInstance().dibujarObjeto(l);
				HiloTiempo hl = new HiloTiempo(l, 30);
				hl.start();
			}			
		}
		while (piedra<2) {
			x = rnd.nextInt(5) + 3; //Entre 3 y 7
			y = rnd.nextInt(6);
			if (celdas[x][y].getEntidad()==null) {
				Piedra p = new Piedra(x*PIXEL, y*PIXEL);
				piedra++;
				celdas[x][y].setEntidad(p);
				Tablero.getInstance().dibujarObjeto(p);
			}
		}
	}
	
	public Mapa cambiarNivel(boolean completado) {
		if (completado) {
			return null;
		}
		else {
			return new Nivel2();
		}
	}

}
