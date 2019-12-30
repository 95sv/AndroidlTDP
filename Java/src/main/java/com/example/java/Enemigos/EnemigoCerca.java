package com.example.java.Enemigos;

import com.example.java.EntidadesAbstractas.Entidad;
import com.example.java.Mapa.Mapa;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.VisitorEnemigoCerca;
import com.example.java.Visitor.Visitor;

 //Un tipo de enemigo que ataca de cerca. El da�o que realiza es por segundo.
 
public abstract class EnemigoCerca extends Enemigo {


	public EnemigoCerca(int x, int y, float maxVida, float dano, int velocidad, int valor) {
		super(x, y, maxVida, dano, velocidad, valor);
		miVisitor = new VisitorEnemigoCerca(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void accion() {
		if (x>=Mapa.PIXEL*Mapa.MAX_ANCHO) {
			Tablero.getInstance().gameOver(false);
		}
		else {
			Entidad e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+1, y/Mapa.PIXEL); //Entidad de la celda siguiente
			if (e!=null) {
				if (e.aceptar(miVisitor)) {
					jl.setIcon(atacar);
				}
				else {
					//jl.setIcon(icon); 
					x+= velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);		
					jl.setIcon(mover);
				}
			}
			else {
				if (miPU!=null) {
					x+= miPU.getVelocidad(velocidad);
				}
				else {
					x+= velocidad;
				}		
				jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);		
				jl.setIcon(mover);
			}
		}		
	}	
}
