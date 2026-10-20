package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField tfielduname, tfieldpassword; //for username and password and it is a place where the user can enter those
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel unamelabel = new JLabel("Username"); //the text "Username"
        unamelabel.setBounds(40, 20, 100, 30);
        add(unamelabel);
        
        tfielduname= new JTextField(); //the text field of the "Username"
        tfielduname.setBounds(150,20,150,30);
        add(tfielduname);
        
        JLabel passwordlabel = new JLabel("Password"); //the text "Password"
        passwordlabel.setBounds(40, 70, 100, 30);
        add(passwordlabel);
        
        tfieldpassword= new JPasswordField(25); //the text field of the "Password"
        tfieldpassword.setBounds(150,70,150,30);
        add(tfieldpassword);
        
        JButton login = new JButton("Login"); //the "Login" button
        login.setBounds(150, 140, 150, 30);
        login.addActionListener(this);
        add(login);
       
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("photos/employeelogin.png")); //user visual icon the user sees to the right
        Image img2= img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel img= new JLabel(img3);
        img.setBounds(50, 10, 730, 100);
        add(img);
        
        setSize(550, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
   
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            String uname= tfielduname.getText(); //the value that is taken after the user enters his username
            String pword= tfieldpassword.getText(); //the value that is taken after the user enters his password
            Conn c= new Conn();
            String query= "SELECT * from login WHERE uname='"+ uname + "' and pword='" + pword + "'"; /*the username and 
            the password have been defined in the database and we check whether the current 
            information we entered matches both with the username and password */
            ResultSet rs= c.s.executeQuery(query); /*A Statement object is used for the DB access and is useful for executing SQL statements*/
            
            if(rs.next()){ //after query execution, if the data matches, the user is logged to Home only if the username and the password are correct 
                setVisible(false);
                new Home();
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Invalid inputs"); //If the data are incorrect the message "Invalid inputs" will be shown      
            }
            
          }
        
        catch(Exception e){
            e.printStackTrace(); /*SQL is an external entity so there might be errors in the processing and we catch any
            //possible SQL errors with printStackTrace() */
        }
    }
    public static void main(String[]args){
        new Login();
    }
}