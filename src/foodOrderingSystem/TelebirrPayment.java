package foodOrderingSystem;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelebirrPayment {
    protected void showTeleBirrPaymentOption(){

        Random random = new Random();
        int code = random.nextInt(9999);

        Icon iconQRCode = new ImageIcon("icons/teleQRcode.png");
        JFrame frame = new JFrame("Telebirr");
        JLabel lblScan = new JLabel("Scan Me");

        JLabel secretCodeLabel = new JLabel("Secret Code: "+code);
        JLabel QRcodeLabel = new JLabel(iconQRCode);
        JLabel telebirrWebLinkLabel = new JLabel("Telebirr web link: https://www.ethiotelecom.et/telebirr/");
        JLabel teleBirrAppLink = new JLabel("Telebirr App link: https://play.google.com/store/apps/details?id=cn.tydic.ethiopay");
        JButton backButton = new JButton("Back");


        //wallpaper
	    frame.setContentPane(new JLabel(new ImageIcon("images/telePayment.png")));
        

        QRcodeLabel.setBounds(100,150,132,132);
        lblScan.setBounds(130,270,200,50);
        secretCodeLabel.setBounds(130,290,200,50);
        secretCodeLabel.setForeground(Color.RED);


        telebirrWebLinkLabel.setBounds(100,310,600,50);
        telebirrWebLinkLabel.setForeground(Color.GREEN);
        teleBirrAppLink.setBounds(100,330,600,50);
        teleBirrAppLink.setForeground(Color.GREEN);
 

        //back Button
        backButton.setBounds(660,370,150,20);
        backButton.setBackground(Color.PINK);

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                FoodMenu foodMenu = new FoodMenu();
                foodMenu.showFoodMenuGUI();
                frame.dispose();
			}
		});

        //add to frame
        frame.getContentPane().add(QRcodeLabel);
        frame.getContentPane().add(lblScan);
        frame.getContentPane().add(secretCodeLabel);
        frame.getContentPane().add(telebirrWebLinkLabel);
        frame.getContentPane().add(teleBirrAppLink);
        frame.getContentPane().add(backButton);

        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
