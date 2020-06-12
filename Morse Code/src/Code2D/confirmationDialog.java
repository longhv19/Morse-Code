package Code2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class confirmationDialog extends JOptionPane implements KeyListener{

	private JDialog dialog;
	private final Object[] option = {"YES", "NO"};
	
	
	
	public confirmationDialog(String message, String title) {
		super(message);
		
		setOptions(option);
		
		dialog = createDialog(new JFrame(), title);
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public void setTitle(String newTitle) {
		dialog.setTitle(newTitle);
	}
	
	public String getTitle() {
		return dialog.getTitle();
	}

	public boolean returnAnswer() {
		Object reAns = getValue();
		
		if(reAns.equals(option[0])) {
			dialog.dispose();
			return true;
		}else {
			dialog.dispose();
			return false;
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
