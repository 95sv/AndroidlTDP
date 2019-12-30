package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpInstantaneo;
import com.example.java.Tablero.Tablero;
import com.example.java.Mapa.Mapa;


 //Power-up que recupera la vida de todas las torres del jugador.
 
public class Vida extends PowerUpInstantaneo {

	
	public Vida(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Vida.png"));
		jl = new LabelPowerUpInstantaneo(this, icon);
		jl.addMouseListener(new UsarPowerUpInstantaneoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public void efecto() {
		Tablero.getInstance().recuperarVidaJugadores();
	}

}
