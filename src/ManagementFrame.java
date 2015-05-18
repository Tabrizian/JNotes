import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ManagementFrame extends JFrame {
	public ManagementFrame() {
		
		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);

		add(new MainPanel(), BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
