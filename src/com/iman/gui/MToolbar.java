package com.iman.gui;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.iman.Note;
import com.iman.User;

public class MToolbar extends JToolBar {

	private JButton add;
	private JButton search;
	private JButton manage;
	private JButton exit;

	public MToolbar(User user) {
		add = new JButton(makeGoodIcon("pics/Add-01.png"));
		search = new JButton(makeGoodIcon("pics/Magnifier-01.png"));
		manage = new JButton(makeGoodIcon("pics/Settings-01.png"));
		exit = new JButton(makeGoodIcon("pics/Power-02.png"));

		ActionListener listenerAdd = (ActionEvent e) -> {
			ManagementFrame.getManagementFrame(user).delete();
			EditingFrame.getEditingFrame(user);
		};

		add.addActionListener(listenerAdd);

		ActionListener listenerManage = (ActionEvent e) -> {
			new ListOfFilesFrame(user);
			ManagementFrame.getManagementFrame(user).delete();
		};
		manage.addActionListener(listenerManage);

		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagementFrame.getManagementFrame(user).delete();
				new SearchFrame();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagementFrame.getManagementFrame(user).delete();
				MainFrame.getMainFrame();
			}
		});
		setOrientation(VERTICAL);
		
		
		setFloatable(false);

		add(add);
		add(search);
		add(manage);
		add(exit);
		setOpaque(false);

	}

	private ImageIcon makeGoodIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image newImage = img.getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon good = new ImageIcon(newImage);
		return good;
	}

	@Override
	protected void addImpl(Component comp, Object constraints, int index) {
		super.addImpl(comp, constraints, index);
		if (comp instanceof JButton) {
			((JButton) comp).setOpaque(false);
			((JButton) comp).setBorderPainted(false);
		}
	}

}
