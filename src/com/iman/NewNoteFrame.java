package com.iman;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.iman.gui.MainPanel;
import com.iman.gui.TextFieldFocus;

public class NewNoteFrame extends JFrame {

	private JTextField title;
	private JTextField keywords;
	private JButton yes;
	private JButton no;
	private JLabel message;

	public NewNoteFrame() {

		title = new JTextField(10);
		keywords = new JTextField(20);
		yes = new JButton("Yes");
		no = new JButton("No");
		yes.setSize(50, 30);
		no.setSize(50, 30);
		message = new JLabel("Do you want to continue editing?");
		
		keywords.addFocusListener(new TextFieldFocus("keywords seprated with ','"));
		
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;
		add(title, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(keywords, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		add(message, gc);

		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 2;

		add(yes, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		add(no, gc);

		setSize(400, 200);
		setLocation(400, 50);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
