
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;


public class CheckOut extends JFrame implements ActionListener{
    
    Choice cCustomer;
    JLabel lblRoomNumber, lblCheckInValue, lblCheckOutValue;
    JButton checkOut, back, check;
    
    CheckOut() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("CheckOut");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        
        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30,80,100,30);
        add(lblId);
        
        cCustomer = new Choice();
        cCustomer.setBounds(150, 85, 150, 25);
        add(cCustomer);
        
        try{
             Conn conn = new Conn();
             
             String query = "select * from customers";
             ResultSet rs = conn.s.executeQuery(query);
             
             if (!rs.next()) {
                 cCustomer.add("All Rooms Are Empty");
             }
             
             rs.previous();//As the rs.next() returns boolean but still moves forward so the first element is ignored
             //used rs.previous() to take it back to the initial condition.
             //ADDed extra functionality in the conn class
             
             
             while (rs.next()){
                 cCustomer.add(rs.getString("number"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 85, 20, 20);
        add(image);
        
        
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,130,100,30);
        add(lblRoom);
        
        
        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(150,130,100,30);
        add(lblRoomNumber);
        
        JLabel lblCheckIn = new JLabel("CheckIn");
        lblCheckIn.setBounds(30,180,100,30);
        add(lblCheckIn);
        
        lblCheckInValue = new JLabel();
        lblCheckInValue.setBounds(150,180,300,30);
        add(lblCheckInValue);
        
        
        JLabel lblCheckOut = new JLabel("CheckOut");
        lblCheckOut.setBounds(30,230,100,30);
        add(lblCheckOut);
        
        Date date = new Date();
        lblCheckOutValue = new JLabel("" + date);
        lblCheckOutValue.setBounds(150,230,300,30);
        add(lblCheckOutValue);
        
        
        checkOut = new JButton("CheckOut");
        checkOut.setBackground(Color.black);
        checkOut.setForeground(Color.white);
        checkOut.setBounds(30, 280, 100, 30);
        checkOut.addActionListener(this);
        add(checkOut);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(150, 280, 100, 30);
        check.addActionListener(this);
        add(check);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 280, 100, 30);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350, 50, 400, 250);
        add(image2);
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new CheckOut();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkOut) {
            
            String query = "delete from customers where number='"+cCustomer.getSelectedItem()+"'";
            String query2 = "update rooms set availability = 'Available' where roomnumber = '"+lblRoomNumber.getText()+"'";
            
            try {
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "CheckOut Done!");
                
                setVisible(false);
                new Reception();
            }catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == check) {
        
            try{
             Conn conn = new Conn();
             
             String query = "select * from customers where number='"+cCustomer.getSelectedItem()+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
             while (rs.next()){
                 lblRoomNumber.setText(rs.getString("room"));
                 lblCheckInValue.setText(rs.getString("CheckIn"));
                 
             }
         } catch (Exception ee) {
             ee.printStackTrace();
         }
        
        }else if (e.getSource() == back) {
                setVisible(false);
                new Reception();
            
        }
    }
}
