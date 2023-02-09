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
import java.io.*;

public class ChangeAdminPassword {
    void showChangeAdminPasswordGUI(){
        JFrame frame = new JFrame("Change Admin Password");
       
        //frame.setIconImage();
        JLabel credsLabel = new JLabel("Enter Account Creadentials");
        JLabel labelUserName = new JLabel("new username"); //username
        JTextField usernameTextField = new JTextField();
        JLabel labelPass = new JLabel("new password");
        JPasswordField passwordTextField = new JPasswordField();
        JButton btnChangePassword = new JButton("Change password");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");

        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/adminLogin.png")));
	    frame.setLayout(new FlowLayout());
        
        credsLabel.setBounds(100,50,300,50);
        credsLabel.setFont(new Font("Elephant",Font.BOLD, 16));

        labelUserName.setBounds(50,110,150,20);
        labelUserName.setFont(new Font("Alice", Font.BOLD, 16));
        usernameTextField.setBounds(200,110,150,20);

        

        labelPass.setBounds(50,160,150,20);
        labelPass.setFont(new Font("Elephant", Font.BOLD, 16));
        passwordTextField.setBounds(200,160,150,20);


        //setBounds
        btnChangePassword.setBounds(130,210,200,20);
        backButton.setBounds(650,360,120,20);
        exitButton.setBounds(650,400,120,20);
        //adminLoginButton.setBounds(550,30,100,15);

        //
        btnChangePassword.setBackground(Color.CYAN);
        btnChangePassword.setOpaque(true);

        backButton.setBackground(Color.BLACK);
        backButton.setOpaque(true);
        backButton.setForeground(Color.WHITE);

        exitButton.setBackground(Color.PINK);
        exitButton.setOpaque(true);

        //actionListner

        btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            String user = usernameTextField.getText();
               char charPass[] = passwordTextField.getPassword();
               String pass = String.valueOf(charPass);
               if(user.equals("") || pass.equals("")){
                JOptionPane.showMessageDialog(null, "Field can't be empty");
                }
                else{
                    try{
                        BufferedWriter write = new BufferedWriter(new FileWriter("Files/Admin/creds.txt"));//append = false
                        write.write(user + ":" + pass);// : used to separet infos
                        write.close();
                        JOptionPane.showMessageDialog(null, "Password Changed Successfully");
                   }catch(IOException ex){
                        ex.printStackTrace();
                   }
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
        frame.getContentPane().add(btnChangePassword);
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
