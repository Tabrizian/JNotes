package com.iman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class Note implements Serializable {

	private int id;
	private String text;
	private StyledDocument styleOfDocument;
	private String title;
	private static int population = 0;
	private Date date;
	private User user;
	private String[] keywords;

	public Note(String title, JTextPane editingPane, User user, String keyword) {
		text = editingPane.getText();
		styleOfDocument = editingPane.getStyledDocument();
		this.title = title;
		this.user = user;
		date = new Date();
		keywords = keyword.split(",");
		try {
			InputStream in = new FileInputStream("data/noteNumber.txt");
			Scanner scanner = new Scanner(in);
			population = scanner.nextInt();
			scanner.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id = population;
		population++;
		try {
			FileWriter writer = new FileWriter("data/noteNumber.txt");
			writer.write(String.valueOf(population));
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public StyledDocument getStyleOfDocument() {
		return styleOfDocument;
	}

	public String getTitle() {
		return title;
	}

	public void write() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(new File("data/" + user.getUsername()
							+ id)));
			out.writeObject(this);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getDate() {
		return date;
	}

	public User getUser() {
		return user;
	}

	public void continueEditing() {
		try {
			InputStream in = new FileInputStream("data/noteNumber.txt");
			Scanner scanner = new Scanner(in);
			population = scanner.nextInt();
			population--;
			scanner.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("data/noteNumber.txt");
			writer.write(String.valueOf(population));
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Note noteExist(String name) {
		File f = new File("data");
		File[] goodFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(name);
			}
		});
		if (goodFiles == null) {
			return null;
		} else {
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(goodFiles[0]));
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
	}

	public void updateNote(String title, JTextPane editingPane, User user,
			String keyword) {
		this.title = title;
		this.text = editingPane.getText();
		this.styleOfDocument = editingPane.getStyledDocument();
		this.keywords = keyword.split(",");
		this.date = new Date();
		this.user = user;

	}

	public String[] getKeywords() {
		return keywords;
	}

	public void delete() {
		File file = new File("data/" + user.getUsername() + id);
		file.delete();
	}

}
