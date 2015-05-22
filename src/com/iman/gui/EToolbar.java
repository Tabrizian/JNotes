package com.iman.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.iman.Note;
import com.iman.User;

public class EToolbar extends JToolBar {

	private JButton save;
	private JButton bold;
	private JButton italic;
	private JButton underline;
	private JButton color;
	private JComboBox<String> fonts;
	private JComboBox<Integer> size;
	private User user;

	public EToolbar(User user, Note existed) {

		save = new JButton(makeGoodIcon("pics/save.png"));
		bold = new JButton(makeGoodIcon("pics/font_bold.png"));
		italic = new JButton(makeGoodIcon("pics/font_italic.png"));
		underline = new JButton(makeGoodIcon("pics/font_underline.png"));
		fonts = new JComboBox<>();
		size = new JComboBox<>();
		color = new JButton("Color");
		
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fontsName = e.getAllFonts(); 
	    for (Font font : fontsName) {
			fonts.addItem(font.getFontName());
		}

		for (int i = 1; i <= 40; i++) {
			size.addItem(i);
		}

		ActionListener saveListener = (ActionEvent) -> {
			new NewNoteFrame(user, existed);
		};
		save.addActionListener(saveListener);

		bold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontBoldStyle();
			}
		});

		italic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontItalicStyle();
			}
		});

		underline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontUnderLineStyle();

			}
		});

		size.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int fontSize = (int) size.getSelectedItem();
				setFontSizeStyle(fontSize);
			}
		});
	

		fonts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontStyle((String)fonts.getSelectedItem()); 
				
			}
		});
		
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color =JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				setFontColorStyle(color);
			}
		});
		setFloatable(false);
		
		
		add(bold);
		add(italic);
		add(underline);
		add(save);
		add(fonts);
		add(size);
		add(color);

	}

	private ImageIcon makeGoodIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image newImage = img.getScaledInstance(20, 20,
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

	private void setFontBoldStyle() {

		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();

		if (EditingFrame.getEditingFrame(user).getEditingPane()
				.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);

			AttributeSet as = element.getAttributes();

			String family = StyleConstants.getFontFamily(as);
			int fontSize = StyleConstants.getFontSize(as);
			Color currentColor = StyleConstants.getForeground(as);
			boolean isBold = StyleConstants.isBold(as) ? false : true;
			boolean isItalic = StyleConstants.isItalic(as);
			boolean isUnderlined = StyleConstants.isUnderline(as);

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}
		}
	}

	private void setFontItalicStyle() {
		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();
		if (note.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);
			// Enumeration en= doc.getStyleNames();

			AttributeSet as = element.getAttributes();

			/**
			 * Get style from history...
			 */
			String family = StyleConstants.getFontFamily(as);
			int fontSize = StyleConstants.getFontSize(as);
			Color currentColor = StyleConstants.getForeground(as);
			boolean isBold = StyleConstants.isBold(as);
			boolean isItalic = StyleConstants.isItalic(as) ? false : true;
			boolean isUnderlined = StyleConstants.isUnderline(as);

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			// style.addAttribute(StyleConstants.FontSize, fontSize);
			// style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}

		}// if end...

	}

	private void setFontUnderLineStyle() {
		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();

		if (note.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);
			// Enumeration en= doc.getStyleNames();

			AttributeSet as = element.getAttributes();

			/**
			 * Get style from history...
			 */
			String family = StyleConstants.getFontFamily(as);
			int fontSize = StyleConstants.getFontSize(as);
			Color currentColor = StyleConstants.getForeground(as);
			boolean isBold = StyleConstants.isBold(as);
			boolean isItalic = StyleConstants.isItalic(as);
			boolean isUnderlined = StyleConstants.isUnderline(as) ? false
					: true;

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			// style.addAttribute(StyleConstants.FontSize, fontSize);
			// style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}

		}// if end...

	}

	private void setFontStyle(String s) {
		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();

		if (note.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);
			// Enumeration en= doc.getStyleNames();

			AttributeSet as = element.getAttributes();

			/**
			 * Get style from history...
			 */
			String family = s;
			int fontSize = StyleConstants.getFontSize(as);
			Color currentColor = StyleConstants.getForeground(as);
			boolean isBold = StyleConstants.isBold(as);
			boolean isItalic = StyleConstants.isItalic(as);
			boolean isUnderlined = StyleConstants.isUnderline(as);

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			// style.addAttribute(StyleConstants.FontSize, fontSize);
			// style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}

		}// if end...

	}

	private void setFontSizeStyle(int size) {
		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();

		if (note.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);
			// Enumeration en= doc.getStyleNames();

			AttributeSet as = element.getAttributes();

			/**
			 * Get style from history...
			 */
			String family = StyleConstants.getFontFamily(as);
			int fontSize = size;
			Color currentColor = StyleConstants.getForeground(as);
			boolean isBold = StyleConstants.isBold(as);
			boolean isItalic = StyleConstants.isItalic(as);
			boolean isUnderlined = StyleConstants.isUnderline(as);

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			// style.addAttribute(StyleConstants.FontSize, fontSize);
			// style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}

		}// if end...

	}

	private void setFontColorStyle(Color c) {
		JTextPane note = EditingFrame.getEditingFrame(user).getEditingPane();

		if (note.getSelectedText() != null) {

			StyledDocument doc = (StyledDocument) note.getDocument();
			String text = note.getSelectedText();
			int selectionStart = note.getSelectionStart();
			int selectionEnd = note.getSelectionEnd();

			StyleContext context = new StyleContext();
			Style style;

			Element element = doc.getCharacterElement(selectionStart);
			// Enumeration en= doc.getStyleNames();

			AttributeSet as = element.getAttributes();

			/**
			 * Get style from history...
			 */
			String family = StyleConstants.getFontFamily(as);
			int fontSize = StyleConstants.getFontSize(as);
			Color currentColor = c;
			boolean isBold = StyleConstants.isBold(as);
			boolean isItalic = StyleConstants.isItalic(as);
			boolean isUnderlined = StyleConstants.isUnderline(as);

			String styleName = String.valueOf(Math.random());

			style = context.addStyle(styleName, null);
			// style.addAttribute(StyleConstants.FontSize, fontSize);
			// style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.Foreground, currentColor);
			style.addAttribute(StyleConstants.FontFamily, family);
			style.addAttribute(StyleConstants.FontSize, fontSize);
			style.addAttribute(StyleConstants.Bold, isBold);
			style.addAttribute(StyleConstants.Italic, isItalic);
			style.addAttribute(StyleConstants.Underline, isUnderlined);

			note.replaceSelection("");

			try {
				note.getStyledDocument().insertString(
						selectionEnd - text.length(), text, style);
			} catch (BadLocationException ex) {

			}

		}// if end...

	}

}
