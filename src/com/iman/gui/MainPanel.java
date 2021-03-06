package com.iman.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.iman.UsersDataBase;

public class MainPanel extends JPanel {

	private JTextField username;
	private JPasswordField password;
	private JLabel passwordLbl;
	private JLabel usernameLbl;
	private GridBagConstraints gc;
	private Image img;
	private JButton login;
	private JButton signup;
	private JLabel loginLabel;

	public MainPanel() {

		username = new JTextField(10);
		password = new JPasswordField(10);
		passwordLbl = new JLabel("Password: ");
		usernameLbl = new JLabel("Username: ");

		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Arial", Font.BOLD, 45));
		loginLabel.setForeground(Color.WHITE);
		login = new JButton("Sign in");
		signup = new JButton("Signup");

		usernameLbl.setForeground(Color.WHITE);
		passwordLbl.setForeground(Color.WHITE);

		setLayout(new GridBagLayout());

		gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0.5;
		add(loginLabel, gc);

		gc.weighty = 0.75;
		gc.gridx = 0;
		gc.gridy = 1;
		add(usernameLbl, gc);

		gc.weighty = 0.75;
		gc.gridx = 1;
		gc.gridy = 1;
		add(username, gc);

		gc.weighty = 0.75;
		gc.gridx = 0;
		gc.gridy = 2;
		add(passwordLbl, gc);

		gc.weighty = 0.75;
		gc.gridx = 1;
		gc.gridy = 2;
		add(password, gc);

		gc.weighty = 0.75;
		gc.gridx = 1;
		gc.gridy = 3;
		add(login, gc);

		gc.weighty = 0.75;
		gc.gridx = 0;
		gc.gridy = 3;
		add(signup, gc);

		ActionListener listenerLogin = (ActionEvent e) -> {
			if (UsersDataBase.getUsersDataBase().checkValidity(
					username.getText(), new String(password.getPassword()))) {
				MainFrame.getMainFrame().delete();
				ManagementFrame.getManagementFrame(UsersDataBase
						.getUsersDataBase().getUser(username.getText()));
			}

		};

		ActionListener listenerSignup = (ActionEvent e) -> {

			MainFrame.getMainFrame().delete();
			SignupFrame.getSignupFrame();
		};

		login.addActionListener(listenerLogin);
		signup.addActionListener(listenerSignup);
		img = getToolkit().getImage("pics/blue_and_red.jpg");
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}

}
