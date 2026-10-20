package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    JButton addemp, viewemp, updateemp, deleteemp, logoutbtn; //buttons to add/view/update/delete employees or log out of the screen
    Home(){
        setLayout(null); 
        
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("photos/emphomepage.jpg")); //the cover page for the home
        Image img2= img1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel img= new JLabel(img3);
        img.setBounds(0, 0, 1120, 630);
        add(img); 
        
        
        JLabel heading = new JLabel("Employee Management System"); //the title of the "Home" app
        heading.setBounds(350, 20, 600, 40);  
        heading.setFont(new Font("tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        img.add(heading);
        
        
        addemp= new JButton("Add an Employee"); //button+text "Add an Employee"
        addemp.setBounds(350, 190, 175, 55);
        addemp.setFont(new Font("tahoma", Font.BOLD, 13));
        addemp.addActionListener(this);
        img.add(addemp);
        
        viewemp= new JButton("View an Employee"); //button+text "View an Employee"
        viewemp.setBounds(650, 190, 175, 55);
        viewemp.setFont(new Font("tahoma", Font.BOLD, 13));
        viewemp.addActionListener(this);
        img.add(viewemp);
        
        updateemp= new JButton("Update an Employee"); //button+text "Update an Employee"
        updateemp.setBounds(350, 380, 175, 55);
        updateemp.setFont(new Font("tahoma", Font.BOLD, 13));
        updateemp.addActionListener(this);
        img.add(updateemp);
        
        deleteemp= new JButton("Delete an Employee"); //button+text "Delete an Employee"
        deleteemp.setBounds(650, 380, 175, 55);
        deleteemp.setFont(new Font("tahoma", Font.BOLD, 13));
        deleteemp.addActionListener(this);
        img.add(deleteemp);
        
        logoutbtn= new JButton("Logout"); //button+text "Logout"
        logoutbtn.setBounds(965, 20, 120, 35);
        logoutbtn.setFont(new Font("tahoma", Font.BOLD, 13));
        logoutbtn.addActionListener(this);
        img.add(logoutbtn);
        
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addemp) /*if we click the "Add Employee" button we navigate to "Add Employee", so for the other because getSource() indicates 
            which button was clicked; for the other ones it is similar*/
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == viewemp)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == updateemp)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == deleteemp){
            setVisible(false);
            new DeleteEmployee();
        }
        if(ae.getSource() == logoutbtn)
        {
            setVisible(false);
            new Splash();
        }
    }
    public static void main(String[]args){
        new Home();
    }
}
