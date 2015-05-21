import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ManagementFrame extends JFrame {

	private static ManagementFrame instance = null;

	private ManagementFrame() {

		setLayout(new BorderLayout());
		setSize(400, 600);
		setLocation(400, 50);

		add(new ManagementPanel(), BorderLayout.CENTER);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static ManagementFrame getManagementFrame() {
		if (instance == null)
			instance = new ManagementFrame();
		return instance;
	}
	
	public void delete(){
		dispose();
		instance = null;
	}
}
