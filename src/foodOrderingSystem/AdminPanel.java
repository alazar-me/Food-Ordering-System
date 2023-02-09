package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
//import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class AdminPanel {
    void showAdminPanel() {
        JFrame frame = new JFrame("Admin Panel");
       
        //frame.setIconImage();
        JLabel adminPanelLabel = new JLabel("Admin Panel");
        JButton userListButton = new JButton("User List");
        JButton notificationButton = new JButton("Notifications");
        JButton btnDeleteUserAccount = new JButton("Delete User Account");
        JButton btnChangeAdminPassword = new JButton("Change Admin Password");
        
        
        //JButton orderList = new JButton("Order List");
        JButton exitButton = new JButton("Exit");
        JButton logoutButton = new JButton("Logout");
        //Button adminLoginButton = new JButton("Admin");

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        adminPanelLabel.setBounds(380,50,300,50);
        adminPanelLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        adminPanelLabel.setForeground(Color.WHITE);


        userListButton.setBounds(240,110,400,50);//x,y,w,h
        notificationButton.setBounds(240,180,400,50);
        btnDeleteUserAccount.setBounds(240,250,400,50);
        btnChangeAdminPassword.setBounds(240,320,400,50);
        logoutButton.setBounds(600,375,120,20);
        exitButton.setBounds(600,405,120,20);
        
        userListButton.setBackground(Color.LIGHT_GRAY);
        userListButton.setOpaque(true);

        notificationButton.setBackground(Color.GRAY);
        notificationButton.setOpaque(true);

        btnDeleteUserAccount.setBackground(Color.LIGHT_GRAY);
        btnDeleteUserAccount.setOpaque(true);

        btnChangeAdminPassword.setBackground(Color.GRAY);
        btnChangeAdminPassword.setOpaque(true);

        logoutButton.setBackground(Color.PINK);
        logoutButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        

        userListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                UsersList userlst = new UsersList();
                userlst.usersListGUI();
                frame.dispose();

			}
		});

        notificationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Notifications notifications = new Notifications();
                notifications.showNotificationsGUI();
                frame.dispose();
			}
		});
        btnDeleteUserAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DeleteUserAccount deleteUserAccount = new DeleteUserAccount();
                deleteUserAccount.showDeleteAccountGUI();
                frame.dispose();
			}
		}); 
        btnChangeAdminPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ChangeAdminPassword changeAdminPassword = new ChangeAdminPassword();
                changeAdminPassword.showChangeAdminPasswordGUI();
                frame.dispose();
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

        //add to frame
        frame.getContentPane().add(adminPanelLabel);
        frame.getContentPane().add(userListButton);
        frame.getContentPane().add(notificationButton);
        frame.getContentPane().add(btnDeleteUserAccount);
        frame.getContentPane().add(btnChangeAdminPassword);
        frame.getContentPane().add(logoutButton);
        frame.getContentPane().add(exitButton);
               
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
