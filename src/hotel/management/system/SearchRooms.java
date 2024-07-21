package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class SearchRooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, search;
    JComboBox cbBedType;
    JCheckBox available;
    
    SearchRooms() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Search Rooms");
        text.setBounds(400, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(text);
        
        
        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setBounds(20,80,100,30);
        add(lblBedType);
        
        
        String[] bedOptions = {"Single Bed", "Double Bed"};
        cbBedType = new JComboBox(bedOptions);
        cbBedType.setBounds(100, 80, 200, 30);
        cbBedType.setBackground(Color.white);
        add(cbBedType);
        
        available = new JCheckBox("Available Rooms Only");
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
            String query = "select * from rooms";
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
        new SearchRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        } else if (e.getSource() == search) {
            String bedtype = (String)cbBedType.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                
                String query1 = "select * from rooms where bedtype = '"+bedtype+"'";
                String query2 = "select * from rooms where bedtype = '"+bedtype+"' AND availability = 'Available'";
                
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
