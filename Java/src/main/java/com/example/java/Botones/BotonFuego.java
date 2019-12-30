package com.example.java.Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.example.java.Hilos.HiloTiempo;
import com.example.java.Objeto.Fuego;
import com.example.java.Tablero.Tablero;


@SuppressWarnings("serial")
public class BotonFuego extends BotonComprable {

	//Boton para comprar Fuego
	
	public BotonFuego(ActionListener al) {// dura 5 segundos
		super(al);
		setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Fuego.gif")));
		
	}

	public void crearComprable(int x, int y) {
		Fuego f = new Fuego(x, y);
		if (f.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(f);
			HiloTiempo ht = new HiloTiempo(f, 5);
			ht.start();
		}
	}
}
