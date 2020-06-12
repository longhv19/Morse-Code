package Code2D;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class demoScreen extends JFrame implements ActionListener{
	
	private JPanel panel;
	private Font mFont;
	private JMenuBar mMenuBar;
	private JTextArea input, output;
	private JMenu fileMenu;
	private JLabel label;
	private JMenuItem open, save, exit;
	private JFileChooser mFileChooser;
	private Dictionary dictionary;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					demoScreen frame = new demoScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public demoScreen() {
		super("Morse Code Translator");
		
		dictionary = new Dictionary("E:\\Java Code\\Morse Code\\src\\Code2D\\morse.txt");
		
		mFont = new Font("Courier New", Font.PLAIN, 12);
		panel = new JPanel(new FlowLayout());
		input = new JTextArea(10, 100);
		output = new JTextArea(10, 100);
		
		mMenuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		open = new JMenuItem("Open");
		KeyStroke ctrlO = KeyStroke.getKeyStroke("control O");
		open.setAccelerator(ctrlO);
		open.addActionListener(this);
		
		save = new JMenuItem("Save");
		KeyStroke ctrlS = KeyStroke.getKeyStroke("control S");
		save.setAccelerator(ctrlS);
		save.addActionListener(this);
		
	
		
		exit = fileMenu.add("Exit");
		KeyStroke ctrlQ = KeyStroke.getKeyStroke("control Q");
		exit.setAccelerator(ctrlQ);
		exit.addActionListener(this);
		
		
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		setJMenuBar(mMenuBar);
		mMenuBar.add(fileMenu);
		
		JScrollPane scroll = new JScrollPane(input);
		JScrollPane scroller = new JScrollPane(output);
		JButton button = new JButton("Translate");
		JButton clear = new JButton("Clear Text");
		
		input.setLineWrap(true);
		input.setFont(mFont);
		
		output.setLineWrap(true);
		output.setFont(mFont);
		output.setEditable(false);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		button.addActionListener(this);
		clear.addActionListener(this);
		
		panel.add(scroll);
		panel.add(button);
		panel.add(clear);
		panel.add(scroller);
		
		getContentPane().add(panel);
		createAndShowFrame();
		
	}
	
	public Font getFont() {
		return mFont;
	}
	
	public void setFont(Font newFont) {
		mFont = newFont;
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String check;
		try {
			check = ((JButton)(e.getSource())).getText();
		} catch (ClassCastException c) {
			// TODO: handle exception
			check = ((JMenuItem)(e.getSource())).getText();
		}
		
		
		switch (check) {
		case "Translate": 
			output.setText("");
			output.setText(dictionary.translate(input.getText(), "/"));
			break;
		case "Clear Text":
			output.setText("");
			input.setText("");
			break;
		case "Open":
			try {
				openText();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			break;
		case "Save":
			saveText();
			break;
		case "Exit":
			confirmExit();
			break;
		}
		
	}
	
	private void openText() throws IOException{
		int readVal = mFileChooser.showOpenDialog(this);
		if(readVal == JFileChooser.APPROVE_OPTION) {
			File file = mFileChooser.getSelectedFile();
			if(file.getName().contains(".txt")) {
				
			}
		}
	}
	
	private void saveText() {
		int readVal = mFileChooser.showSaveDialog(this);
		if(readVal == JFileChooser.APPROVE_OPTION) {
			File file = mFileChooser.getSelectedFile();
			try {
				PrintWriter out = new PrintWriter(new FileWriter(mFileChooser.getCurrentDirectory()+"//"+file.getName()+".txt"));
				out.println(output.getText());
				out.close();
			} 
			catch(IOException e) {
				System.out.println("Error File");
			}
		}
	}
	
	private void confirmExit() {
		confirmationDialog reExit = new confirmationDialog("Are you sure!", "Exit");
		if(reExit.returnAnswer()) {
			System.exit(0);
		}
	}
	
	private void createAndShowFrame() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setSize(800, 400);
		setVisible(true);
	}

}
