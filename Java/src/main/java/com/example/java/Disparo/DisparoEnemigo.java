package com.example.java.Disparo;

import com.example.java.EntidadesAbstractas.Entidad;
import com.example.java.Mapa.Mapa;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorDisparoEnemigo;

/**
 * Un tipo de disparo que solo es lanzado por los enemigos. 
 * Estos disparos afectan a las torres del jugador y a algunos obst�culos.
 */

public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int x, int y, float dano, int velocidad) {
		super(x, y, dano, velocidad);
		miVisitor = new VisitorDisparoEnemigo(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void mover() {
		Entidad e;
		if (x/Mapa.PIXEL<=Mapa.MAX_ANCHO) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda donde esta
		}
		else {
			if (x/Mapa.PIXEL>Mapa.MAX_ANCHO) {
				Tablero.getInstance().eliminar(this);
			}
			e = null;
		}
		if (e!=null) {
			if (e.aceptar(miVisitor)) { //Se visita la entidad de la celda que est� "pisando" el disparo
				Tablero.getInstance().eliminar(this);	
			}
			else {
				if (x/Mapa.PIXEL-1>=0) { 
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda anterior
				}
				else {
					e = null;
				}
				if (e!=null && e.aceptar(miVisitor)) { //Se visita la entidad de la celda anterior en caso de que se haya pasado de largo el disparo
					Tablero.getInstance().eliminar(this); 
				}
				else {
					x+=velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
				}				
			}
		}
		else {
			x+=velocidad;
			jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		}
	}

}
