
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener{
    
    Choice cCustomer;
    JTextField tfRoom, tfAvailable, tfClean, tfPaid, tfPending;
    JButton check, update, back;
    
    UpdateRoomStatus(){
        setLayout(null);
        setBounds(300,200,980,500);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setForeground(Color.blue);
        text.setBounds(60,20,300,30);
        add(text);
        
        
        JLabel customerId = new JLabel("Customer Id");
        customerId.setBounds(30,80,100,20);
        add(customerId);
        
        cCustomer = new Choice();
        cCustomer.setBounds(200,80,150,25);
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
        
        
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,120,100,20);
        add(lblRoom);
        
        tfRoom = new JTextField();
        tfRoom.setBounds(200, 120, 150, 25);
        add(tfRoom);
        
        
        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setBounds(30,160,100,20);
        add(lblAvailable);
        
        tfAvailable = new JTextField();
        tfAvailable.setBounds(200, 160, 150, 25);
        add(tfAvailable);
        
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(30,200,100,20);
        add(lblclean);
        
        tfClean = new JTextField();
        tfClean.setBounds(200, 200, 150, 25);
        add(tfClean);
        
        
        
        check = new JButton("CHECK");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        
        update = new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new UpdateRoomStatus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check){
            String id = cCustomer.getSelectedItem();
            String query = "select * from customers where number='"+id+"'";
            
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                
                
                while (rs.next()) {
                    tfRoom.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = conn.s.executeQuery("select * from rooms where roomnumber='"+tfRoom.getText()+"'");
                while (rs2.next()) {
                    tfAvailable.setText(rs2.getString("availability"));
                    tfClean.setText(rs2.getString("status"));
                }
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        } else if (e.getSource() == update) {
            String room = tfRoom.getText();
            String available = tfAvailable.getText();
            String clean = tfClean.getText();


            try {
                Conn conn = new Conn();
                String query2 = "update rooms set availability='"+available+"', status='"+clean+"'";
                
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        } else if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
}
