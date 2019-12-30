package com.example.java.Objeto;

import com.example.java.EntidadesAbstractas.Entidad;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.Visitor;


 //Clase que representa cualquier objeto del mapa que no sea un enemigo o una torre. 

public abstract class Objeto extends Entidad {


	public Objeto(int x, int y) {
		super(x, y);
	}

	public abstract boolean aceptar(Visitor v);
	
	public void morir() {
		Tablero.getInstance().eliminarObjeto(this);
	}

}
