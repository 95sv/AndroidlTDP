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

public class VisitorTorre extends Visitor{
	protected Torre miTorre;
	
	public VisitorTorre(Torre t) {
		miTorre = t;
	}
	
	@Override
	public boolean visit(Torre t) {
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		miTorre.recibirDano(d.getDano());
		if(miTorre.getVida()<= 0) {
			miTorre.morir();
		}
		return true;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		return false;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		return true;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		return true;
	}

	@Override
	public boolean visit(Piedra p) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
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
