package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notifications extends ImplementForm {
   
    void showNotificationsGUI(){
        JFrame frame = new JFrame("Notifications");

        JLabel notificationLabel = new JLabel("Notifications");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");
        JTextArea msgArea = new JTextArea("Message");

        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        notificationLabel.setBounds(380,50,300,50);
        notificationLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        notificationLabel.setForeground(Color.WHITE);


        msgArea.setBounds(100,100,646,230);
        backButton.setBounds(600,370,120,20);
        exitButton.setBounds(600,400,120,20);
    

        backButton.setBackground(Color.PINK);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.showAdminPanel();
                frame.dispose();
			}
		});

        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
		});

        //Read notifications
        try{
            FileReader reader = new FileReader("Files/User/feedback.txt");
            BufferedReader breader = new BufferedReader(reader);
            msgArea.read(breader, null);
        }catch(Exception ex){
            ex.printStackTrace();
        }     


        //add to frame
        frame.getContentPane().add(notificationLabel);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(msgArea);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
