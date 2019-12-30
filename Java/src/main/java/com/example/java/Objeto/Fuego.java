package com.example.java.Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Mapa.Mapa;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorFuego;


  //Obst�culo comprable temporal que da�a al enemigo mas cercano. 
 
public class Fuego extends ObjetoComprable {
	
	private float dano;

	public Fuego(int x, int y) {
		super(x, y, 20);
		dano = 10;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Fuego.gif"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorFuego(this);
	}
	
	public float getDano() {
		return dano;
	}

	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

}
