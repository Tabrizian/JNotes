import java.awt.BorderLayout;

import javax.swing.JFrame;


public class SignupFrame extends JFrame {
	
	public SignupFrame(){
		super();
		
		setLayout(new BorderLayout());
		
		add(new SignupPanel(),BorderLayout.CENTER);
		
		setSize(300, 300);
		setLocation(400, 50);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
