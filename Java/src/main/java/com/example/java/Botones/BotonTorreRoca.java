package com.example.java.Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.example.java.Tablero.Tablero;
import com.example.java.Torres.TorreRoca;


@SuppressWarnings("serial")
public class BotonTorreRoca extends BotonComprable {
	
	//Boton para comprar TorreRoca
	
	public BotonTorreRoca(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreRoca.png")));
  
	}	
	
	public void crearComprable(int x, int y) {
		TorreRoca a = new TorreRoca(x, y);
		if (a.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(a);
		}		
	}	
}
