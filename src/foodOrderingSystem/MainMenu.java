package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenu {

    void displayMainMenu() {
        JFrame frame = new JFrame("Main Menu");
       
        //frame.setIconImage();
        JLabel mainMenuLabel = new JLabel("Main Menu");
        JButton foodMenuButton = new JButton("Food Menu");
        JButton feedbackButton = new JButton("Feedback/Message");
        JButton contactButton = new JButton("Contact Us");
        JButton exitButton = new JButton("Exit");
        JButton logoutButton = new JButton("Logout");
        //Button adminLoginButton = new JButton("Admin");

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        mainMenuLabel.setBounds(380,50,300,50);
        mainMenuLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        mainMenuLabel.setForeground(Color.WHITE);


        foodMenuButton.setBounds(240,110,400,50);//x,y,w,h
        feedbackButton.setBounds(240,180,400,50);
        contactButton.setBounds(240,250,400,50);
        logoutButton.setBounds(600,370,120,20);
        exitButton.setBounds(600,400,120,20);
        
        foodMenuButton.setBackground(Color.LIGHT_GRAY);
        foodMenuButton.setOpaque(true);

        feedbackButton.setBackground(Color.GRAY);
        feedbackButton.setOpaque(true);

        contactButton.setBackground(Color.LIGHT_GRAY);
        contactButton.setOpaque(true);

        logoutButton.setBackground(Color.PINK);
        logoutButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        foodMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                FoodMenu foodmenu = new FoodMenu();
                foodmenu.showFoodMenuGUI();
				frame.dispose();
			}
		});

        feedbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Feedback feedback = new Feedback();
                feedback.showFeedbackGUI();
                frame.dispose();
			}
		});

        contactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Contact us \nEmail: support.foodOrdering@gmail.com \nPhone: 00002222");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                Login logout = new Login();
                logout.displayLoginPage();
                frame.dispose();
			}
		});

        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
		});
      
        

        

        //adminLoginButton.setBounds(550,30,100,15);

        //add to frame
        frame.getContentPane().add(mainMenuLabel);
        frame.getContentPane().add(foodMenuButton);
        frame.getContentPane().add(feedbackButton);
        frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(contactButton);
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
