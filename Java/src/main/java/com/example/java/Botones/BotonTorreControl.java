package com.example.java.Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import com.example.java.Tablero.Tablero;
import com.example.java.Torres.TorreControl;


@SuppressWarnings("serial")
public class BotonTorreControl extends BotonComprable {
	
	//Boton para comprar TorreControl
	
	public BotonTorreControl(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreControl.png")));
       
	}

	public void crearComprable(int x, int y) {
		TorreControl v = new TorreControl(x, y);
		if (v.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(new TorreControl(x, y));
		}		
	}
}
