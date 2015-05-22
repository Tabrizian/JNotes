package com.iman.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.iman.MyTableModel;
import com.iman.Note;
import com.iman.Table;
import com.iman.User;

public class ListOfFilesFrame extends JFrame {
	private Table table;
	private JToolBar toolbar;
	private JButton show;
	private JButton delete;
	private MyTableModel model;
	private JButton back;

	public ListOfFilesFrame(User user) {

		toolbar = new JToolBar() {
			@Override
			protected void addImpl(Component comp, Object constraints, int index) {
				super.addImpl(comp, constraints, index);
				if (comp instanceof JButton) {
					((JButton) comp).setOpaque(false);
					((JButton) comp).setBorderPainted(false);
				}
			}
		};
		back = new JButton(makeGoodIcon("pics/undo.png"));
		show = new JButton(makeGoodIcon("pics/monitor.png"));
		delete = new JButton(makeGoodIcon("pics/delete.png"));

		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					Note note = model.getRowAt(row);
					EditingFrame.getEditingFrame(note);
					dispose();
				}
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					Note note = model.getRowAt(row);
					note.delete();
					model.refresh();
				}
			}

		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagementFrame.getManagementFrame(user);

			}
		});

		toolbar.add(show);
		toolbar.add(delete);
		toolbar.addSeparator();
		toolbar.add(back);
		toolbar.setFloatable(false);

		table = new Table(model = new MyTableModel(user));

		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);
		add(table, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private ImageIcon makeGoodIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image newImage = img.getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon good = new ImageIcon(newImage);
		return good;
	}
}
