package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.WHITE); //sets the background of the screen to white
        setLayout(null); //it is null so we can determine the coordinates of each component ourselves
        
        JLabel heading = new JLabel("Employee Management System"); //title of the first page
        heading.setBounds(350, 10, 1200, 60); /*setBounds's parameters: 1st parameter how much the label
        shifts from the x-coordinates to the right (shifting the label x units to the right), 2nd shifts the label y
        units downwards, from the y-coordinates, the 3rd is the width of the component itself and the 4th the height of the component */ 
        heading.setFont(new Font("tahoma", Font.BOLD, 30)); /*setFont will change the font of the component; the first
        parameter of the Font object inside the setFont() method is the font family, the second one the style, and the third one the size */
        heading.setForeground(Color.ORANGE); //the color of the content
        add(heading); //the add() method will add the component to the content pane
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("photos/employeeoffice.jpg")); /*ImageIcon serves as
        an interface that creates icons from images, so it uses an image to create an icon; getSystemResource() will take the image source based on the project file*/
        Image img2= img1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT); /* getScaledInstance() will resize
        the image from the source after the image has been taken with the getImage() method; the first parameter
        is the image width, the second the image height and the third one the default scaling algorithm to 
        
        adapt the resolution and the size of the image*/
        
        ImageIcon img3= new ImageIcon(img2); //The ImageIcon will have the new formed image now
        JLabel img= new JLabel(img3);
        img.setBounds(50, 75, 1050, 500);
        add(img);
          
        JButton clickbtn = new JButton("Click here to continue"); //the button to go to login page
        clickbtn.setBounds(400, 400, 300, 70);
        clickbtn.addActionListener(this); //performs what is in the actionPerformed() method when the event is fired
        clickbtn.setFont(new Font("tahoma", Font.BOLD, 20));
        img.add(clickbtn); //the button will be added inside the image
        setSize(1170, 650); //the width and the height of the whole container
        setLocation(250, 50); //shows how much to the right/ how much downwards the pane will move with respect to the screen
        setVisible(true); /*since it is the first screen that shows when the user opens the app it is true; the setVisible()
        
        method will tell if the screen should remain on the GUI or not*/
    }
    
    public void actionPerformed(ActionEvent evt){ //actionPerformed is the method of the interface ActionEvent that determines the actions that are in a screen
        setVisible(false);
        new Login(); //if the user clicks the button the user will be prompted to move to the Login screen and the whole and for that reason the constructor of the other class will show its functionality when the Login screen appears
    }  
    
    
    
    
    public static void main(String[]args){
        new Splash(); //the driver method, the main, will have to include the constructor that includes the functionality of Splash to ensure that the Splash class is opened first
    }
}