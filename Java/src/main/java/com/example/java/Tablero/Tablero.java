package com.example.java.Tablero;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.example.java.Disparo.*;
import com.example.java.Enemigos.Enemigo;

import com.example.java.Enemigos.*;
import com.example.java.EntidadesAbstractas.Entidad;
import com.example.java.Gui.Gui;
import com.example.java.Hilos.*;
import com.example.java.Mapa.*;
import com.example.java.Objeto.Objeto;
import com.example.java.Objeto.ObjetoComprable;
import com.example.java.PowerUp.*;
import com.example.java.Torres.Torre;
import com.example.java.EntidadesAbstractas.Personaje;


 //Clase que maneja toda la l�gica del juego. Debido a que aplica el patron Singleton, solo puede existir una instancia de tablero.
 
public class Tablero {
	
	private static Tablero instance;
	private static int MONEDAS_INCIAL = 2000;
	
	private Mapa mapa;
	private Collection<Torre> jugadores; 
	private Collection<Enemigo> enemigos;
	private Collection<Disparo> disparos;
	private Gui gui;
	
	private PowerUpTiempo puActual;
	
	private int puntaje;
	private int monedas;
	
	private HiloTorres hj;
	private HiloEnemigos he;
	private HiloDisparos hd;
	private HiloOleadas ho;
	
	
	private Tablero() {
		jugadores = new ConcurrentLinkedDeque<Torre>();
		enemigos = new ConcurrentLinkedDeque<Enemigo>();
		disparos = new ConcurrentLinkedDeque<Disparo>();		
		
		monedas = MONEDAS_INCIAL;
	}
	
	
	public static Tablero getInstance() {
		if (instance==null) {
			instance = new Tablero();
		}
		return instance;
	}
	

