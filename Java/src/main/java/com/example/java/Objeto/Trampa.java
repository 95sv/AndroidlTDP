package com.example.java.Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Visitor.Visitor;
import com.example.java.Visitor.VisitorTrampa;
import com.example.java.Mapa.Mapa;


 // Objeto comprable que destruye el primer enemigo que lo toca.
 
public class Trampa extends ObjetoComprable {
	
	
	public Trampa(int x, int y) {
		super(x, y, 60);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Trampa.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorTrampa(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	


}
