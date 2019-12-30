package com.example.java.Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Mapa.Mapa;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorPiedra;


 //Obst�culo que impide el paso de los enemigos. Puede ser destruido por ataques.

public class Piedra extends Objeto {
	
	private float vida;
	

	public Piedra(int x, int y) {
		super(x, y);
		vida = 25;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Objetos/Piedra.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorPiedra(this);
	}
	
	public float getVida() {
		return vida;
	}
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void recibirDano(float dano) {
		vida -= dano;
		if (vida <= 0) {
			morir();
		}
	}

	
}
