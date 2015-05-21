import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SignupPanel extends JPanel {
	
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JTextField password;
	private JTextField dateOfbirth;
	private JTextField degree;
	private Image img;
	private JButton submit;

	public SignupPanel(){
		super();
		setLayout(new GridBagLayout());
		
		firstName = new JTextField(10);
		lastName = new JTextField(10);
		username = new JTextField(10);
		password = new JTextField(10);
		dateOfbirth = new JTextField(10);
		degree = new JTextField(10);
		submit = new JButton("Submit");
		
		firstName.setForeground(Color.GRAY);
		firstName.setText("First Name");
		firstName.addFocusListener(new TextFieldFocus("First Name"));
		
		lastName.setForeground(Color.GRAY);
		lastName.setText("Last Name");
		lastName.addFocusListener(new TextFieldFocus("Last Name"));
		
		username.setForeground(Color.GRAY);
		username.setText("Username");
		username.addFocusListener(new TextFieldFocus("Username"));
		
		password.setForeground(Color.GRAY);
		password.setText("Password");
		password.addFocusListener(new TextFieldFocus("Password"));
		
		dateOfbirth.setForeground(Color.GRAY);
		dateOfbirth.setText("Birthday");
		dateOfbirth.addFocusListener(new TextFieldFocus("Birthday"));
		
		degree.setForeground(Color.GRAY);
		degree.setText("Degree");
		degree.addFocusListener(new TextFieldFocus("Degree"));

		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(firstName, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(lastName, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(username, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(password, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(dateOfbirth, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(degree, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(submit, gc);
		
		img = getToolkit().getImage("pics/signup.jpg");
	}
	
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}
}
