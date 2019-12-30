package com.example.java.Disparo;

import com.example.java.EntidadesAbstractas.Entidad;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorDisparoAliado;
import com.example.java.Mapa.Mapa;

/**
 * Un tipo de disparo que solo es lanzado por las torres controlados por el jugador.
 * Estos disparos solo afectan a los enemigos del jugador
 */

public abstract class DisparoAliado extends Disparo {
	
	public DisparoAliado(int x, int y, float dano, int velocidad) {
		super(x, y, dano, velocidad);
		miVisitor = new VisitorDisparoAliado(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void mover() {
		Entidad e;
		if (x/Mapa.PIXEL>=0) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda donde esta
		}
		else {
			if (x<-Mapa.PIXEL) {
				Tablero.getInstance().eliminar(this);
			}			
			e = null;
		}
		if (e!=null) {
			if (e.aceptar(miVisitor)) { //Se visita la entidad de la celda que est� "pisando" el disparo
				Tablero.getInstance().eliminar(this);	
			}
			else {
				if (x/Mapa.PIXEL+1<Mapa.MAX_ANCHO) { 
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda anterior
				}
				else {
					e = null;
				}
				if (e!=null && e.aceptar(miVisitor)) { //Se visita la entidad de la celda anterior en caso de que se haya pasado de largo el disparo
					Tablero.getInstance().eliminar(this); 
				}
				else {
					x-=velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
				}				
			}
		}
		else {
			x-=velocidad;
			jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		}
	}
	
}
