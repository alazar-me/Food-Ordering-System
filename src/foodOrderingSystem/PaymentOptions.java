package foodOrderingSystem;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import java.util.Random;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class PaymentOptions {

    void showPaymentOption() {
        JFrame frame = new JFrame("Payment Options");
        Icon telebirrIcon = new ImageIcon("icons/telebirr.png");
        Icon cashIcon = new ImageIcon("icons/cash2.png");//cash.png
        //frame.setIconImage();
        JLabel paymentLabel = new JLabel("Payment Options");
        JButton telebirrButton = new JButton(telebirrIcon);
        JButton cashButton = new JButton(cashIcon);
        JButton exitButton = new JButton("Exit");
        JButton btnCancelOrder = new JButton("Cancel Order");
        //Button adminLoginButton = new JButton("Admin");

        //add image to background
        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        paymentLabel.setBounds(380,50,300,50);
        paymentLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        paymentLabel.setForeground(Color.WHITE);

        telebirrButton.setBounds(240,150,400,50);
        cashButton.setBounds(240,220,400,50);
        btnCancelOrder.setBounds(370,300,200,20);
        exitButton.setBounds(600,400,120,20);

        btnCancelOrder.setBackground(Color.PINK);
        btnCancelOrder.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);


        telebirrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                TelebirrPayment telebirr = new TelebirrPayment();
                telebirr.showTeleBirrPaymentOption();
                frame.dispose();
			}
		});

        cashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int code = random.nextInt(9999);
                JOptionPane.showMessageDialog(null, "Food will be delivered soon \nThanks for using our service\nSecret Code: "+code);
                FoodMenu foodMenu = new FoodMenu();
                foodMenu.showFoodMenuGUI();
                frame.dispose();

			}
		});


        btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                FoodMenu foodMenu = new FoodMenu();
                foodMenu.showFoodMenuGUI();
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
        frame.getContentPane().add(paymentLabel);
        frame.getContentPane().add(telebirrButton);
        frame.getContentPane().add(cashButton);
        frame.getContentPane().add(btnCancelOrder);
        frame.getContentPane().add(exitButton);
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
