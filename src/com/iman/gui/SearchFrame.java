package com.iman.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.iman.Note;

public class SearchFrame extends JFrame {

	private JComboBox<String> items;
	private JButton search;
	private JTextField text;
	private JLabel label;

	public SearchFrame() {

		super();
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		items = new JComboBox<String>();
		items.addItem("Author");
		items.addItem("Keyword");
		items.addItem("Date");
		items.addItem("Title");

		search = new JButton("Search");
		text = new JTextField(10);
		label = new JLabel("Search by:");

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;
		add(label, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(items, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		add(text, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		add(search, gc);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String value = (String) items.getSelectedItem();
				SearchEngine engine = new SearchEngine();
				ArrayList<Note> notes = null;
				switch (value) {
				case "Author":
					notes = engine.search1(text.getText());
					break;
				case "Keyword":
					notes = engine.search4(text.getText());
					break;
				case "Date":
					try {
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						Date date = df.parse(text.getText());
						notes = engine.search2(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "Title":
					notes = engine.search3(text.getText());
					break;
				default:
					break;
				}
				new SearchResult(notes);
				dispose();
			}
		});

		setSize(300, 150);
		setLocation(400, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
