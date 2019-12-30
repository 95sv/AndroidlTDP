package com.example.java.PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.example.java.Botones.LabelPowerUpTiempo;
import com.example.java.Hilos.HiloPowerUp;
import com.example.java.Tablero.Tablero;


 //Un tipo de power-up que tiene un efecto temporal. Cambia el estado del personaje afectado por este power-up.
 
public abstract class PowerUpTiempo extends PowerUp {
	
	
	public PowerUpTiempo(int x, int y) {
		super(x, y);
	}

	
	public abstract float getDano(float dano);
	
	
	public abstract int getVelocidad(int vel);
	
	
	public abstract float recibirDano(float dano);
	
	
	protected class UsarPowerUpTiempoListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			LabelPowerUpTiempo btn = (LabelPowerUpTiempo) e.getSource();
			Tablero.getInstance().setPowerUp(btn.getPU());
			Tablero.getInstance().eliminarPU(btn.getPU());
			new HiloPowerUp(5).start();
		}
	}
	
}
