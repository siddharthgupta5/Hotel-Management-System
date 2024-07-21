
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    ManagerInfo() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        
        table = new JTable();
        table.setBounds(0,0, 1040, 400);
        add(table);
        try {
            Conn conn = new Conn();
            String query = "select * from employee where job = 'Manager'";
            ResultSet rs =  conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(450,500,120,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ManagerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
