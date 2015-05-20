import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;


public class EToolbar extends JToolBar {
	
	private JButton save;
	private JButton bold;
	private JButton italic;
	private JButton underline;
	private JComboBox<String> fonts;
	private JComboBox<Integer> size;
	
	
	public EToolbar(){
		save = new JButton(makeGoodIcon("pics/save.png"));
		bold = new JButton(makeGoodIcon("pics/font_bold.png"));
		italic = new JButton(makeGoodIcon("pics/font_italic.png"));
		underline = new JButton(makeGoodIcon("pics/font_underline.png"));
		fonts = new JComboBox<>();
		size = new JComboBox<>();
	
		setFloatable(false);
		
		add(bold);
		add(italic);
		add(underline);
		add(save);
		
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
	
	
	
}
