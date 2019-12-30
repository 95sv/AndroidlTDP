package com.example.java.Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import com.example.java.Tablero.Tablero;
import com.example.java.Torres.TorreArena;



@SuppressWarnings("serial")
public class BotonTorreArena extends BotonComprable {
	
	//Boton para comprar TorreArena
	
	public BotonTorreArena(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreArena.png")));
	}
	
	public void crearComprable(int x, int y) {
		TorreArena b = new TorreArena(x, y);
		if (b.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(b);
		}		
	}
}