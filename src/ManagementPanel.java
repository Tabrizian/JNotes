import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ManagementPanel extends JPanel {

	private Image img;
	private JToolBar toolbar;
	private JButton add;
	private JButton manage;
	private JButton exit;

	public ManagementPanel() {
		img = getToolkit().getImage("pics/blue_and_red.jpg");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		
			
		add(toolbar,BorderLayout.WEST);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}
	
}
