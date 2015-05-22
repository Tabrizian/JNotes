package com.iman.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.iman.Note;
import com.iman.User;

public class NewNoteFrame extends JFrame {

	private static final long serialVersionUID = 3120579032104273024L;
	private JTextField title;
	private JTextField keywords;
	private JButton yes;
	private JButton no;
	private JLabel message;
	private Note existed = null;

	public NewNoteFrame(User user, Note existed) {

		title = new JTextField(10);
		keywords = new JTextField(20);
		yes = new JButton("Yes");
		no = new JButton("No");
		this.existed = existed;

		yes.setSize(50, 30);
		no.setSize(50, 30);
		message = new JLabel("Do you want to continue editing?");

		title.setForeground(Color.GRAY);
		title.setText("Title");
		title.addFocusListener(new TextFieldFocus("Title"));

		keywords.setForeground(Color.GRAY);
		keywords.setText("keywords seprated with ','");
		keywords.addFocusListener(new TextFieldFocus(
				"keywords seprated with ','"));

		ActionListener yesListener = (ActionEvent e) -> {

			Note note;
			if (existed == null) {
				note = new Note(title.getText(), EditingFrame.getEditingFrame(
						user).getEditingPane(), user, keywords.getText());
				note.continueEditing();

			} else {
				note = existed;
				note.updateNote(title.getText(), EditingFrame.getEditingFrame(
						user).getEditingPane(), user, keywords.getText());
			}
			note.write();
			dispose();
		};
		yes.addActionListener(yesListener);

		ActionListener noListener = (ActionEvent e) -> {
			Note note;
			if (existed == null) {
				note = new Note(title.getText(), EditingFrame.getEditingFrame(
						user).getEditingPane(), user, keywords.getText());
				EditingFrame.getEditingFrame(user).delete();
				ManagementFrame.getManagementFrame(user);
			} else {
				note = existed;
				note.updateNote(title.getText(), EditingFrame.getEditingFrame(
						user).getEditingPane(), user, keywords.getText());
				EditingFrame.getEditingFrame(note).delete();
				ManagementFrame.getManagementFrame(user);
			}
			note.write();
			
			dispose();
		};
		no.addActionListener(noListener);

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
