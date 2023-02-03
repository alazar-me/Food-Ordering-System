package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.Icon;
import java.lang.NumberFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FoodMenu extends ImplementForm {
    void showFoodMenuGUI(){

        Icon burgerIcon = new ImageIcon("foodImages/burger.png");
        Icon dorowotIcon = new ImageIcon("foodImages/dorowot.png");
        Icon macaroniIcon = new ImageIcon("foodImages/macaroni.png");
        Icon pizzaIcon = new ImageIcon("foodImages/pizza.png");
        Icon riceIcon = new ImageIcon("foodImages/rice.png");
        Icon saladIcon = new ImageIcon("foodImages/salad.png");

        JFrame frame = new JFrame("Food Menu");
        
	    frame.setContentPane(new JLabel(new ImageIcon("images/login.png")));

        //food icon labels
        JLabel burgerImg = new JLabel(burgerIcon);
        JLabel dorowotImg = new JLabel(dorowotIcon);
        JLabel macaroniImg = new JLabel(macaroniIcon);
        JLabel pizzaImg = new JLabel(pizzaIcon);
        JLabel riceImg = new JLabel(riceIcon);
        JLabel saladImg = new JLabel(saladIcon);

        //name and price label
        JLabel lblBurger = new JLabel("Burger: 120.00 Birr");
        JLabel lblDorowot = new JLabel("Dorowot: 150.00 Birr");
        JLabel lblMacaroni = new JLabel("Macaroni: 70.00 Birr");
        JLabel lblPizza = new JLabel("Pizza: 180.00 Birr");
        JLabel lblRice = new JLabel("Rice: 50.00 Birr");
        JLabel lblSalad = new JLabel("Salad: 60 Birr");

        //food textfields
        JTextField burgerTF = new JTextField("0");
        JTextField dorowotTF = new JTextField("0");
        JTextField macaroniTF = new JTextField("0");
        JTextField pizzaTF = new JTextField("0");
        JTextField riceTF = new JTextField("0");
        JTextField saladTF = new JTextField("0");


                

        ////////////////////////////////////////
        //icon labels set bound
        burgerImg.setBounds(30,30,100,100);
        dorowotImg.setBounds(30,250,100,100);
        macaroniImg.setBounds(200,30,100,100);
        pizzaImg.setBounds(200,250,100,100);
        riceImg.setBounds(360,30,100,100);
        saladImg.setBounds(360,250,100,100);

        /////////////
        lblBurger.setBounds(30,140,150,20);
        lblBurger.setForeground(Color.WHITE);

        lblDorowot.setBounds(30,360,150,20);
        lblDorowot.setForeground(Color.WHITE);

        lblMacaroni.setBounds(200,140,150,20);
        lblMacaroni.setForeground(Color.WHITE);

        lblPizza.setBounds(200,360,150,20);
        lblPizza.setForeground(Color.WHITE);

        lblRice.setBounds(360,140,150,20);
        lblRice.setForeground(Color.WHITE);

        lblSalad.setBounds(360,360,150,20);
        lblSalad.setForeground(Color.WHITE);



        /////////////

        burgerTF.setBounds(60,180,50,20);
        dorowotTF.setBounds(60,390,50,20);

        macaroniTF.setBounds(220,180,50,20);
        pizzaTF.setBounds(220,390,50,20);

        riceTF.setBounds(380,180,50,20);
        saladTF.setBounds(380,390,50,20);
        //potatoTF.setBounds(360,310,100,100);



        ////table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(550,50,270,200);
        
          
        ///buttons
        JButton calculateButton = new JButton("Calculate");
        JButton orderButton = new JButton("Order");
        JButton backButton = new JButton("Back");
        JButton exitButton = new JButton("Exit");

        calculateButton.setBounds(630,270,100,20);
        calculateButton.setBackground(Color.CYAN);
        calculateButton.setOpaque(true);

        orderButton.setBounds(550,350,100,20);
        orderButton.setBackground(Color.PINK);

        backButton.setBounds(660,350,150,20);
        backButton.setBackground(Color.PINK);

        exitButton.setBounds(550,380,100,20);
        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);

        //Total label

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setBounds(600,300,60,20);

        //price label

        JLabel priceLabel = new JLabel("0.00");
        priceLabel.setBounds(670,300,100,20);



        ////////////////
        ///ActionListener
        //**********************
        calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try{
                    int burger = Integer.parseInt(burgerTF.getText());
                    int dorowot = Integer.parseInt(dorowotTF.getText());
                    int macaroni = Integer.parseInt(macaroniTF.getText());
                    int pizza = Integer.parseInt(pizzaTF.getText());
                    int rice = Integer.parseInt(riceTF.getText());
                    int salad = Integer.parseInt(saladTF.getText());

                    calculatePrice(burger, dorowot, macaroni, pizza, rice, salad); //exteded from implementForm

                    String[] columns = {"Name", "Qty", "Price", "Total"};
        
                    String[][] data = {{"Burger", String.valueOf(burger), String.valueOf(burgerPrice), String.valueOf(totalBurger)},
                                        {"Dorowot", String.valueOf(dorowot), String.valueOf(dorowotPrice), String.valueOf(totalDorowot)},
                                        {"Macaroni", String.valueOf(macaroni),String.valueOf(macaroniPrice),String.valueOf(totalMacaroni),},
                                        {"Pizza", String.valueOf(pizza),String.valueOf(pizzaPrice),String.valueOf(totalPizza)},
                                        {"Rice", String.valueOf(rice),String.valueOf(ricePrice),String.valueOf(totalRice)},
                                        {"Salad", String.valueOf(salad),String.valueOf(saladPrice), String.valueOf(totalSalad)}};
                    
                    JTable table = new JTable(data,columns);
                    table.setBackground(Color.DARK_GRAY);
                    table.setForeground(Color.WHITE);


                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(550,50,270,200);
                    frame.getContentPane().add(scrollPane);

                    priceLabel.setText(String.valueOf(totalPrice)+" Birr");

                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Quantity field can not be letters or symbols.");
                }
                
			}
		});
        orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if(totalPrice==0.0){
                    JOptionPane.showMessageDialog(null, "No order yet");
                }
                else{
                    PaymentOptions paymentOptions = new PaymentOptions();
                    paymentOptions.showPaymentOption();
                    frame.dispose();
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

        //add icons labes to frame
        //frame.getContentPane().add(welcomeLabel);

        frame.getContentPane().add(burgerImg);
        frame.getContentPane().add(dorowotImg);
        frame.getContentPane().add(macaroniImg);
        frame.getContentPane().add(pizzaImg);
        frame.getContentPane().add(riceImg);
        frame.getContentPane().add(saladImg);

        //name and price label

        frame.getContentPane().add(lblBurger);
        frame.getContentPane().add(lblDorowot);
        frame.getContentPane().add(lblMacaroni);
        frame.getContentPane().add(lblPizza);
        frame.getContentPane().add(lblRice);
        frame.getContentPane().add(lblSalad);

        //add textfields to the frame
        frame.getContentPane().add(burgerTF);
        frame.getContentPane().add(dorowotTF);
        frame.getContentPane().add(macaroniTF);
        frame.getContentPane().add(pizzaTF);
        frame.getContentPane().add(riceTF);
        frame.getContentPane().add(saladTF);


        //scrollPane
        frame.getContentPane().add(scrollPane);
        //total and price label
        frame.getContentPane().add(totalLabel);
        frame.getContentPane().add(priceLabel);

        //add buttons
        frame.getContentPane().add(calculateButton);
        frame.getContentPane().add(orderButton);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(exitButton);

        

        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
