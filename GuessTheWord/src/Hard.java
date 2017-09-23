import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JTextField;

public class Hard {

	
	 //Array with the words
	String[] words = {"GYM", "PRESIDENT","CHALK","DRYER","ERASER","PIZZA"};
	
    //Correct user attempts
    public int CorrectAttempts = 0;
    //Incorrect user attempts
    public int IncorrectAttempts = 0;
    // Index of variable
    int index = (int) (Math.random() * words.length);
    //Selected variable from the list
    public String SelectedWord = words[index];
   
    
    public char[] letter=null;
	private JFrame frmW;
	private JTextField txt1;


	/**
	 * Launch the application.
	 */
	public static void NewScreenHard() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hard window = new Hard();
					window.frmW.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmW = new JFrame();
		frmW.setTitle("W1628087");
		frmW.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmW.setBounds(100, 100, 534, 365);
		frmW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmW.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("_");
		lbl1.setBounds(143, 167, 12, 14);
		frmW.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("_");
		lbl2.setBounds(154, 167, 12, 14);
		frmW.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("_");
		lbl3.setBounds(165, 167, 12, 14);
		frmW.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("_");
		lbl4.setBounds(176, 167, 12, 14);
		frmW.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("_");
		lbl5.setBounds(187, 167, 12, 14);
		frmW.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("_");
		lbl6.setBounds(198, 167, 12, 14);
		frmW.getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel("_");
		lbl7.setBounds(209, 167, 12, 14);
		frmW.getContentPane().add(lbl7);
		
		JLabel lbl8 = new JLabel("_");
		lbl8.setBounds(220, 167, 12, 14);
		frmW.getContentPane().add(lbl8);
		
		JLabel lbl9 = new JLabel("_");
		lbl9.setBounds(231, 167, 12, 14);
		frmW.getContentPane().add(lbl9);
		
		JLabel lbl10 = new JLabel("_");
		lbl10.setBounds(242, 167, 12, 14);
		frmW.getContentPane().add(lbl10);
		
		JLabel lbl11 = new JLabel("_");
		lbl11.setBounds(253, 167, 12, 14);
		frmW.getContentPane().add(lbl11);
		
		JLabel lblFailedAttempts = new JLabel("Failed Attempts          :");
		lblFailedAttempts.setBounds(10, 272, 167, 14);
		frmW.getContentPane().add(lblFailedAttempts);
		
		JLabel lblhint = new JLabel("");
		lblhint.setBounds(10, 119, 293, 14);
		frmW.getContentPane().add(lblhint);
		
		JLabel lblRemainAT = new JLabel("3");
		lblRemainAT.setBackground(Color.BLACK);
		lblRemainAT.setBounds(208, 247, 46, 14);
		frmW.getContentPane().add(lblRemainAT);
		
