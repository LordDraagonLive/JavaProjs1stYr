import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuessTheWord {

	
	 //array with the words that the user will guess
	String[] words = {"BRUCEWAYNE", "DOG","SCHOOL","SPIDER","CLAP","EAT","BOOKS","BUS"};
	
    //correct user attempts
    public int corctAtmps = 0;
    //failed user attempts
    public int failAtmps = 0;
    // random variable
    public Random r = new Random();
    // randomizing all the words in the "words" array
    public String word = words[r.nextInt(words.length)];
  
   
    
    public char[] letter=null;
	private JFrame frame;
	private JTextField txt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessTheWord window = new GuessTheWord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuessTheWord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("X");
		lbl1.setBounds(143, 167, 12, 14);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("X");
		lbl2.setBounds(154, 167, 12, 14);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("X");
		lbl3.setBounds(165, 167, 12, 14);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("X");
		lbl4.setBounds(176, 167, 12, 14);
		frame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("X");
		lbl5.setBounds(185, 167, 12, 14);
		frame.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("X");
		lbl6.setBounds(198, 167, 12, 14);
		frame.getContentPane().add(lbl6);
		
		JLabel lblFailedAttempts = new JLabel("Failed Attempts");
		lblFailedAttempts.setBounds(10, 207, 99, 14);
		frame.getContentPane().add(lblFailedAttempts);
		
		JLabel lblRemainAT = new JLabel("");
		lblRemainAT.setEnabled(false);
		lblRemainAT.setBounds(122, 182, 46, 14);
		frame.getContentPane().add(lblRemainAT);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(25, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblimage = new JLabel("");
		lblimage.setBounds(266, 32, 158, 178);
		frame.getContentPane().add(lblimage);
		
		
		JLabel lblfailedAT = new JLabel("");
		lblfailedAT.setBounds(120, 207, 46, 14);
		frame.getContentPane().add(lblfailedAT);
		
		JLabel lblRemainingAttemets = new JLabel("Remaining Attemets   :");
		lblRemainingAttemets.setBounds(10, 182, 114, 14);
		frame.getContentPane().add(lblRemainingAttemets);
		
		txt1 = new JTextField();
		txt1.setBounds(10, 86, 29, 20);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				letter= new char[6];
				
                
			       // char userValue1 = (Character)userValue;
			        
			       // searching the randomized array "word"
			       for (int x = 0; x < word.length(); x++) {
			            letter[x] = word.charAt(x);
			        }
			        //Using a Try.. catch method to show an error to the user
			        try { 
			            
			            //Converting the input to lowercase
			            String userInput = txt1.getText().toUpperCase();
			            //defining a char to get the first character of the user's input
			            char userValue = userInput.charAt(0);
			            //Using count for the hangman images below
			            int count = 0;

			            //Using a for loop once again for a linear search of the words to guess
			            for (int x = 0; x < word.length(); x++) {
			                if (userValue == letter[x]) {
			                    switch (x) {
			                        case 0:
			                            lbl1.setText("" + userValue);
			                            
			                            break;
			                        case 1:
			                            lbl2.setText("" + userValue);
			                             
			                            break;
			                        case 2:
			                            lbl3.setText("" + userValue);
			                            break;
			                        case 3:
			                            lbl4.setText("" + userValue);
			                            break;
			                        case 4:
			                            lbl5.setText("" + userValue);
			                            break;
			                        case 5:
			                        	lbl6.setText("" + userValue);
			                             break;

			                        default:
			                            break;
			                           
			                    }
			                    // set the cursor to position in the text field if true
			                    txt1.requestFocusInWindow();
			                    //Incrementing the correct count each time the user guesses a correect letter
			                    corctAtmps++;
			                } else {
			                    //Incrementing the count each time the user guesses an Incorreect letter
			                    count++;
			                    // set the cursor to position in the text field if false
			                    txt1.requestFocusInWindow();
			                }
			                //steps inorder to check & display the incorrect guesses
			                if (count == word.length()) {
			                    count = 0;
			                    failAtmps++;
			                    
			                    if(failAtmps<7){                    
			                    lblfailedAT.setText("" + failAtmps);
			                    lblRemainAT.setText("" + (7 - failAtmps));                    
			                    }else{
			                        JOptionPane.showMessageDialog(null, "You Exceeded The Number of Attemps! GAME OVER !", 
			                            "You Lost !", JOptionPane.INFORMATION_MESSAGE);
			                    System.exit(0);
			                    
			                    }
			                    
			                }
			                //Clearing the textbox where the user guesses the letter(s)
			                txt1.setText(null);
			                if (corctAtmps == word.length()) {
			                    JOptionPane.showMessageDialog(null, "You have won! Game Over", 
			                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
			                    System.exit(0);
			                   // letter=null;

			                }
			            }
			        }catch (Exception e) {
			            //Displaying a message dialog each time the user inputs a wrong data type
			            JOptionPane.showMessageDialog(null, "Answer cannot be blank !\n Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
			           //letter=null;
			                    txt1.requestFocusInWindow();
			        
			        }
			              
			             if (failAtmps == 1){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (2).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			            	
			             }else if (failAtmps == 2){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (3).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			             }else if (failAtmps == 3){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (4).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			             }else if (failAtmps == 4){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (5).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			             }else if (failAtmps == 5){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (6).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			             }else if (failAtmps == 6){
			            	 ImageIcon iconLogo = new ImageIcon("C:/Users/sheen/Desktop/GuessTheWord/GuessTheWord/src/HangMan (8).jpg");
			         		Image image = iconLogo.getImage();
			         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
			         		iconLogo = new ImageIcon(newimg);
			         		lblimage.setIcon(iconLogo);
			         		JOptionPane.showMessageDialog(null, "Last Attempt                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ", 
		                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
			            
			             }
			             
			             
			        
				
			}
		});
		btnCheck.setBounds(108, 85, 89, 23);
		frame.getContentPane().add(btnCheck);
		
	
		
	
		
	}
}
