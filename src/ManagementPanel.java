import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ManagementPanel extends JPanel {
	private Image img;

	public ManagementPanel() {
		img = getToolkit().getImage("pics/blue_and_red.jpg");
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}
}
