package foodOrderingSystem;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ImplementForm implements Form {
    String fristName;
    String lastName;
    String emailAddress;
    String username;
    String password;
    String newPassword;
    String confirmPassword;
    String phone;
    String address;
    String message;
    String PATH;
    boolean creadentialsCorrect=false;

    double burgerPrice = 120.00, dorowotPrice=150.00, macaroniPrice=70.00 ,pizzaPrice=180.00, ricePrice=50.00, saladPrice=60.00;
    double burgerQty, dorowotQty, macaroniQty ,pizzaQty, riceQty, saladQty;
    double totalBurger, totalDorowot, totalMacaroni, totalPizza, totalRice, totalSalad;
    double totalPrice;


    @Override
    public void login(String user, String pass, String path) {

        username = user;
        password = pass;
        PATH = path;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            String line = null;
            String user_f;
            String passwd_f;
            String adminPath = "Files/Admin/creds.txt";
            while ((line = reader.readLine()) != null) {
                String[] creadentials = line.split(":"); //array creadentials admin:admin

                if(PATH.equals(adminPath)){
                    user_f = creadentials[0];
                    passwd_f = creadentials[1];
                }
                else{//user
                    user_f = creadentials[3];
                    passwd_f = creadentials[4];
                }

                if (username.equals(user_f) && password.equals(passwd_f)) {
                    creadentialsCorrect = true;
                    break;
                }
            }
            reader.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }      
        
    }

    @Override            //index  0             1            2              3              4            5              6
    public void register(String fname, String lname, String email, String usrname, String pass, String phone, String address) {
                fristName = fname;
                lastName = lname;
                emailAddress = email;
                username = usrname;
                password = pass;
                this.phone = phone;
                this.address = address;
                try {
                    BufferedWriter write = new BufferedWriter(new FileWriter("Files/User/information.txt", true));//append = true
                    write.write(fristName + ":" + lastName + ":" + emailAddress + ":" + username + ":" + password + ":" + phone + ":" +address);// : used to separet infos
                    write.newLine();
                    write.close();
                    JOptionPane.showMessageDialog(null, "Registered Successfully!");
                    Login loginPage = new Login();
                    loginPage.displayLoginPage();
                } 
                catch (IOException e1) {
                    e1.printStackTrace();
                }

        
    }

    @Override
    public void deleteAccount(String user, String pass, String path) {
        String userCheck = user;
        String passCheck = pass;
        PATH = path;
        Scanner scanner;
        String tempFile = "temp.txt";
        File oldFile = new File(PATH);
        File newFIle = new File(tempFile);

        fristName="";
        lastName="";
        emailAddress="";
        username="";
        password="";
        phone="";
        address="";


        try{
            FileWriter fwriter = new FileWriter(tempFile,true);
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            PrintWriter pwriter = new PrintWriter(bwriter);

            scanner = new Scanner(new File(PATH));
            scanner.useDelimiter("[:\n]");

            while(scanner.hasNext()){
                fristName=scanner.next();
                lastName=scanner.next();
                emailAddress=scanner.next();
                username=scanner.next();
                password=scanner.next();
                phone=scanner.next();
                address=scanner.next();

                if(!(username.equals(userCheck) && password.equals(passCheck))){ //not true
                    pwriter.println(fristName+":"+lastName+":"+emailAddress+":"+username+":"+password+":"+ phone+":"+address);
                }
                scanner.close();
                pwriter.flush();
                pwriter.close();
                oldFile.delete();
                File dump = new File(PATH);
                newFIle.renameTo(dump);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        

        
        
    }
    @Override
    public void feedBack(String msg) {
        message = msg;  
           try {
            BufferedWriter write = new BufferedWriter(new FileWriter("Files/User/feedback.txt", true));//append = true
            write.write(message + "\n--------------------------------------------------------------------------------------------\n--------------------------------------------------------------------------------------------");
            write.newLine();
            write.close();
            JOptionPane.showMessageDialog(null, "Done");
            MainMenu menu = new MainMenu();
            menu.displayMainMenu();
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void paymentOption() {
        
    }

    
    @Override
    public void notifications() {
        String line = "dfasdfasfsdf sdfa dsfsa fasd";
        try {
            try (BufferedReader read = new BufferedReader(new FileReader("Files/User/feedback.txt"))) {
                while((line=read.readLine())!=null) {
                    //String se =se.concat();
                    line += line;
                }
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        
    }

    @Override
    public void calculatePrice(double burger, double dorowot, double macaroni, double pizza, double rice, double salad) {
            burgerQty = burger; dorowotQty=dorowot; macaroniQty=macaroni; pizzaQty=pizza; riceQty=rice; saladQty=salad;

            totalBurger = (burgerPrice * burgerQty); //120.00 * 0
            totalDorowot = (dorowotPrice*dorowotQty); //150.00 * 2
            totalMacaroni = (macaroniPrice*macaroniQty);
            totalPizza = (pizzaPrice*pizzaQty);
            totalRice = (ricePrice*riceQty);
            totalSalad = (saladPrice*saladQty);
            totalPrice = totalBurger + totalDorowot + totalMacaroni + totalPizza + totalRice + totalSalad;
                
    }
}
