package com.example.java.Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.example.java.Tablero.Tablero;
import com.example.java.Torres.TorrePesada;


@SuppressWarnings("serial")
public class BotonTorrePesada extends BotonComprable {

	//Boton para comprar TorrePesada
	
	public BotonTorrePesada(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Pesada.png")));
       
	}
	
	public void crearComprable(int x, int y) {
		TorrePesada p = new TorrePesada(x,y);
		if (p.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(p);
		}		
	}
}
