//H.K.R.R.Nalish
//2015119
//16280878

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main_Menu {

	private JFrame frmHangman;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
					window.frmHangman.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Menu() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHangman = new JFrame();
		frmHangman.setTitle("W1628087");
		frmHangman.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHangman.getContentPane().setForeground(SystemColor.desktop);
		frmHangman.getContentPane().setLayout(null);
		
		JLabel lblHangman = new JLabel("HangMan");
		lblHangman.setFont(new Font("Viner Hand ITC", Font.PLAIN, 60));
		lblHangman.setBounds(105, 0, 323, 79);
		frmHangman.getContentPane().add(lblHangman);
		
		JLabel labelimg = new JLabel("");
		labelimg.setBounds(168, 73, 159, 165);
		frmHangman.getContentPane().add(labelimg);
		frmHangman.setBackground(Color.BLACK);
		frmHangman.setBounds(100, 100, 541, 337);
		frmHangman.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmHangman.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		ImageIcon iconLogo =  new ImageIcon(getClass().getResource("Resources/maxresdefault.jpg"));
		Image image = iconLogo.getImage();
		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
		iconLogo = new ImageIcon(newimg);
		labelimg.setIcon(iconLogo);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Difficulty_selection sc = new Difficulty_selection();
				sc.NewScreen();
				
			}
		});
		btnStart.setBounds(202, 243, 89, 23);
		frmHangman.getContentPane().add(btnStart);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JOptionPane.showMessageDialog(null,"Choose level from file->level\n"+
						"                    Easy    Normal    Hard\n"+
						"chances:      7         5             3\n" ,
					"Help",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null,"Programming by :\n"
						+"H.K.R.R.Nalish\n"
						+"2015119\n"
						+"W1628087\n"
						+"rasheen.2015119@iit.ac.lk",null,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
	}

	

}
