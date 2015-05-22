package com.iman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.iman.User;

public class ManagementPanel extends JPanel {

	private Image img;
	private JToolBar toolbar;


	public ManagementPanel(User user) {
		img = getToolkit().getImage("pics/blue_and_red.jpg");

		setLayout(new BorderLayout());

		toolbar = new MToolbar(user);

		add(toolbar, BorderLayout.WEST);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}

}
