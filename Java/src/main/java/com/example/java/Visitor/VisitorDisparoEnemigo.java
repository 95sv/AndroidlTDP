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

public class VisitorDisparoEnemigo extends Visitor{
	protected DisparoEnemigo d;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		this.d = d;
	}
	@Override
	public boolean visit(Torre t) {
		t.recibirDano(d.getDano());
		return true;
	}

	
	public boolean visit(DisparoEnemigo d) {
		
		return false;
	}

	
	public boolean visit(DisparoAliado d) {
		
		return false;
	}

	
	public boolean visit(EnemigoCerca e) {
		
		return false;
	}


	public boolean visit(EnemigoLejos e) {
		
		return false;
	}

	@Override
	public boolean visit(Piedra p) {
		p.recibirDano(d.getDano());
		return true;
	}
	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Fuego f) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Barricada b) {
	
		b.recibirDano(d.getDano());
		return true;
	}
	@Override
	public boolean visit(Veneno v) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Trampa t) {
		// TODO Auto-generated method stub
		return false;
	}

}
