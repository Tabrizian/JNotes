package com.iman.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.iman.User;

public class ManagementFrame extends JFrame {

	private static ManagementFrame instance = null;

	private ManagementFrame(User user) {

		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);

		add(new ManagementPanel(user), BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static ManagementFrame getManagementFrame(User user) {
		if (instance == null)
			instance = new ManagementFrame(user);
		return instance;
	}
	
	public void delete(){
		dispose();
		instance = null;
	}
}
