package com.iman.gui;
import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

import com.iman.Note;
import com.iman.User;

public class EditingFrame extends JFrame {

	private JTextPane editingPane;
	private JToolBar toolbar;
	private static EditingFrame instance = null;
	private static User user;
	private EditingFrame(User user) {
		super();
		setLayout(new BorderLayout());
		
		this.user = user;
		editingPane = new JTextPane();

		toolbar = new EToolbar(user,null);

		add(toolbar, BorderLayout.NORTH);
		add(editingPane, BorderLayout.CENTER);

		setUndecorated(true);
		setSize(400, 600);
		setLocation(400, 50);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private EditingFrame(Note note) {
		super();
		setLayout(new BorderLayout());

		editingPane = new JTextPane(note.getStyleOfDocument());
		editingPane.setText(note.getText());

		toolbar = new EToolbar(user,note);

		add(toolbar, BorderLayout.NORTH);
		add(editingPane, BorderLayout.CENTER);

		setUndecorated(true);
		setSize(400, 600);
		setLocation(400, 50);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static EditingFrame getEditingFrame(User user) {
		if (instance == null)
			instance = new EditingFrame(user);
		return instance;
	}

	public static EditingFrame getEditingFrame(Note note) {
		if(instance == null){
			instance = new EditingFrame(note);
		}
		return instance;
	}

	public JTextPane getEditingPane() {
		return editingPane;
	}
	
	public void delete(){
		dispose();
		instance = null;
	}

}
