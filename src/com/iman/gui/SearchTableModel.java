package com.iman.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.iman.Note;

public class SearchTableModel extends AbstractTableModel {

	private ArrayList<Note> notes;

	public SearchTableModel(ArrayList<Note> notes) {
		this.notes = notes;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return notes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Note note = notes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return note.getId();
		case 1:
			return note.getTitle();
		case 2:
			if (note.getText().length() > 10)
				return note.getText().substring(0, 10);
			else
				return note.getText();
		case 3:
			return note.getDate();

		}
		return null;
	}

}
