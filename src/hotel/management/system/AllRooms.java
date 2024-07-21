
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;//for displaying table.Will work only with rs2xml.jar

public class AllRooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    AllRooms() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600,600);
        add(image);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        
        //Headings for Table
        //roomnumber
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(0, 20, 100, 10);
        add(roomNumber);
        
        //Available
        JLabel available = new JLabel("Available");
        available.setBounds(100, 20, 100, 10);
        add(available);
        
        //Cleaning Status
        JLabel cleaning = new JLabel("Clean Status");
        cleaning.setBounds(200, 20, 100, 10);
        add(cleaning);
        
        //price
        JLabel price = new JLabel("Price");
        price.setBounds(300, 20, 100, 10);
        add(price);
        
        
        //Beds 
        JLabel beds = new JLabel("Beds");
        beds.setBounds(400, 20, 100, 10);
        add(beds);
        
        try {
            Conn conn = new Conn();
            
            String query = "select * from rooms";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        //Back Button
        back = new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new AllRooms();
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
    
