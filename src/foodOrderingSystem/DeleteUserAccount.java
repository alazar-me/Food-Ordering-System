package foodOrderingSystem;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUserAccount extends ImplementForm{
    void showDeleteAccountGUI(){
        JFrame frame = new JFrame("Delete User Account");
       
        //frame.setIconImage();
        JLabel credsLabel = new JLabel("Enter Account Creadentials");
        JLabel labelUserName = new JLabel("Username"); //username
        JTextField usernameTextField = new JTextField();
        JLabel labelPass = new JLabel("Password");
        JPasswordField passwordTextField = new JPasswordField();
        JButton btnDeleteAccount = new JButton("Delete Account");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");

        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/adminLogin.png")));
	    frame.setLayout(new FlowLayout());
        
        credsLabel.setBounds(100,50,300,50);
        credsLabel.setFont(new Font("Elephant",Font.BOLD, 16));

        labelUserName.setBounds(50,110,150,20);
        labelUserName.setFont(new Font("Alice", Font.BOLD, 16));
        usernameTextField.setBounds(150,110,150,20);

        

        labelPass.setBounds(50,160,150,20);
        labelPass.setFont(new Font("Elephant", Font.BOLD, 16));
        passwordTextField.setBounds(150,160,150,20);


        //setBounds
        btnDeleteAccount.setBounds(130,210,200,20);
        backButton.setBounds(650,360,120,20);
        exitButton.setBounds(650,400,120,20);
        //adminLoginButton.setBounds(550,30,100,15);

        //
        btnDeleteAccount.setBackground(Color.CYAN);
        btnDeleteAccount.setOpaque(true);

        backButton.setBackground(Color.BLACK);
        backButton.setOpaque(true);
        backButton.setForeground(Color.WHITE);

        exitButton.setBackground(Color.PINK);
        exitButton.setOpaque(true);

        //actionListner

        btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            String user = usernameTextField.getText();
               char charPass[] = passwordTextField.getPassword();
               String pass = String.valueOf(charPass);

               
               if(user.equals("") || pass.equals("")){
                    JOptionPane.showMessageDialog(null, "Field can't be empty");
               }
               else{
                    deleteAccount(user, pass, "Files/User/information.txt");
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                    }
                                 
			}
		});
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

        //add to frame
        frame.getContentPane().add(credsLabel);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(labelUserName);
        frame.getContentPane().add(labelPass);
        frame.getContentPane().add(passwordTextField);
        frame.getContentPane().add(btnDeleteAccount);
        frame.getContentPane().add(exitButton);
        frame.getContentPane().add(backButton);
        //frame.getContentPane().add(adminLoginButton);
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
