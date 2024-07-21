
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice cCustomer;
    JTextField tfRoom, tfName, tfCheckin, tfPaid, tfPending;
    JButton check, update, back, pay;
    
    UpdateCheck(){
        setLayout(null);
        setBounds(300,200,980,500);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setForeground(Color.blue);
        text.setBounds(90,20,200,30);
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
                 cCustomer.add("All Rooms Are Reserved");
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
        
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,160,100,20);
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200, 160, 150, 25);
        add(tfName);
        
        
        JLabel lblCheckin = new JLabel("Check In");
        lblCheckin.setBounds(30,200,100,20);
        add(lblCheckin);
        
        tfCheckin = new JTextField();
        tfCheckin.setBounds(200, 200, 150, 25);
        add(tfCheckin);
        
        
        JLabel lblPaid = new JLabel("Paid Amount");
        lblPaid.setBounds(30,240,100,20);
        add(lblPaid);
        
        tfPaid = new JTextField();
        tfPaid.setBounds(200, 240, 150, 25);
        add(tfPaid);
        
        
        JLabel lblPending = new JLabel("Pending Amount");
        lblPending.setBounds(30,280,100,20);
        add(lblPending);
        
        tfPending = new JTextField();
        tfPending.setBounds(200, 280, 150, 25);
        add(tfPending);
        
        check = new JButton("CHECK");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        
        update = new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        
        pay = new JButton("PAY");
        pay.setBackground(Color.black);
        pay.setForeground(Color.WHITE);
        pay.setBounds(360,275,60,30);
        pay.addActionListener(this);
        add(pay);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new UpdateCheck();
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
                    tfName.setText(rs.getString("name"));
                    tfCheckin.setText(rs.getString("CheckIn"));
                    tfPaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = conn.s.executeQuery("select * from rooms where roomnumber='"+tfRoom.getText()+"'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int pending = Integer.parseInt(price) - Integer.parseInt(tfPaid.getText());
                    tfPending.setText("" + pending);
                }
                
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        } else if (e.getSource() == update) {
            String number = cCustomer.getSelectedItem();
            String room = tfRoom.getText();
            String name = tfName.getText();
            String checkin = tfCheckin.getText();
            String deposit = tfPaid.getText();


            try {
                Conn conn = new Conn();
                String query = "update customers set room='"+room+"', name='"+name+"', CheckIn='"+checkin+"', deposit='"+deposit+"' where number='"+number+"'";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        } else if (e.getSource() == pay) {
            if (tfPending.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please click CHECK before Paying");
                return;
            } else if (tfPending.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "No Remaining amount to pay.");
                return;
            }
            
            int sum = Integer.parseInt(tfPaid.getText()) + Integer.parseInt(tfPending.getText());
            tfPaid.setText("" + sum);
            tfPending.setText("" + 0);
            
            
            try {
                Conn conn = new Conn();
                
                conn.s.executeUpdate("update customers set deposit='"+tfPaid.getText()+"'");
                JOptionPane.showMessageDialog(null, "The Remaining amount has been Paid");
                
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        
        } else if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
}
