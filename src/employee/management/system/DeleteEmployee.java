package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteEmployee extends JFrame implements ActionListener{
    
    Choice employee_name;
    JButton delete_employee, bkbtn;
    
    DeleteEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempname = new JLabel("Employee Name");
        labelempname.setBounds(50, 50, 100, 30);
        add(labelempname);
        
        employee_name = new Choice();
        employee_name.setBounds(200, 50, 150, 30);
        add(employee_name);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                employee_name.add(rs.getString("emp_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          
        JLabel labelsurname = new JLabel("Surname:");
        labelsurname.setBounds(50, 129, 100, 30);
        add(labelsurname);
        
        JLabel lblsurname = new JLabel();
        lblsurname.setBounds(200, 129, 100, 30);
        add(lblsurname);
        
        JLabel labelphonenr = new JLabel("Phone Number:");
        labelphonenr.setBounds(50, 200, 100, 30);
        add(labelphonenr);
        
        JLabel lblphonenr = new JLabel();
        lblphonenr.setBounds(200, 200, 100, 30);
        add(lblphonenr);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where emp_name= '"+employee_name.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblsurname.setText(rs.getString("emp_surname"));
                lblphonenr.setText(rs.getString("emp_phonenr"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        employee_name.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * from employee where emp_name = '"+employee_name.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblsurname.setText(rs.getString("emp_surname"));
                        lblphonenr.setText(rs.getString("emp_phonenr"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        delete_employee = new JButton("Delete");
        delete_employee.setBounds(75, 300, 100, 30);
        delete_employee.setFont(new Font("tahoma", Font.BOLD, 13));
        delete_employee.setBackground(Color.BLACK);
        delete_employee.setForeground(Color.WHITE);
        delete_employee.addActionListener(this);
        add(delete_employee);  
             
        bkbtn= new JButton("Back");
        bkbtn.setBounds(220, 300, 100, 30);
        bkbtn.setFont(new Font("tahoma", Font.BOLD, 13));
        bkbtn.setBackground(Color.BLACK);
        bkbtn.setForeground(Color.WHITE); 
        bkbtn.addActionListener(this);
        add(bkbtn);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("photos/deletecover.png"));
        Image img2= img1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel img= new JLabel(img3);
        img.setBounds(385, 0, 600, 400);
        add(img);
        
        setSize(1000,415);
        setLocation(300, 150);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete_employee){
            try{
                Conn c = new Conn();
                String sql_query= "DELETE from employee WHERE emp_name= '"+ employee_name.getSelectedItem() +"'";
                c.s.executeUpdate(sql_query);
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[]args){
        new DeleteEmployee();
    }
}