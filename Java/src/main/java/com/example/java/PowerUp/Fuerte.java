package com.example.java.PowerUp;

import javax.swing.ImageIcon;

import com.example.java.Botones.LabelPowerUpTiempo;
import com.example.java.Mapa.Mapa;


 //Power-up que hace que el personaje afectado haga mas da�o.
 
public class Fuerte extends PowerUpTiempo {

	
	public Fuerte(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Fuerza.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDano(float dano) {
		return dano*1.5f;
	}

	public int getVelocidad(int vel) {
		return vel;
	}
	
	public float recibirDano(float dano) {
		return dano;
	}

}
