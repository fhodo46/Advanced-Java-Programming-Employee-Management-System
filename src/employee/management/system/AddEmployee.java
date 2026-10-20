package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.util.Random;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfaddfname, tfaddsname, tfphonenr, tfempsalary; //we enter the name, surname, phone number, and the salary in a textual format so we choose the JTextField 
    JDateChooser calendar_dob; //the date of birth will be from a calendar so JDateChooser provides calendars
    JButton bkbtn, addempdetails; //back + "Add Employee Details" button
    JComboBox degrees; //the user has to choose one of the three degree options: Bachelor's, Master's, or PhD
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        String[] educationlevels= {"Bachelor", "Master", "PhD"}; //the choices are in the form of an array of strings
        JLabel heading= new JLabel("Add Employee Details"); //the title "Add Employee Details"
        heading.setBounds(315, 30, 500, 50);
        heading.setFont(new Font("tahoma", Font.BOLD, 25));
        add(heading);
        
        JLabel fname = new JLabel("Name:"); /*the text "Name" and it is similar for the surname, date of birth, 
        phone number, salary, and the education*/
        fname.setBounds(50, 150, 150, 30);
        fname.setFont(new Font("tahoma", Font.BOLD, 20));
        add(fname);
        
        tfaddfname= new JTextField(); //text field to update the name and it is similar for other fields
        tfaddfname.setBounds(200, 150, 150, 30);
        add(tfaddfname);
        
        
        JLabel sname = new JLabel("Surname:");
        sname.setBounds(470, 150, 150, 30);
        sname.setFont(new Font("tahoma", Font.BOLD, 20));
        add(sname);
        
        
        tfaddsname= new JTextField();
        tfaddsname.setBounds(670, 150, 150, 30);
        add(tfaddsname);
        
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setBounds(50, 425, 150, 30);
        dob.setFont(new Font("tahoma", Font.BOLD, 20));
        add(dob);
        
        
        calendar_dob = new JDateChooser();
        calendar_dob.setBounds(200, 425, 150, 30);
        add(calendar_dob);
        
        
        
        
        
        
        
        JLabel phonenr = new JLabel("Phone number:");
        phonenr.setBounds(470, 295, 175, 30);
        phonenr.setFont(new Font("tahoma", Font.BOLD, 20));
        add(phonenr); 
        
        
        tfphonenr= new JTextField();
        tfphonenr.setBounds(670, 295, 150, 30);
        add(tfphonenr);
        
        
        
        JLabel empsalary = new JLabel("Salary: ");
        empsalary.setBounds(50, 295, 150, 30);
        empsalary.setFont(new Font("tahoma", Font.BOLD, 20));
        add(empsalary);
                
        tfempsalary = new JTextField();
        tfempsalary.setBounds(200, 295, 150, 30);
        add(tfempsalary);
        JLabel empeducation = new JLabel("Education: ");
        empeducation.setBounds(470, 425, 150, 30);
        empeducation.setFont(new Font("tahoma", Font.BOLD, 20));
        add(empeducation);              
        degrees= new JComboBox(educationlevels);
        degrees.setBounds(670, 425, 150, 30);
        add(degrees);  
        
        addempdetails= new JButton("Add Employee Details");
        addempdetails.setBounds(240, 550, 185, 50);
        addempdetails.setFont(new Font("tahoma", Font.BOLD, 13));
        addempdetails.setBackground(Color.BLACK);
        addempdetails.setForeground(Color.WHITE);
        addempdetails.addActionListener(this);
        add(addempdetails);
        
        
        
        
        bkbtn= new JButton("Back");
        bkbtn.setBounds(475, 550, 185, 50);
        bkbtn.setFont(new Font("tahoma", Font.BOLD, 13));
        bkbtn.setBackground(Color.BLACK);
        bkbtn.setForeground(Color.WHITE); 
        bkbtn.addActionListener(this);
        add(bkbtn);
     
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == addempdetails){ /*if we click the button "Add Employee Details" we get the values
            from the employee name, surname, phone number, salary, education, and date of birth and we want to insert
            them into the database*/
            String emp_name = tfaddfname.getText();
            String emp_surname= tfaddsname.getText();
            String emp_phonenr= tfphonenr.getText();
            String emp_salary= tfempsalary.getText();
            String emp_education= (String) degrees.getSelectedItem(); //type casting from a list of options to a string to put them in the database properly
            String emp_dob = ((JTextField) calendar_dob.getDateEditor().getUiComponent()).getText(); //type casting but from calendar date that is picked from a calendar to a string
            try{
                Conn conn = new Conn(); //we need a connection object to establish the connection
                String sql_query= "INSERT INTO employee VALUES('"+emp_name+"', '"+emp_surname+"', '"+emp_phonenr+"', '"+emp_salary+"', '"+emp_education+"', '"+emp_dob+"')";
                //the values that were entered by the user will be shown in the database if he clicks the "Add Employee Details" button 
                conn.s.executeUpdate(sql_query); //executes the query
                JOptionPane.showMessageDialog(null, "Employee added successfully!"); /*if there is no error in the SQL/Java code the message that the employee was added successfully
                will be shown to let the user know about it and it will navigate the user to the home*/
                setVisible(false);
                new Home();
            }
            catch(Exception e){ //for any Java/SQL error an error message will be shown
                e.printStackTrace();
            }
                 
        } else{ setVisible(false); //if the user clicks only "Back" he navigates to the "Home" page
            new Home();
        }
    }
    public static void main(String[]args){
        new AddEmployee();
    }
}
