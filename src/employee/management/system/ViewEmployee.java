package employee.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewEmployee extends JFrame implements ActionListener{
    
    
    JTable emp_table; //the emp_table from the JTable will show how the data from the database is shown in 2D (both rows+columns)
    
    Choice emp_name; //the emp_name will be shown as a list of names because we will pick all the data (surname, salary etc.) by the primary key
    JButton searchemp, printemp, updateemp, back;
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        JLabel search= new JLabel("Search by employee name");  
        search.setBounds(20, 20, 150, 20);
        add(search);
        
        emp_name= new Choice();
        emp_name.setBounds(180, 20, 150, 20);
        add(emp_name);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        
        emp_table= new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("SELECT * from employee");
            while(rs.next()){ //ResultSet.next() moves from one row to another to get the values, in this situation the primary key only
                emp_name.add(rs.getString("emp_name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("SELECT * from employee");
            emp_table.setModel(DbUtils.resultSetToTableModel(rs));
            //transforms output of the SQL query into the table
        }
        catch(Exception e){ //catches any possible Java or SQL errors
            e.printStackTrace();
        }
        
        JScrollPane scroll_pane= new JScrollPane(emp_table);
        scroll_pane.setBounds(0, 100, 900, 600);  
        add(scroll_pane);
        
        searchemp= new JButton("Search"); /*Button to search for employee and similr for the print, update and
        
        going one page back*/
        searchemp.setBounds(20, 70, 80, 20);
        searchemp.addActionListener(this);
        add(searchemp);
                      
        printemp= new JButton("Print");
        printemp.setBounds(120, 70, 80, 20);
        printemp.addActionListener(this);
        add(printemp);
        
        updateemp= new JButton("Update");
        updateemp.setBounds(220, 70, 80, 20);
        updateemp.addActionListener(this);
        add(updateemp);
        
        
        
        back = new JButton("Back");
        back.setBounds(319, 70, 80, 20);
        back.addActionListener(this);
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == searchemp){
            String sql_query= "SELECT * from employee WHERE emp_name= '"+emp_name.getSelectedItem()+"'";
            
            //we select only the data that corresponds to one emp_name we selected if we want to search only one employee by his/her name
            try{
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(sql_query); 
                emp_table.setModel(DbUtils.resultSetToTableModel(rs)); //we reconstruct the new table after filtering by emp_name             
            }
            catch(Exception e){ //catch any possible errors that may happen in the process
                e.printStackTrace();
            }
        
        }
        else if(ae.getSource() == printemp){
            try{
                emp_table.print(); //the print() method of the JTable prints the table like printing documents
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
       
        else if(ae.getSource() == updateemp){ //*if we want to update an employee we update the employee with the new values
            
            setVisible(false);
            new UpdateEmployee(emp_name.getSelectedItem()); //the employee will be updated with all the data that is taken from the row with a certain emp_name
        }
        else{
            setVisible(false); //otherwise the user will navigate to the house
            new Home();
        }
    }
    public static void main(String[]args){
        new ViewEmployee();
    }
}