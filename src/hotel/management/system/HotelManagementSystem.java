package hotel.management.system;

import javax.swing.*;//for using the swing function
import java.awt.*;//for colors
import java.awt.event.*;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener{//this class is extending from the JFrame class.

    HotelManagementSystem(){//created a constructor so it will run directly as the object is created.
        
//        setBounds(100,100,1366,565);
        setSize(1366, 565);//for setting the size of the frame.
        setLocation(100,100);//this sets the frame location at x=100 and y=100
        setLayout(null);//by default it is border layout we made it null and will make layout ourselves.
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));//we loaded the picture.
        JLabel image = new JLabel(i1);//added the image to JLabel
        image.setBounds(0,0,1365, 565);//set the layout manually as we have removed by default layout.
        add(image);
        
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(40, 450, 560, 55);
        text.setForeground(Color.YELLOW);
        text.setBackground(Color.BLACK);
        text.setOpaque(true); //the background doesnt shows without this property
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        
        JButton next = new JButton("NEXT");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("serif", Font.PLAIN, 23));
        next.addActionListener(this);
        image.add(next);
        
        
        setVisible(true);//to enable the visibility of the frame.
        
        while (true) {
            
            text.setVisible(false);
            
            try{
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            text.setVisible(true);
            
            try{
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }
       }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
