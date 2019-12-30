package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpTiempo;
import com.example.java.Mapa.Mapa;

 //Power-up que hace invulnerable al peronsaje que lo afecta.
 
public class Escudo extends PowerUpTiempo {
	
	
	public Escudo(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Escudo.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}

	public float getDano(float dano) {
		return dano;
	}

	public int getVelocidad(int vel) {
		return vel;
	}

	public float recibirDano(float dano) {
		return 0;
	}

}
