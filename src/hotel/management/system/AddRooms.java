
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AddRooms extends JFrame implements ActionListener{
    
    JButton bAdd, bCancel;
    JTextField tfRno,tfPrice;
    JComboBox cbAvailable,cbCleaning, cbBedType;
    
    AddRooms(){
        setLayout(null);
        setBounds(330, 200, 940, 470);
        getContentPane().setBackground(Color.white);
        
        //ADD a Room
        JLabel lblAdd = new JLabel("Add Rooms");
        lblAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAdd.setBounds(120, 10, 130,30);
        add(lblAdd);
        
        //Room Number
        JLabel lblRno = new JLabel("Room Number");
        lblRno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRno.setBounds(40, 60, 130,30);
        add(lblRno);
        
        tfRno = new JTextField();
        tfRno.setBounds(180, 60, 130,30);
        add(tfRno);
        
        //Available
        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailable.setBounds(40, 100, 130,30);
        add(lblAvailable);
        
        String[] availableOptions = {"Available", "Occupied"};
        cbAvailable = new JComboBox(availableOptions);
        cbAvailable.setBounds(180, 100, 130, 30);
        cbAvailable.setBackground(Color.white);
        add(cbAvailable);
        
        
        //Cleaning Status
        JLabel lblCleaning = new JLabel("Cleaning Status");
        lblCleaning.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCleaning.setBounds(40, 140, 130,30);
        add(lblCleaning);
        
        String[] cleaningOptions = {"Clean", "Dirty"};
        cbCleaning = new JComboBox(cleaningOptions);
        cbCleaning.setBounds(180, 140, 130, 30);
        cbCleaning.setBackground(Color.white);
        add(cbCleaning);
        
        //Price
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setBounds(40, 180, 130,30);
        add(lblPrice);
        
        tfPrice = new JTextField();
        tfPrice.setBounds(180, 180, 130,30);
        add(tfPrice);
        
        
        //Bed Type
        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBedType.setBounds(40, 220, 130,30);
        add(lblBedType);
        
        String[] bedTypeOptions = {"Single Bed", "Double Bed"};
        cbBedType = new JComboBox(bedTypeOptions);
        cbBedType.setBounds(180, 220, 130, 30);
        cbBedType.setBackground(Color.white);
        add(cbBedType);
        
        //ADD Button
        bAdd = new JButton("ADD");
        bAdd.setBounds(40, 320, 130, 30);
        bAdd.setBackground(Color.BLACK);
        bAdd.setForeground(Color.WHITE);
        bAdd.addActionListener(this);
        add(bAdd);
        
        
        //Cancel Button
        bCancel = new JButton("CANCEL");
        bCancel.setBounds(180, 320, 130, 30);
        bCancel.setBackground(Color.BLACK);
        bCancel.setForeground(Color.WHITE);
        bCancel.addActionListener(this);
        add(bCancel);
        
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
       
        JLabel image = new JLabel(i1);
        image.setBounds(380, 30, 500, 320);
        add(image);
                
                
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd){
            String roomnumber = tfRno.getText();
            String availability = (String)cbAvailable.getSelectedItem();
            String status = (String)cbCleaning.getSelectedItem();
            String price = tfPrice.getText();
            String bedtype = (String)cbBedType.getSelectedItem();
            
            System.out.print(roomnumber);
            
            if (roomnumber.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Room Number");
                return;
            }
            
            if (price.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Price");
                return;
            }
            
            try {
                Conn conn = new Conn();
                
                String query = "insert into rooms values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+bedtype+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Room has been added Successfully!");
                setVisible(false);
                     
            } catch (Exception ee){
                ee.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
        }
    }
}
