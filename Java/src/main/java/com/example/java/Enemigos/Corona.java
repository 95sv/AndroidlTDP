package com.example.java.Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Mapa.Mapa;
import com.example.java.Visitor.VisitorEnemigoCerca;

public class Corona extends EnemigoCerca {

	 //Crea un enemigo Corona
	
	public Corona(int x, int y) {
		super(x, y, 20, 5, 8, 10);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Corona.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/CoronaAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Corona.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
		miVisitor = new VisitorEnemigoCerca(this);
	}

}
