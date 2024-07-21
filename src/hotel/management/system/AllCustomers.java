
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class AllCustomers extends JFrame implements ActionListener{
    JButton back;
    
    AllCustomers(){
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        
        JLabel type = new JLabel("ID Type");
        type.setBounds(0,0,100,30);
        add(type);
        
        JLabel idNumber = new JLabel("ID Number");
        idNumber.setBounds(128,0,100,30);
        add(idNumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(250,0,100,30);
        add(name);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(375,0,100,30);
        add(gender);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(500,0,100,30);
        add(room);
        
        
        JLabel country = new JLabel("Country");
        country.setBounds(625,0,100,30);
        add(country);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(750 ,0,100,30);
        add(deposit);
        
        JLabel checkIn = new JLabel("CheckIn");
        checkIn.setBounds(875 ,0,100,30);
        add(checkIn);
        
        
        JTable table = new JTable();
        table.setBounds(0,30, 1040,400);
        add(table);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customers";
            ResultSet rs =  conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(750,500,200,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new AllCustomers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
