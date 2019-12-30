package com.example.java.Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Mapa.Mapa;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorBarricada;

 //Obst�culo comprable que impide el paso de los enemigos. Puede ser destruido por ataques.
 
public class Barricada extends ObjetoComprable {

	private float vida;
	
	public Barricada(int x, int y) {
		super(x, y, 15);
		vida = 50;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Barricada.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorBarricada(this);
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
