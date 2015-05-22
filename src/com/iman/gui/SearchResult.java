package com.iman.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.iman.Note;

public class SearchResult extends JFrame {

	private JTable results;
	private SearchTableModel model;

	public SearchResult(ArrayList<Note> notes) {
		model = new SearchTableModel(notes);
		results = new JTable(model);
		setLayout(new BorderLayout());
		add(results, BorderLayout.CENTER);

		setSize(400, 400);
		setLocation(400, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
