package foodOrderingSystem;

interface Form {
    //interface
    void login(String user, String pass, String path); //done --->admin + user

    void register(String fname, String lname, String email, String usrname, String pass, String phone, String address);//done

    void deleteAccount(String user, String pass, String path); //done

    void calculatePrice(double burger, double dorowot, double macaroni, double pizza, double rice, double salad);//done

    void feedBack(String msg); //done

    void paymentOption(); //done

    void notifications(); //done
    
    
}
