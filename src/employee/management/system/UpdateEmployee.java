package employee.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfaddsname, tfphonenr, tfempsalary;
    JButton bkbtn, addempdetails;
    JDateChooser calendar_dob;
    JComboBox degrees;
    String emp_name;
    UpdateEmployee(String emp_name){
        this.emp_name= emp_name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        String[] educationlevels= {"Bachelor", "Master", "PhD"};
        JLabel heading= new JLabel("Update Employee Details");
        heading.setBounds(315, 30, 500, 50);
        heading.setFont(new Font("tahoma", Font.BOLD, 25));
        add(heading);
        
        JLabel fname = new JLabel("Name:");
        fname.setBounds(50, 150, 150, 30);
        fname.setFont(new Font("tahoma", Font.BOLD, 20));
        add(fname);
        
        JLabel lbl_fname = new JLabel();
        lbl_fname.setBounds(200, 150, 150, 30);
        add(lbl_fname);
        
        
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
        
        addempdetails= new JButton("Update Employee Details");  
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
        
        
        
        
        try{
            Conn c= new Conn();
            String sql_query= "SELECT * from employee WHERE emp_name= '"+emp_name+"'";
            ResultSet rs= c.s.executeQuery(sql_query);
            
            
            while(rs.next()){ /*this will show all the data that is from the row with the name emp_name so that the
                user can see which data he has now and how he wants to change it*/
                lbl_fname.setText(rs.getString("emp_name"));
                tfaddsname.setText(rs.getString("emp_surname"));
                tfphonenr.setText(rs.getString("emp_phonenr"));
                tfempsalary.setText(rs.getString("emp_salary"));               
            }
        }
        catch(Exception e){
           e.printStackTrace();
        }
     
        
        
        setSize(900, 700); //the width and height of the pane
        setLocation(300, 50); //how far is it in terms of x- and y-coordinates of the screen
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == addempdetails){ //everything except the name (since it is a primary key) will be updated
            String emp_surname= tfaddsname.getText();
            String emp_phonenr= tfphonenr.getText();
            String emp_salary= tfempsalary.getText();
            String emp_education= (String) degrees.getSelectedItem();
            String emp_dob = ((JTextField) calendar_dob.getDateEditor().getUiComponent()).getText();
            try{
                Conn conn = new Conn();
                String sql_query= "UPDATE employee SET emp_surname='"+emp_surname+"', emp_phonenr = '"+emp_phonenr+"', emp_salary = '"+emp_salary+"', emp_education = '"+emp_education+"', emp_dob = '"+emp_dob+"' WHERE emp_name= '"+emp_name+"'";
                conn.s.executeUpdate(sql_query);
                JOptionPane.showMessageDialog(null, "Details updated successfully!");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
                 
        } else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[]args){
        new UpdateEmployee("");
    }
}
