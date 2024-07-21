package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AddDrivers extends JFrame implements ActionListener{
    
    JButton bAdd, bCancel;
    JTextField tfName,tfCar,tfAge, tfCarModel, tfLocation;
    JComboBox cbGender, cbAvailable;
    
    AddDrivers(){
        setLayout(null);
        setBounds(300, 200, 980, 470);
        getContentPane().setBackground(Color.white);
        
        //ADD Driver
        JLabel lblAdd = new JLabel("Add Drivers");
        lblAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAdd.setBounds(120, 10, 130,30);
        add(lblAdd);
        
        //Name
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(40, 60, 130,30);
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(180, 60, 130,30);
        add(tfName);
        
        //Age
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAge.setBounds(40, 100, 130,30);
        add(lblAge);
        
        tfAge = new JTextField();
        tfAge.setBounds(180, 100, 130,30);
        add(tfAge);
        
        
        //Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender.setBounds(40, 140, 130,30);
        add(lblGender);
        
        String[] genderOptions = {"Male", "Female"};
        cbGender = new JComboBox(genderOptions);
        cbGender.setBounds(180, 140, 130, 30);
        cbGender.setBackground(Color.white);
        add(cbGender);
        
        //Car Company
        JLabel lblCar = new JLabel("Car Company");
        lblCar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCar.setBounds(40, 180, 130,30);
        add(lblCar);
        
        tfCar = new JTextField();
        tfCar.setBounds(180, 180, 130,30);
        add(tfCar);
        
        
        //Car Model
        JLabel lblCarModel = new JLabel("Car Model");
        lblCarModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCarModel.setBounds(40, 220, 130,30);
        add(lblCarModel);
        
        tfCarModel = new JTextField();
        tfCarModel.setBounds(180, 220, 130,30);
        add(tfCarModel);
        
        //Available
        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailable.setBounds(40, 260, 130,30);
        add(lblAvailable);
        
        
        String[] availableOptions = {"Available", "Reserved"};
        cbAvailable = new JComboBox(availableOptions);
        cbAvailable.setBounds(180, 260, 130, 30);
        cbAvailable.setBackground(Color.white);
        add(cbAvailable);
        
        
        //Location
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLocation.setBounds(40, 300, 130,30);
        add(lblLocation);
        
        tfLocation = new JTextField();
        tfLocation.setBounds(180, 300, 130,30);
        add(tfLocation);
        
        
        //ADD Button
        bAdd = new JButton("ADD");
        bAdd.setBounds(40, 360, 130, 30);
        bAdd.setBackground(Color.BLACK);
        bAdd.setForeground(Color.WHITE);
        bAdd.addActionListener(this);
        add(bAdd);
        
        
        //Cancel Button
        bCancel = new JButton("CANCEL");
        bCancel.setBounds(180, 360, 130, 30);
        bCancel.setBackground(Color.BLACK);
        bCancel.setForeground(Color.WHITE);
        bCancel.addActionListener(this);
        add(bCancel);
        
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 30, 500, 320);
        add(image);
                
                
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddDrivers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd){
            String name = tfName.getText();
            String age = tfAge.getText();
            String gender = (String)cbGender.getSelectedItem();
            String car = tfCar.getText();
            String carModel = tfCarModel.getText();
            String available = (String)cbAvailable.getSelectedItem();
            String location = tfLocation.getText();
            
            
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Name");
                return;
            }
            
            if (car.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Car Company");
                return;
            }
            
            try {
                Conn conn = new Conn();
                
                String query = "insert into drivers values('"+name+"', '"+age+"', '"+gender+"', '"+car+"', '"+carModel+"', '"+available+"', '"+location+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Driver has been added Successfully!");
                setVisible(false);
                     
            } catch (Exception ee){
                ee.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
        }
    }
}
