package com.example.java.Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.example.java.Mapa.Mapa;

/**
 * Disparo espec�fco de la torre Roca.
 */

public class DisparoRoca extends DisparoAliado {

	
	public DisparoRoca(int x, int y, float dano, int velocidad) {
		super(x, y, dano, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/4.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
