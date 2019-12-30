package com.example.java.Enemigos;

import java.util.Random;
import javax.swing.Icon;
import com.example.java.EntidadesAbstractas.Personaje;
import com.example.java.Tablero.Tablero;


 //Un tipo de personaje que es enemigo del jugador.
 
public abstract class Enemigo extends Personaje {
	
	protected Icon atacar;
	protected Icon mover;
	

	public Enemigo(int x, int y, float maxVida, float dano, int velocidad, int valor) {
		super(x, y, maxVida, dano, velocidad, valor);
	}
		
	public void morir() {
		Tablero.getInstance().eliminar(this);
		//Cuando muere un enemigo, hay una posibildiad de que suelte
		//un power-up en la celda donde murio
		Random rnd = new Random();
		int r = rnd.nextInt(100);
		if (r<15) {
			Tablero.getInstance().dropPowerUp(x, y);
		}	
		x = -1; //Esto evita que trate de actualizar su posicion en el mapa
		y = -1;
	}
	
	public void visit() {
		
	}
	
}
