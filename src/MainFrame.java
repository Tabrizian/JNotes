import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		new User("Iman", "Tabrizian", "Iman", "123", "H", new Date(1393,12,12));
		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);

		add(new MainPanel(), BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
}
