package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpInstantaneo;
import com.example.java.Mapa.Mapa;
import com.example.java.Tablero.Tablero;

  //Power-up que congela por un tiempo a los enemigos.

public class Congelar extends PowerUpInstantaneo {

	
	public Congelar(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Hielo.png"));
		jl = new LabelPowerUpInstantaneo(this, icon);
		jl.addMouseListener(new UsarPowerUpInstantaneoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public void efecto() {
		Tablero.getInstance().congelarEnemigos(5);
	}

}
