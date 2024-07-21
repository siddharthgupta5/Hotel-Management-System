
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class AddCustomers extends JFrame implements ActionListener{
    
    JComboBox cbId, cbGender;
    JTextField tfIdNumber, tfName, tfCountry, tfDeposit;
    Choice cRoom;
    JLabel lblCheckInTime;
    JButton add, back;
    
    
    AddCustomers(){
         setLayout(null);
         setBounds(350, 180, 800, 550);
         getContentPane().setBackground(Color.WHITE);
         
         //New Customer Form Text
         JLabel text = new JLabel("New Customer Form");
         text.setBounds(100, 20, 300, 30);
         text.setFont(new Font("Tahoma", Font.PLAIN, 20));
         add(text);
         
         
         //ID
         JLabel id = new JLabel("ID TYPE");
         id.setBounds(30, 80, 200, 30);
         id.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(id);
         
         
         String[] idOptions = {"CNIC", "PASSPORT", "DRIVING LICENSE"};
         cbId = new JComboBox(idOptions);
         cbId.setBounds(200, 80, 170, 30);
         cbId.setBackground(Color.white);
         add(cbId);
         
         
         //Id Number
         JLabel lblIdNumber = new JLabel("ID NUMBER");
         lblIdNumber.setBounds(30, 120, 200, 30);
         lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblIdNumber);
         
         tfIdNumber = new JTextField();
         tfIdNumber.setBounds(200, 120, 170, 30);
         tfIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
         add(tfIdNumber);
         
         //Name
         JLabel lblName = new JLabel("NAME");
         lblName.setBounds(30, 160, 200, 30);
         lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblName);
         
         tfName = new JTextField();
         tfName.setBounds(200, 160, 170, 30);
         tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
         add(tfName);
         
         
         //Gender
         JLabel lblGender = new JLabel("GENDER");
         lblGender.setBounds(30, 200, 200, 30);
         lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblGender);
         
         String[] genderOptions = {"MALE", "FEMALE"};
         cbGender = new JComboBox(genderOptions);
         cbGender.setBounds(200, 200, 170, 30);
         cbGender.setBackground(Color.white);
         add(cbGender);
         
         
         //country
         JLabel lblCountry = new JLabel("Country");
         lblCountry.setBounds(30, 240 , 200, 30);
         lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblCountry);
         
         tfCountry = new JTextField();
         tfCountry.setBounds(200, 240, 170, 30);
         tfCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
         add(tfCountry);
         
         
         //Allocated Room Number
         JLabel lblRoom = new JLabel("Room Number");
         lblRoom.setBounds(30, 280 , 170, 30);
         lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblRoom);
         
         cRoom = new Choice();
         cRoom.setBounds(200, 280, 170, 30);
         cRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
         add(cRoom);
         
         try{
             Conn conn = new Conn();
             
             String query = "select * from rooms where availability = 'Available'";
             ResultSet rs = conn.s.executeQuery(query);
             
             if (!rs.next()) {
                 cRoom.add("All Rooms Are Reserved");
             }
             
             rs.previous();//As the rs.next() returns boolean but still moves forward so the first element is ignored
             //used rs.previous() to take it back to the initial condition.
             //ADDed extra functionality in the conn class
             
             
             while (rs.next()){
                 cRoom.add(rs.getString("roomnumber"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         
         //CheckIn Time
         JLabel lblCheckIn = new JLabel("CheckIn Time");
         lblCheckIn.setBounds(30, 320 , 170, 30);
         lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblCheckIn);
         
         Date date = new Date();
         
         lblCheckInTime = new JLabel(""+date);
         lblCheckInTime.setBounds(200, 320 , 170, 30);
         lblCheckInTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
         add(lblCheckInTime);
         
         //Deposit
         JLabel lblDeposit = new JLabel("Deposit");
         lblDeposit.setBounds(30, 360 , 170, 30);
         lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
         add(lblDeposit);
         
         
         tfDeposit = new JTextField("0");
         tfDeposit.setBounds(200, 360, 170, 30);
         tfDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
         add(tfDeposit);
         
         
         //add button
         add = new JButton("ADD");
         add.setBackground(Color.black);
         add.setForeground(Color.white);
         add.setBounds(50,420, 120, 30);
         add.addActionListener(this);
         add(add);
         
         back = new JButton("BACK");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(210,420, 120, 30);
         back.addActionListener(this);
         add(back);
         
         
         
         
         
         //Image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/thirteen.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400,40, 400, 400);
         add(image);
         
         
         setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new AddCustomers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String id = (String)cbId.getSelectedItem();
            String number = tfIdNumber.getText();
            String name = tfName.getText();
            String gender = (String)cbGender.getSelectedItem();
            String room = (String)cRoom.getSelectedItem();
            String country = tfCountry.getText();
            String deposit = tfDeposit.getText();
            String checkin = lblCheckInTime.getText();
            
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name Not Added");
                return;
            }
            
            if (cRoom.getSelectedItem() == "All Rooms Are Reserved") {
                JOptionPane.showMessageDialog(null, "No Rooms are Empty at the Moment");
                return;
            }
            
            try {
                Conn conn = new Conn();
                
                String query = "insert into customers values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+room+"', '"+country+"', '"+deposit+"', '"+checkin+"')";
                String query2 = "update rooms set availability = 'Occupied' where roomnumber = '"+room+"'";
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                                
                JOptionPane.showMessageDialog(null, "Customer Has been added Successfully");
                setVisible(false);
                new Reception();
            } catch(Exception ee) {
                ee.printStackTrace();
            }
           
            
        } else if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
}
