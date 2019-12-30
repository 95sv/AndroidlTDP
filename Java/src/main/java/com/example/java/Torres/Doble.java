package com.example.java.Torres;

import com.example.java.Disparo.DisparoArena;
import com.example.java.Tablero.Tablero;

/**
 * Clase que representa una de las mitades de la torre doble.
 * Como un objeto representa la mitad de la torre, debe tener una referencia a la otra mitad 
 * para mantener la misma cantidad de vida y que ambas mitades sean destruidas al mismo tiempo.
 */
public abstract class Doble extends Torre {
	
	private Doble mitad;

	public Doble(int x, int y, float maxVida, float dano, int velocidad, int costo) {
		super(x, y, maxVida, dano, velocidad, costo);
	}

	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoArena(x, y, miPU.getDano(dano), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoArena(x, y, dano, velocidad));
		}	
	}
	
	public void setMitad(Doble mitad) {
		this.mitad = mitad;
	}
	
	public void actualizarVida(float vida) {
		this.vida = vida;
		if (this.vida<=0) {
			morir();
		}
	}
	
	public void recibirDano(float dano) {
		super.recibirDano(dano);
		mitad.actualizarVida(vida);
	}
	

}
