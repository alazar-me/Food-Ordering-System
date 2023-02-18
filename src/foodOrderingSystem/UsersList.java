package foodOrderingSystem;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class UsersList{
    void usersListGUI(){
        JFrame frame = new JFrame("Users List");

        JLabel usrListLabel = new JLabel("Users Information");
        JButton exitButton = new JButton("Exit");
        JButton backButton = new JButton("Back");
        JButton btnImportData = new JButton("Import Data");

        JTable table = new JTable();

        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40,50,774,300);


        frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("images/menu.png")));
	    frame.setLayout(new FlowLayout());
        
        usrListLabel.setBounds(380,10,300,50);
        usrListLabel.setFont(new Font("ALGERIAN",Font.BOLD, 18));
        usrListLabel.setForeground(Color.WHITE);

        

        //panel.add(scrollpane);

        btnImportData.setBounds(350,370,120,20);
        backButton.setBounds(600,370,120,20);
        exitButton.setBounds(600,400,120,20);

        btnImportData.setBackground(Color.BLACK);
        btnImportData.setOpaque(true);
        btnImportData.setForeground(Color.WHITE);
        
        backButton.setBackground(Color.PINK);
        backButton.setOpaque(true);

        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setForeground(Color.WHITE);
        
        btnImportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                try{
                    try (BufferedReader reader = new BufferedReader(new FileReader("Files/User/information.txt"))) {
                        String[] columnsName = {"FirsName", "LastName", "Email", "Username", "Password", "Phone", "Address"};
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setColumnIdentifiers(columnsName);
      
                        Object[] tableRows = reader.lines().toArray();
                        for(int i=0; i<tableRows.length; i++){
                            String ln = tableRows[i].toString();
                            String[] dataRow = ln.split(":");
                            model.addRow(dataRow);
                        }
                    }
                
                }catch (IOException ex){
                    //ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
			}
		});

        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //
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
      

        frame.getContentPane().add(usrListLabel);
        frame.getContentPane().add(btnImportData);
        frame.getContentPane().add(backButton);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(exitButton);
        //frame.getContentPane().add(panel);
        
        //frame.getContentPane().add(adminLoginButton);
        
        
        frame.setSize(854,480);//480p
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
