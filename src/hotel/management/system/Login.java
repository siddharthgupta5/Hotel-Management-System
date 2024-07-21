package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField userNameField;
    JPasswordField passField;
    JButton login, cancel;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(450, 250, 600, 280);//alternative of setSize and setLocation
        setLayout(null);
        
        JLabel userName = new JLabel("Username: ");
        userName.setBounds(40, 33, 70, 25);
        add(userName);
        
        userNameField = new JTextField();
        userNameField.setBounds(160, 33, 140, 25);
        add(userNameField);
        
        JLabel pass = new JLabel("Password: ");
        pass.setBounds(40, 63, 70, 25);
        add(pass);
        
        passField = new JPasswordField();
        passField.setBounds(160, 63, 140, 25);
        add(passField);
        
        
        login = new JButton("Login");
        login.setBounds(40, 160, 110, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) { //This executes when login button is pressed.
            String user = userNameField.getText();
            String pass = passField.getText();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                
                ResultSet rs = c.s.executeQuery(query);//This will have some value or incase nothing is returned it 
                //will be empty;
                
                if (rs.next()){//if rs.next() is true it means there is some value.
                    
                    setVisible(false);
                    new DashBoard();
                    
                }else {//no value is present
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password\nTry Again");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            
            
        } else if (ae.getSource() == cancel){ //This executes when cancel button is pressed.
            
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
