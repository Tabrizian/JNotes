package com.iman.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class SignupFrame extends JFrame {
	private static SignupFrame instance = null;
	private SignupFrame(){
		super();
		
		setLayout(new BorderLayout());
		
		add(new SignupPanel(),BorderLayout.CENTER);
		
		setSize(300, 300);
		setLocation(400, 50);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static SignupFrame getSignupFrame(){
		if(instance == null)
			instance = new SignupFrame();
		return instance;
	}
	
	public void delete(){
		dispose();
		instance = null;
	}
	
}
