package com.iman.gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.iman.MyTableModel;
import com.iman.Table;
import com.iman.User;


public class ListOfFilesFrame extends JFrame {
	private Table table;
	public ListOfFilesFrame(User user){
		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);
		table = new Table(new MyTableModel(user));
		add(table,BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
