import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JToolBar;


public class EditingFrame extends JFrame {
	
	private JEditorPane editingPane;
	private JToolBar toolbar;
	
	public EditingFrame(){
		super();
		
		setLayout(new BorderLayout());
		
		editingPane = new JEditorPane();
		toolbar = new EToolbar();
		
		add(toolbar, BorderLayout.NORTH);
		add(editingPane, BorderLayout.CENTER);
		
		setUndecorated(true);
		setSize(400, 600);
		setLocation(400, 50);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public JEditorPane getEditingPane(){
		return editingPane;
	}
	
}
