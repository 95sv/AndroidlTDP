package com.example.java.Disparo;

import com.example.java.EntidadesAbstractas.Graficable;
import com.example.java.Visitor.Visitor;
import com.example.java.EntidadesAbstractas.*;

/**
 * Clase que representa el disparo de un personaje.
 * Los disparos se mueven en linea recta y desaparecen cuando impactan contra un objetivo, causandole da�o.
 */

public abstract class Disparo extends Graficable {
	protected float dano;
	protected int velocidad;	
	protected Visitor miVisitor;
	
	
	public Disparo(int x, int y, float dano, int velocidad) {
		super(x, y);
		this.dano = dano;
		this.velocidad = velocidad;
	}
	
	public abstract boolean aceptar(Visitor v);
	
	
	public float getDano() {
		return dano;
	}
	
	public abstract void mover();
	
}
