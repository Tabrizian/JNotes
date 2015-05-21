import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static MainFrame instance = null;

	private MainFrame() {
		new User("Iman", "Tabrizian", "Iman", "123", "H",
				new Date(1393, 12, 12));
		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);

		add(new MainPanel(), BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static MainFrame getMainFrame() {
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}
	
	public void delete(){
		dispose();
		instance = null;
	}
}
