package com.iman.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Date;

import javax.swing.JLabel;
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
		JLabel text = new JLabel(new Date().toString());
		text.setOpaque(false);
		text.setForeground(Color.WHITE);
		add(toolbar, BorderLayout.WEST);
		text.setFont(new Font("Arial", Font.BOLD, 20));
		add(text, BorderLayout.CENTER);

		Runnable runnable = () -> {
			while (true) {
				text.setText(new Date().toString());
				text.repaint();
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();

	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}

}