	public void crearMapa() {
		mapa = new Nivel1();
		gui.setBackground(mapa);
	}
	
	
	public void crearHilos() {
		hj = new HiloTorres();
		hj.start();
		he = new HiloEnemigos();	
		he.start();
		hd = new HiloDisparos();
		hd.start();	
		ho = new HiloOleadas();
		ho.start();
	}
	
	
	public void setGUI(Gui gui) {
		this.gui = gui;
	}
	
	
	public void cambiarNivel(boolean completado) {
		puntaje = 0;
		monedas = MONEDAS_INCIAL;
		gui.actualizarPuntaje();
		mapa = mapa.cambiarNivel(completado);
		gui.setBackground(mapa);
		if (mapa!=null) {
			crearHilos();
		}
		else {
			gameOver(true);
		}
	}
	
	
	public void gameOver(boolean ganaste) {
		jugadores = new ConcurrentLinkedDeque<Torre>();
		enemigos = new ConcurrentLinkedDeque<Enemigo>();
		disparos = new ConcurrentLinkedDeque<Disparo>();
		he.gameOver();
		hj.gameOver();
		hd.gameOver();	
		ho.gameOver();
		gui.gameOver(ganaste);
		
	}
	
	
	public void moverJugadores() {
		for (Personaje j : jugadores) {
			j.accion();		
		}
	}
	
	
	public void moverEnemigos() {	
		for (Enemigo e : enemigos) {
			e.accion();
			mapa.setEntidad(e); //Actualiza la posicion en el mapa logico en caso de que se haya movido
		}		
	}	
	
	
	public void moverDisparos() {
		gui.repaint();
		for (Disparo d : disparos) {
			d.mover();			
		}
	}		
	
	
	public void crearJugador(Torre j) {
		j.setPowerUp(puActual);
		jugadores.add(j);
		mapa.setEntidad(j);
		gui.crearGrafico(j, 1);
		monedas -= j.getValor();
	}

	
	public Enemigo crearEnemigo() {
		Random rnd = new Random();
		int fila = rnd.nextInt(6);
		int r = rnd.nextInt(100);		
		Enemigo e;
		if (r>=0 && r<25) {
			e = new Corona(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=25 && r<45) {
			e = new Hielo(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=45 && r<65) {
			e = new Tierra(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=65 && r<85) {
			e = new Verde(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=85 && r<95) {
			e = new Fantasma(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else {
			e = new Magma(-Mapa.PIXEL, fila*Mapa.PIXEL);
		}
		if (rnd.nextInt(9)==0) {
			e.setPowerUp(new Escudo(-Mapa.PIXEL, fila*Mapa.PIXEL));
			HiloPowerUp hpu = new HiloPowerUp(10, e);
			hpu.start();
		}
		enemigos.add(e);
		gui.crearGrafico(e, 1);
		return e;
	}	
	
	
	public void crearDisparo(Disparo d) {
		disparos.add(d);
		gui.crearGrafico(d, 2);
	}
	
	
	public void crearObjeto(ObjetoComprable oc) {
		mapa.setEntidad(oc);
		gui.crearGrafico(oc, 2);
		monedas -= oc.getCosto();
	}
	
	
	public void eliminar(DisparoEnemigo j) {
		gui.eliminarGrafico(j);
		mapa.eliminarEntidad(j);
		jugadores.remove(j);
	}

	
	public void eliminar(Entidad e) {
		//puntaje += e.getValor();
		//monedas += e.getValor();
		gui.eliminarGrafico(e);
		gui.actualizarPuntaje();
		mapa.eliminarEntidad(e);
		enemigos.remove(e);
	}
	
	
	public void eliminarEnemigos(int fila) {
		Enemigo [] en = new Enemigo[enemigos.size()];
		int i = 0;
		for (Enemigo e : enemigos) {
			if (e.getY()==fila) {
				en[i] = e;
				i++;
			}
		}
		i = 0;
		while (i<en.length && en[i]!=null) {
			eliminar(en[i]);
			i++;
		}
	}
		
	
	public void eliminar(Enemigo d) {
		disparos.remove(d);		
		gui.eliminarGrafico(d);
	}
	
	
	public void dibujarObjeto(Objeto o) {
		gui.crearGrafico(o, 1);
	}
	
	
	public void eliminarObjeto(Objeto o) {
		mapa.eliminarEntidad(o);
		gui.eliminarGrafico(o);
	}
	
	
	public int getPuntaje() {
		return puntaje;		
	}
	
	
	public int getMonedas() {
		return monedas;
	}
	
	
	public Entidad getEntidad(int x, int y) {
		return mapa.getEntidad(x, y);
	}
	
	
	public void setPowerUp(PowerUpTiempo pu) {
		puActual = pu;
		for (Personaje j : jugadores) {
			j.setPowerUp(puActual);
		}
	}
	
	public void dropPowerUp(int x, int y) {
		Random rnd = new Random();
		int r = rnd.nextInt(100);
		PowerUp pu;
		if (r>=0 && r<15) {
			pu = new Velocidad(x, y);
		}
		else if (r>=15 && r<30) {
			pu = new Fuerte(x, y);
		}
		else if (r>=45 && r<60) {
			pu = new Bomba(x, y);
		}
		else if (r>=60 && r<75) {
			pu = new Congelar(x, y);
		}
		else if (r>=75 && r<85) {
			pu = new Vida(x, y);
		}
		else {
			pu = new Escudo(x, y);
		}
		gui.crearGrafico(pu, 2);
	}
	
	
	public void eliminarPU(PowerUp pu) {
		gui.eliminarGrafico(pu);
	}
	
	
	public boolean hayPowerUpActivo() {
		return puActual!=null;
	}
	
	
	public void recuperarVidaJugadores() {
		for (Personaje j : jugadores) {
			j.recuperarVida();
		}
	}
	
	
	public void congelarEnemigos(int seg) {
		he.frozen(seg);
		ho.frozen(seg);
	}
	
	
	public void danarEnemigos(float dano) {
		for (Enemigo e : enemigos) {
			e.recibirDano(dano);
		}
	}
	
	
	public boolean hayEnemigos() {
		return !enemigos.isEmpty();
	}
	
	
	public void vender(Torre t) {
		monedas += t.getValor();
		gui.venderTorre(t);
	}

	public void eliminar(DisparoAliado disparoAliado) {
		gui.eliminarGrafico(disparoAliado);
		mapa.eliminarEntidad(disparoAliado);
		jugadores.remove(disparoAliado);
	}
}
