package com.example.java.Visitor;

import com.example.java.Disparo.DisparoAliado;
import com.example.java.Disparo.DisparoEnemigo;
import com.example.java.Enemigos.EnemigoCerca;
import com.example.java.Enemigos.EnemigoLejos;
import com.example.java.Hilos.HiloVeneno;
import com.example.java.Objeto.Agua;
import com.example.java.Objeto.Barricada;
import com.example.java.Objeto.Fuego;
import com.example.java.Objeto.Piedra;
import com.example.java.Objeto.Trampa;
import com.example.java.Objeto.Veneno;
import com.example.java.Torres.Torre;

public class VisitorEnemigoCerca extends Visitor {
	protected EnemigoCerca e;

	public VisitorEnemigoCerca(EnemigoCerca e) {
		this.e = e;
	}

	public boolean visit(Torre t) {
		t.recibirDano(e.getDano());
		return true;
	}

	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	public boolean visit(DisparoAliado d) {
		e.recibirDano(d.getDano());
		return true;
	}

	public boolean visit(EnemigoCerca e) {
		return false;
	}

	public boolean visit(EnemigoLejos e) {
		return false;
	}

	public boolean visit(Piedra p) {
		p.recibirDano(e.getDano());
		return true;
	}

	public boolean visit(Agua a) {

		return false;
	}

	public boolean visit(Fuego f) {
		e.recibirDano(f.getDano());
		return false;
	}

	public boolean visit(Barricada b) {

		b.recibirDano(e.getDano());
		return true;
	}

	public boolean visit(Veneno v) {
		HiloVeneno hv = new HiloVeneno();
		hv.start();
		v.morir();
		return false;
	}

	public boolean visit(Trampa t) {
		e.morir();
		t.morir();
		return false;
	}
}
