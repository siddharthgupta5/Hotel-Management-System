
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newCustomerForm, rooms, allEmployee, managerInfo, customer, searchRoom, update, roomStatus, pickupService,
            checkout, logout;
    
    Reception(){
        setLayout(null);
        setBounds(350, 180, 800, 570);
        getContentPane().setBackground(Color.WHITE);
        
        newCustomerForm = new JButton("New Customer Form");
        newCustomerForm.setBounds(10,30,200,30);
        newCustomerForm.setBackground(Color.BLACK);
        newCustomerForm.setForeground(Color.WHITE);
        newCustomerForm.addActionListener(this);
        add(newCustomerForm);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,110,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customer = new JButton("Customers Info");
        customer.setBounds(10,150,200,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        add(customer);
        
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,190,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout = new JButton("Check Out");
        checkout.setBounds(10,230,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Status");
        update.setBounds(10,270,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,310,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);
        

        pickupService = new JButton("PickUp Service");
        pickupService.setBounds(10,350,200,30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.addActionListener(this);
        add(pickupService);
        
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,390,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        
        logout = new JButton("Log Out");
        logout.setBounds(10,430,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 20, 500, 470);
        add(image);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newCustomerForm) {
            setVisible(false);
            new AddCustomers();
        } else if (e.getSource() == rooms) {
            setVisible(false);
            new AllRooms();
        } else if (e.getSource() == allEmployee) {
            setVisible(false);
            new AllEmployees();
        } else if (e.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource() == customer) {
            setVisible(false);
            new AllCustomers();
        } else if (e.getSource() == searchRoom) {
            setVisible(false);
            new SearchRooms();
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoomStatus();
        } else if (e.getSource() == pickupService) {
            setVisible(false);
            new PickUp();
        } else if (e.getSource() == checkout) {
            setVisible(false);
            new CheckOut();
        } else if (e.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }
    }
    
}
