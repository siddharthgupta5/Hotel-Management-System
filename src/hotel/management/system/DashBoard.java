
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener{
    
    JMenuItem addEmployee, addRooms, addDrivers, reception;
    
    DashBoard(){
        setBounds(0, 0, 1500, 800);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1500,800);//we are using this because we have made the default layout as null
        add(image);
        
        
        JLabel text = new JLabel("SERENA HOTEL WELCOMES YOU!");
        text.setBounds(400, 70, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 45));
        text.setForeground(Color.WHITE);
        image.add(text);//as this will be above the image so we add it by this way.
        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1500, 30);
        image.add(menuBar);
        
        JMenu menu1 = new JMenu("HOTEL MANAGEMENT");
        menu1.setForeground(Color.BLUE);
        menuBar.add(menu1);
        
        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        menu1.add(reception);
        
        JMenu menu2 = new JMenu("ADMIN");
        menu2.setForeground(Color.RED);
        menuBar.add(menu2);
        
        addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        menu2.add(addEmployee);
        
        addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        menu2.add(addRooms);
        
        addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        menu2.add(addDrivers);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new DashBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEmployee) {
//            setVisible(false);
            new AddEmployees();
        } else if (e.getSource() == addRooms) {
//            setVisible(false);
            new AddRooms();
        } else if (e.getSource() == addDrivers) {
            new AddDrivers();
        } else if (e.getSource() == reception) {
            new Reception();
        }
    }

}