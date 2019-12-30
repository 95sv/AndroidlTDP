package com.example.java.Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.example.java.Objeto.Trampa;
import com.example.java.Tablero.Tablero;


@SuppressWarnings("serial")
public class BotonTrampa extends BotonComprable {

	//Boton para comprar Trampa
	
	public BotonTrampa(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Trampa.png")));
       
	}	
	
	public void crearComprable(int x, int y) {
		Trampa t = new Trampa(x, y);
		if (t.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(new Trampa(x, y));	
		}			
	}
}
