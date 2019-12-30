package com.example.java.Botones;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.example.java.PowerUp.PowerUpInstantaneo;



@SuppressWarnings("serial")
public class LabelPowerUpInstantaneo extends JLabel {
	
	private PowerUpInstantaneo miPU;
	
	
	public LabelPowerUpInstantaneo(PowerUpInstantaneo pu, Icon i) {
		super(i);
		miPU = pu;
	}
	
	
	public PowerUpInstantaneo getPU() {
		return miPU;
	}

}
