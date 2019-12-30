package com.example.java.Torres;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Disparo.DisparoRoca;
import com.example.java.Mapa.Mapa;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.Visitor;

public class TorreRoca extends Torre {

	
	//Crea una TorreRoca
	
	public TorreRoca(int x, int y) {
		super(x, y, 30, 15, 10, 35);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreRoca.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		torreListener tl = new torreListener(this);
		jl.addMouseListener(tl);
		addLifeBar();
		addPUEffect();
	}

	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

	protected void crearDisparo() {
		if (miPU != null) {
			Tablero.getInstance().crearDisparo(new DisparoRoca(x, y, miPU.getDano(dano), miPU.getVelocidad(velocidad)));
		} else {
			Tablero.getInstance().crearDisparo(new DisparoRoca(x, y, dano, velocidad));
		}
	}
	
	public class torreListener extends MouseAdapter{
		protected Torre miTorre;
		
		public torreListener(Torre miTorre) {
			this.miTorre = miTorre;
		}
		
		public void mouseClicked(MouseEvent e) {
			miTorre.getLabel().setBorder(BorderFactory.createLineBorder(Color.RED));
			Tablero.getInstance().vender(miTorre);
		}
	}


}
