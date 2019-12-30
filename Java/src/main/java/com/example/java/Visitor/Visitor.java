package com.example.java.Visitor;

import com.example.java.Disparo.DisparoAliado;
import com.example.java.Disparo.DisparoEnemigo;
import com.example.java.Enemigos.EnemigoCerca;
import com.example.java.Enemigos.EnemigoLejos;
import com.example.java.Objeto.Agua;
import com.example.java.Objeto.Barricada;
import com.example.java.Objeto.Fuego;
import com.example.java.Objeto.Piedra;
import com.example.java.Objeto.Trampa;
import com.example.java.Objeto.Veneno;
import com.example.java.Torres.Torre;

public abstract class Visitor {
	public abstract boolean visit(Torre t);
	
	public abstract boolean visit(DisparoEnemigo d);
	
	public abstract boolean visit(DisparoAliado d);
	
	public abstract boolean visit(EnemigoCerca e);
	
	public abstract boolean visit(EnemigoLejos e);
	
	public abstract boolean visit(Piedra p);
	
	public abstract boolean visit(Agua a);
	
	public abstract boolean visit(Fuego f);
	
	public abstract boolean visit(Barricada b);
	
	public abstract boolean visit(Trampa t);
	
	public abstract boolean visit(Veneno v);
	
	
	
}