		JLabel lblNewLabel = new JLabel("HangMan");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 60));
		lblNewLabel.setBounds(114, 11, 298, 54);
		frmW.getContentPane().add(lblNewLabel);

		JLabel lblimage = new JLabel("");
		lblimage.setBounds(348, 67, 158, 178);
		frmW.getContentPane().add(lblimage);
		
		
		JLabel lblfailedAT = new JLabel("");
		lblfailedAT.setBounds(197, 272, 46, 14);
		frmW.getContentPane().add(lblfailedAT);
		
		JLabel lblRemainingAttemets = new JLabel("Remaining Attempts   :");
		lblRemainingAttemets.setBounds(10, 247, 156, 14);
		frmW.getContentPane().add(lblRemainingAttemets);
		
		txt1 = new JTextField();
		txt1.setBounds(13, 145, 29, 20);
		frmW.getContentPane().add(txt1);
		txt1.setColumns(10);
		
		
	
		  switch (SelectedWord) {
          case "GYM":
          	
      		
      		lbl4.setVisible(false);
      		lbl5.setVisible(false);
      		lbl6.setVisible(false);
      		lbl7.setVisible(false);
      		lbl8.setVisible(false);
      		lbl9.setVisible(false);
      		lbl10.setVisible(false);
      		lbl11.setVisible(false);
          	lblhint.setText("Place where people go to exercise.");
              break;
         
          case "PRESIDENT":
          		
          		
          		lbl10.setVisible(false);
          		lbl11.setVisible(false);
          	
          		
          	lblhint.setText("Head of the country.");
              break;
          case "CHALK":
          
          	
      		lbl6.setVisible(false);
      		lbl7.setVisible(false);
      		lbl8.setVisible(false);
      		lbl9.setVisible(false);
      		lbl10.setVisible(false);
      		lbl11.setVisible(false);
          	lblhint.setText("Thing used to write in blackboard.");
              break; 	
          case "DRYER":
            
          	
      		lbl6.setVisible(false);
      		lbl7.setVisible(false);
      		lbl8.setVisible(false);
      		lbl9.setVisible(false);
      		lbl10.setVisible(false);
      		lbl11.setVisible(false);
          	lblhint.setText("Machine used to dry clothes.");
              break;
          case "ERASER":
           
      		lbl7.setVisible(false);
      		lbl8.setVisible(false);
      		lbl9.setVisible(false);
      		lbl10.setVisible(false);
      		lbl11.setVisible(false);
          	lblhint.setText("Used to correct thing in the books.");
              break;
          
          case "PIZZA":
	        lbl6.setVisible(false);
	        lbl7.setVisible(false);
      		lbl8.setVisible(false);
      		lbl9.setVisible(false);
      		lbl10.setVisible(false);
      		lbl11.setVisible(false);
          	lblhint.setText("Food item.");
              break;
          default:
        
       
      	
   }  
		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				 letter= new char[11];
	                
			   
			        
			     
			       for (int x = 0; x < SelectedWord.length(); x++) {
			            letter[x] = SelectedWord.charAt(x);
			        }
			        //Using a Try.. catch method to show an error to the user
			        try { 
			            
			            //Converting the input to Uppercase
			            String userInput = txt1.getText().toUpperCase();
			            //defining a char to get the character users input
			            char userValue = userInput.charAt(0);
			            //Using count for the images below
			            int count = 0;

			            //Using a for loop to search for the guessed word
			            for (int x = 0; x < SelectedWord.length(); x++) {
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
			                        case 6:
			                            lbl7.setText("" + userValue);
			                             break;
			                        case 7:
			                            lbl8.setText("" + userValue);
			                             break;
			                        case 8:
			                            lbl9.setText("" + userValue);
			                             break;
			                        case 9:
			                            lbl10.setText("" + userValue);
			                             break;
			                        case 10:
			                            lbl11.setText("" + userValue);
			                             break;

			                        default:
			                            break;
			                           
			                    }
			                    // set the cursor to text field 
			                    txt1.requestFocusInWindow();
			                    //Incrementing the correct count each time the user gets a correct guess
			                    CorrectAttempts++;
			                } else {
			                    //Incrementing the count each time the user guesses an Incorrect guess
			                    count++;
			                    // set the cursor to position in the text field if false
			                    txt1.requestFocusInWindow();
			                }
			                //Check & display the incorrect guesses
			                if (count == SelectedWord.length()) {
			                    count = 0;
			                    IncorrectAttempts++;
			                    
			                    if(IncorrectAttempts<3){                    
			                    	lblfailedAT.setText("" + IncorrectAttempts);
			                    	lblRemainAT.setText("" + (3 - IncorrectAttempts));                    
			                    }else{
			                        JOptionPane.showMessageDialog(null, "You Exceeded The Number of Attemps! GAME OVER !", 
			                            "You Lost !", JOptionPane.INFORMATION_MESSAGE);
			                    System.exit(0);
			                    
			                    }
			                    
			                }
			                //Clearing the textbox where the user guesses the letters
			                txt1.setText(null);
			                if (CorrectAttempts == SelectedWord.length()) {
			                    JOptionPane.showMessageDialog(null, "You have won! Game Over", 
			                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
			                    System.exit(0);
			                

			                }
			            }         
			             

			        } catch (Exception e) {
			            //Displaying a message dialog each time the user inputs a wrong data type
			            JOptionPane.showMessageDialog(null, "Answer cannot be blank !\n Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
			    
			            txt1.requestFocusInWindow();


			        }

			        if (IncorrectAttempts == 1){
			        	 ImageIcon iconLogo =  new ImageIcon(getClass().getResource("Resources/hangimages (3).jpg"));
		         		Image image = iconLogo.getImage();
		         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
		         		iconLogo = new ImageIcon(newimg);
		         		lblimage.setIcon(iconLogo);
		            	
		             }else if (IncorrectAttempts == 2){
		            	 ImageIcon iconLogo =  new ImageIcon(getClass().getResource("Resources/hangimages (6).jpg"));
		         		Image image = iconLogo.getImage();
		         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
		         		iconLogo = new ImageIcon(newimg);
		         		lblimage.setIcon(iconLogo);
		             }else if (IncorrectAttempts == 3){
		            	 ImageIcon iconLogo =  new ImageIcon(getClass().getResource("Resources/hangimages (1).jpg"));
		         		Image image = iconLogo.getImage();
		         		Image newimg = image.getScaledInstance(168, 159,  java.awt.Image.SCALE_SMOOTH);
		         		iconLogo = new ImageIcon(newimg);
		         		lblimage.setIcon(iconLogo);
		          
		             }
		
			             
			        
				
			}
		});
		btnCheck.setBounds(52, 144, 89, 23);
		frmW.getContentPane().add(btnCheck);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmW.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null,"Choose level from file->level\n"+
						"                    Easy    Normal    Hard\n"+
						"chances:      7         5             5=3\n" ,
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
