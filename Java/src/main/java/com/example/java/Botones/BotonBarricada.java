package com.example.java.Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import com.example.java.Objeto.Barricada;
import com.example.java.Tablero.Tablero;

@SuppressWarnings("serial")
public class BotonBarricada extends BotonComprable {

	//Boton para comprar Barricada
	
	public BotonBarricada(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Barricada.png")));

	}	
	
	public void crearComprable(int x, int y) {
		Barricada b = new Barricada(x, y);
		if (b.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(b);
		}	
	}	
}
