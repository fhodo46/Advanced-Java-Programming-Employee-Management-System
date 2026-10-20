package employee.management.system;
import java.sql.*; //JDBC package imported
public class Conn {
    Connection c; 
    Statement s;
    //JDBC (the Java Database Connectivity) is an API between the Java and the database to connect them
     public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); /*we register the driver class; the driver which we use here
            has a particular driver that needs to be registered here; they translate requests from Java 
            programs into a protocol understood by the DBMS.*/
            c= DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "Fatjon3059!"); 
            //we determine the URL, the username and password from which the SQL command prompt can be accessed
            s= c.createStatement();
            //after connection the statement is used by application programs to dynamically prepare an SQL statement for execution 
        }
         catch(Exception e){ //any error with the connection will be shown here
            e.printStackTrace();
        }
    }
}