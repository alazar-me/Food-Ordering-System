package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome {
    protected void showWelcomeGUI(){
        Icon nextIcon = new ImageIcon("icons/next.png"); //icon for next button
        JFrame frame = new JFrame("Welcome");

        JLabel welcomeLabel = new JLabel("WELCOME");
        JButton nextButton = new JButton(nextIcon); //assign icon to jbutton 

        //set backgroug image
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu1.png")));

        welcomeLabel.setBounds(350,50,300,50);
        welcomeLabel.setFont(new Font("ARIEL",Font.BOLD, 30));
        welcomeLabel.setForeground(Color.MAGENTA);

        nextButton.setBounds(320,200,250,50); //x,y,w,h
        nextButton.setBackground(Color.BLACK);
        nextButton.setOpaque(true);
        nextButton.setForeground(Color.WHITE);

        //action listner
        nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Login loginPage = new Login();
                loginPage.displayLoginPage();
                frame.dispose(); //close the privious frame
			}
		});

        //add to frame
        frame.getContentPane().add(welcomeLabel);
        frame.getContentPane().add(nextButton);

        frame.setSize(854,480);//frame size
        frame.setResizable(false); //
        frame.setLayout(null); //
        frame.setLocationRelativeTo(null); //center
        frame.setVisible(true); //visbility
    }
}
