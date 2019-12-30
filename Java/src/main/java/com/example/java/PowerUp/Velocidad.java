package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpTiempo;
import com.example.java.Mapa.Mapa;


 //Power-up que hace a un personaje m�s r�pido el movimiento y/o la velocida de su disparo.
 
public class Velocidad extends PowerUpTiempo {


	public Velocidad(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Velocidad.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDano(float dano) {
		return dano;
	}

	public int getVelocidad(int vel) {
		return vel*2;
	}

	public float recibirDano(float dano) {
		return dano;
	}
	
}
