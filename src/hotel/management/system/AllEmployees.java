package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class AllEmployees extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    AllEmployees() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forteen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620, 0, 450, 600);
        add(image);
        
        
        table = new JTable();
        table.setBounds(0,0, 600, 400);
        add(table);
        try {
            Conn conn = new Conn();
            String query = "select * from employee";
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
        new AllEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
}
