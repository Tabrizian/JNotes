package com.iman.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.iman.Note;

public class SearchEngine {
	private Note[] notes;

	public SearchEngine() {
		File f = new File("data");
		File[] goodFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !name.endsWith(".txt");
			}
		});
		notes = new Note[goodFiles.length];
		int i = 0;
		for (File file : goodFiles) {

			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(file));
				Note note;
				note = (Note) in.readObject();
				in.close();
				notes[i] = note;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			i++;
		}
	}

	public ArrayList<Note> search1(String author) {
		ArrayList<Note> result = new ArrayList<>();
		for (Note note : notes) {
			if (note.getUser().getUsername().equals(author))
				result.add(note);
		}
		return result;
	}

	public ArrayList<Note> search2(Date date) {
		ArrayList<Note> result = new ArrayList<>();
		for (Note note : notes) {
			GregorianCalendar gc1 = new GregorianCalendar();
			gc1.setTime(date);
			GregorianCalendar gc2 = new GregorianCalendar();
			gc2.setTime(note.getDate());
			
			DateFormat df = DateFormat.getDateInstance();
			String s1 = df.format(gc1.getTime());
			String s2 = df.format(gc2.getTime());
			if(s1.equals(s2)){
				result.add(note);
			}
		}
		return result;
	}

	public ArrayList<Note> search3(String title) {
		ArrayList<Note> result = new ArrayList<>();
		for (Note note : notes) {
			if (note.getTitle().equals(title))
				result.add(note);
		}
		return result;
	}

	public ArrayList<Note> search4(String keyword) {
		String[] keywords = keyword.split(",");
		ArrayList<Note> result = new ArrayList<>();

		if (keywords.length == 1) {
			for (Note note : notes) {
				String[] source = note.getKeywords();
				for (String string : source) {
					if (string.equals(keyword))
						result.add(note);
				}
			}
		}
		return result;

	}

}
