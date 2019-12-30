package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpInstantaneo;
import com.example.java.Tablero.Tablero;
import com.example.java.Mapa.Mapa;

 //Power-up que destruye los enemigos de la fila donde est� ubicado
 
 public class Bomba extends PowerUpInstantaneo {
	

	public Bomba(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Bomba2.png"));
		jl = new LabelPowerUpInstantaneo(this, icon);
		jl.addMouseListener(new UsarPowerUpInstantaneoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public void efecto() {
		Tablero.getInstance().eliminarEnemigos(y);
	}

}
