package com.example.java.Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.example.java.Tablero.Tablero;
import com.example.java.Torres.TorreLadrillos;


@SuppressWarnings("serial")
public class BotonTorreLadrillos extends BotonComprable { 
	
	//Boton para comprar TorreLadrillos
	
	public BotonTorreLadrillos(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreLadrillos.png")));
        
	}
	
	public void crearComprable(int x, int y) {
		TorreLadrillos r = new TorreLadrillos(x, y);
		if (r.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(r);
		}
		
	}
}
