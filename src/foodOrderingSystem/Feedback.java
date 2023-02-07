package foodOrderingSystem;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Feedback extends ImplementForm {
    void showFeedbackGUI() {
        JFrame frame = new JFrame("Feedback/Message");
       
        //frame.setIconImage();
        JLabel contuctUSLabel = new JLabel("Feedback");
        JTextArea messageArea = new JTextArea();
        JButton sendButton = new JButton("Send");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");

        //wallpaper
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));

        
        contuctUSLabel.setBounds(380,50,300,50);
        contuctUSLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        contuctUSLabel.setForeground(Color.WHITE);
        
        messageArea.setBounds(100,100,646,230); //x,y,w,h
        sendButton.setBounds(380,350,120,20);
        backButton.setBounds(600,370,120,20);
        exitButton.setBounds(600,400,120,20);
        
        sendButton.setBackground(Color.GREEN);
        sendButton.setForeground(Color.GRAY);
        sendButton.setOpaque(true);

        backButton.setBackground(Color.PINK);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);
        //messageArea
        messageArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
            

        sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String message = messageArea.getText();
                if(!message.equals("")){ //not empty
                    feedBack(message);                
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Message area is empty");
                }
			}
		});


        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MainMenu menu = new MainMenu();
                menu.displayMainMenu();
                frame.dispose();
			}
		});

        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
		});    

        //add to frame
        frame.getContentPane().add(contuctUSLabel);
        frame.getContentPane().add(messageArea);
        frame.getContentPane().add(sendButton);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);        
        

        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
