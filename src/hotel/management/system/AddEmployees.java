
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddEmployees extends JFrame implements ActionListener{
    
    JTextField tfName, tfAge, tfSalary, tfEmail, tfPhone, tfCNIC;
    JRadioButton rbMale, rbFemale;
    JButton submit, cancel;
    JComboBox cbJob;
    
    AddEmployees(){
        setLayout(null);
        
        setBounds(350,200, 850, 540);
        getContentPane().setBackground(Color.white);
        
        
        //Name
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(70, 30, 120, 30);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(180, 30, 150, 30);
        add(tfName);
        
        
        //Age
        JLabel lblAge = new JLabel("AGE");
        lblAge.setBounds(70, 70, 120, 30);
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblAge);
        
        tfAge = new JTextField();
        tfAge.setBounds(180, 70, 150, 30);
        add(tfAge);
        
        
        //Gender
        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(70, 110, 120, 30);
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblGender);
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(180, 110, 70, 30);
        rbMale.setBackground(Color.white);
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(250, 110, 70, 30);
        rbFemale.setBackground(Color.white);
        add(rbFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        
        //Job
        JLabel lblJob = new JLabel("JOB");
        lblJob.setBounds(70, 150, 120, 30);
        lblJob.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblJob);
        
        String[] dropdown = {"Manager" ,"Front Desk Clerks", "HouseKeeping", "Porkers", "Kitchen Staff", "Chefs"};
        cbJob = new JComboBox(dropdown);//cbJob takes an array of String as an argument.
        cbJob.setBounds(180, 150, 150,30);
        cbJob.setBackground(Color.white);
        add(cbJob);
        
        //Salary
        JLabel lblSalary = new JLabel("SALARY");
        lblSalary.setBounds(70, 190, 120, 30);
        lblSalary.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblSalary);
        
        tfSalary = new JTextField();
        tfSalary.setBounds(180, 190, 150, 30);
        add(tfSalary);
        
        
        //Phone
        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setBounds(70, 230, 120, 30);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(180, 230, 150, 30);
        add(tfPhone);
        
        
        //Email
        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(70, 270, 120, 30);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(180, 270, 150, 30);
        add(tfEmail);
        
        //CNIC
        JLabel lblCNIC = new JLabel("CNIC");
        lblCNIC.setBounds(70, 310, 120, 30);
        lblCNIC.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblCNIC);
        
        tfCNIC = new JTextField();
        tfCNIC.setBounds(180, 310, 150, 30);
        add(tfCNIC);
        
        //Submit Button
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(70,380,120,30);
        submit.addActionListener(this);
        add(submit);
        
        //Cancel Button
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(200,380,120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 15, 450, 380);
        add(image);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new AddEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String name = tfName.getText();
            String age = tfAge.getText();
            String salary = tfSalary.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String cnic = tfCNIC.getText();

            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Name");
                return;
            }
            
            if (age.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Age");
                return;
            }
            
            if (salary.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Salary");
                return;
            }
            
            if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Email");
                return;
            }
            
            if (phone.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Phone Number");
                return;
            }
            
            if (cnic.equals("")){
                JOptionPane.showMessageDialog(null, "Enter CNIC Number");
                return;
            }
            
            String gender = null;

            if (rbMale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()){
                gender = "Female";
            }


            String job = (String)cbJob.getSelectedItem();//This returns an object so we are typecasting it into a string.


            try {
                Conn conn = new Conn();

                String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+cnic+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee has been added successfully.");
                setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
            
        }else if (e.getSource() == cancel){
            setVisible(false);
        }
        
        
        
        
    }
}
