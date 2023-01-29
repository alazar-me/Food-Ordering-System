package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Registration extends ImplementForm{
    public void getInfo(){
       
    }
    protected void showRegisterPage(){
        JFrame frame = new JFrame("Registration");
       
        //frame.setIconImage();
        //JLabels
        JLabel createAccountLabel = new JLabel("Create Account");
        JLabel fnameLabel = new JLabel("First Name");
        JLabel lnameLabel = new JLabel("Last Name");
        JLabel emailLabel = new JLabel("Email Address");
        JLabel usernamLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("New Password");
        JLabel passwordConfirmLabel = new JLabel("Confirm Password");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel AddressLabel = new JLabel("Address");

        //JTextFields
        JTextField fnameTextfield = new JTextField();
        JTextField lnameTextField = new JTextField();
        JTextField emailTextfield = new JTextField();
        JTextField usernameTextField = new JTextField();
        JPasswordField newPasswordTextField = new JPasswordField();
        JPasswordField passwordConfirmTField = new JPasswordField();
        JTextField phoneTextfield = new JTextField("+251 9");
        JTextField AddressTextField = new JTextField();
        
        
        //JButtons
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");
        JButton exitButton = new JButton("Exit");     
        
        

        //add image to background
        frame.setContentPane(new JLabel(new ImageIcon("images/registration.png")));
        
        
        createAccountLabel.setFont(new Font("Elephant",Font.BOLD, 25));
       
        //JLabel Set Bound
        createAccountLabel.setBounds(130,30,450,50);
        fnameLabel.setBounds(80,100,150,20);
        lnameLabel.setBounds(80,130,150,20);
        emailLabel.setBounds(80,160,150,20);
        usernamLabel.setBounds(80,190,150,20);
        passwordLabel.setBounds(80,220,150,20);
        passwordConfirmLabel.setBounds(80,250,150,20);
        phoneLabel.setBounds(80,280,150,20);
        AddressLabel.setBounds(80,310,150,20);

        //JTextField setBounds
        fnameTextfield.setBounds(230,100,150,20);
        lnameTextField.setBounds(230,130,150,20);
        emailTextfield.setBounds(230,160,150,20);
        usernameTextField.setBounds(230,190,150,20);
        newPasswordTextField.setBounds(230,220,150,20);
        passwordConfirmTField.setBounds(230,250,150,20);
        phoneTextfield.setBounds(230,280,150,20);
        AddressTextField.setBounds(230,310,150,20);
    
        //JButtons setBounds
        registerButton.setBounds(130,350,150,20);
        backButton.setBounds(650,370,120,20);
        exitButton.setBounds(650,400,120,20);

        //button colorizing
        registerButton.setBackground(Color.CYAN);
        registerButton.setOpaque(true); //make the button shapes rectangular
        //registerButton.setBorderPainted(false);

        backButton.setBackground(Color.CYAN);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        //action listner
        registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String fname = fnameTextfield.getText(); //hello
                String lname = lnameTextField.getText();
                String email = emailTextfield.getText();
                String usrname = usernameTextField.getText();
                
                char[] newPass = newPasswordTextField.getPassword();// ['h', 'e', 'l', 'l', 'o']
                char[] confirmPass = passwordConfirmTField.getPassword();// ['h', 'e', 'l', 'l', 'o']

                String newPassword = String.valueOf(newPass); //hello
                String confirmPassword = String.valueOf(confirmPass);

                String password;
                String phone = phoneTextfield.getText();
                String address = AddressTextField.getText();

                
                if(fname.equals("") || lname.equals("") || email.equals("") || usrname.equals("") || newPassword.equals("") || confirmPassword.equals("") || phone.equals("") || address.equals("")){
                    JOptionPane.showMessageDialog(null, "Text fields cannot be empty");
                }
                else{
                    if(newPassword.equals(confirmPassword)){
                        password = newPassword;
                        register(fname,lname,email,usrname, password,phone,address); // register --> extended from ImplementForm
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Password Field does not match");
                       
                    }             

                }
                



			}
		});

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
                Login back = new Login();
                back.displayLoginPage();
                frame.dispose();                

			}
		});


        exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0); //exit
			}
		});
        

        //add labels to frame
        frame.getContentPane().add(createAccountLabel);
        frame.getContentPane().add(fnameLabel);
        frame.getContentPane().add(lnameLabel);
        frame.getContentPane().add(emailLabel);
        frame.getContentPane().add(usernamLabel);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(passwordConfirmLabel);
        frame.getContentPane().add(phoneLabel);
        frame.getContentPane().add(AddressLabel);
        
        //add textfields to frame
        frame.getContentPane().add(fnameTextfield);
        frame.getContentPane().add(lnameTextField);
        frame.getContentPane().add(emailTextfield);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(newPasswordTextField);
        frame.getContentPane().add(passwordConfirmTField);
        frame.getContentPane().add(phoneTextfield);
        frame.getContentPane().add(AddressTextField);


        //add buttons to frame
        frame.getContentPane().add(registerButton);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);

        
        
        frame.setSize(854,480);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//location [+]center
        frame.setVisible(true);
    }
}
