package com.example.java.Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.example.java.Mapa.Mapa;

/**
 * Disparo espec�fico de la torre Control
 */
public class DisparoControl extends DisparoAliado {

	
	public DisparoControl(int x, int y, float dano, int velocidad) {
		super(x, y, dano, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/2.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
