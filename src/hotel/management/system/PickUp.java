package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class PickUp extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, search;
    Choice cTypeOfCars;
    JCheckBox available;
    
    PickUp() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(text);
        
        
        JLabel lblBedType = new JLabel("Type of Car");
        lblBedType.setBounds(20,80,100,30);
        add(lblBedType);
        
        
        cTypeOfCars = new Choice();
        cTypeOfCars.setBounds(140, 85, 150, 30);
        add(cTypeOfCars);
        
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from drivers");
                    
            if (!rs.next()) {
                 cTypeOfCars.add("All Cars Are Reserved");
             }
             
             rs.previous();//As the rs.next() returns boolean but still moves forward so the first element is ignored
             //used rs.previous() to take it back to the initial condition.
             //ADDed extra functionality in the conn class
             
             
             while (rs.next()){
                 cTypeOfCars.add(rs.getString("car"));
             }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        available = new JCheckBox("Available Cars Only");
        available.setBounds(400, 80, 200,30);
        add(available);
        
        search = new JButton("Search");
        search.setBounds(650,80,100,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        
        table = new JTable();
        table.setBounds(0,150, 1040, 200);
        add(table);
        
    
        try {
            Conn conn = new Conn();
            String query = "select * from drivers";
            ResultSet rs =  conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new PickUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        } else if (e.getSource() == search) {
            String cartype = (String)cTypeOfCars.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                
                String query1 = "select * from drivers where car = '"+cartype+"'";
                String query2 = "select * from drivers where car = '"+cartype+"' AND availability = 'Available'";
                
                ResultSet rs;
                
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
        }
        
    }
}