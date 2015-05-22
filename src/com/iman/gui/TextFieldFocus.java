package com.iman.gui;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldFocus implements FocusListener {

	private String good;

	public TextFieldFocus(String good) {
		this.good = good;
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField test = (JTextField) e.getSource();
		if (test.getText().equals(good))
			test.setText("");
			test.setForeground(Color.BLACK);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField test = (JTextField) e.getSource();
		if (test.getText().equals("")){
			test.setForeground(Color.GRAY);
			test.setText(good);
		}
	}

}
