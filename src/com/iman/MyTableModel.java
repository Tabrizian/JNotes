package com.iman;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	private File[] goodFiles;
	private User user;
	public MyTableModel(User user) {
		this.user = user;
		File f = new File("data");
		goodFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(user.getUsername());
			}
		});

	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return goodFiles.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					goodFiles[rowIndex]));
			Note note = (Note) in.readObject();
			in.close();
			switch (columnIndex) {
			case 0:
				return note.getId();
			case 1:
				return note.getTitle();
			case 2:
				if(note.getText().length()> 10)
				return note.getText().substring(0, 10);
				else
					return note.getText();
			case 3:
				return note.getDate();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Note getRowAt(int rowIndex){

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					goodFiles[rowIndex]));
			Note note = (Note) in.readObject();
			in.close();
			return note;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void refresh(){
		File f = new File("data");
		goodFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(user.getUsername());
			}
		});
		fireTableDataChanged();
	}

}
