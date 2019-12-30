package com.example.java.Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.example.java.Disparo.DisparoTierra;
import com.example.java.Mapa.Mapa;
import com.example.java.Tablero.Tablero;
import com.example.java.Visitor.VisitorEnemigoLejos;

public class Tierra extends EnemigoLejos {

	 // Crea un enemigo Tierra.
	
	public Tierra(int x, int y) {
		super(x, y, 50, 10, 4, 20, 3);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Tierra.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/TierraAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Tierra.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		cooldown = 0;
		addLifeBar();
		addPUEffect();
		miVisitor = new VisitorEnemigoLejos(this);
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, miPU.getDano(dano), miPU.getVelocidad(velocidad*2)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, dano, velocidad*2));
		}
		
	}

}
