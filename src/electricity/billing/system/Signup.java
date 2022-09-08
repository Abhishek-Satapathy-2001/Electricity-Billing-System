
package electricity.billing.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;



public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    Choice accountType;
    JTextField meter,username,name,password;
    
    Signup(){
        
        //setSize(700,400);
        //setLocation(450,150);
          setBounds(450,150,700,400);
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);
          
          //pannel-to divide frame
          JPanel panel = new JPanel();
          panel.setBounds(30,30,650,300);
          panel.setBorder(new TitledBorder(new LineBorder(Color.BLUE),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
          panel.setBackground(Color.WHITE);
          panel.setLayout(null);
          panel.setForeground(new Color(34,139,34));
          
          //create account
          JLabel heading = new JLabel("Create Account as");
          heading.setBounds(100,50,140,20);
          heading.setForeground(Color.GRAY);
          //heading.setFont(new Font("Tahoma",Font.BOLD,14));
          panel.add(heading);
          accountType = new Choice();
          accountType.add("Admin");
          accountType.add("Customer");
          accountType.setBounds(260,50,150,20);
          panel.add(accountType);
         
         //meter
         JLabel lblmeter = new JLabel("Meter Number");
         lblmeter.setBounds(100,90,140,20);
         lblmeter.setForeground(Color.GRAY);
         //lblmeter.setFont(new FONT("Railway",Font.BOLD,14));
         panel.add(lblmeter);
         meter = new JTextField();
         meter.setBounds(260,90,140,20);
         panel.add(meter);
         
         //username
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(100,130,140,20);
         lblusername.setForeground(Color.GRAY);
         //lblusername.setFont(new FONT("Railway",Font.BOLD,14));
         panel.add(lblusername);
         username = new JTextField();
         username.setBounds(260, 130, 150, 20);
         panel.add(username);
         
         //name
         JLabel lblname = new JLabel("Name");
         lblname.setBounds(100,170,140,20);
         lblname.setForeground(Color.GRAY);
         //lblname.setFont(new FONT("Railway",Font.BOLD,14));
         panel.add(lblname);
         name = new JTextField();
         name.setBounds(260,170,150,20);
         panel.add(name);
         
         //password
         JLabel lblpassword = new JLabel("Password");
         lblpassword.setBounds(100,210,140,20);
         lblpassword.setForeground(Color.GRAY);
         //lblname.setFont(new FONT("Railway",Font.BOLD,14));
         panel.add(lblpassword);
         password = new JTextField();
         password.setBounds(260,210,150,20);
         panel.add(password);
         
         //buttons
         create = new JButton("Create");
         create.setBackground(Color.BLACK);
         create.setForeground(Color.WHITE);
         create.setBounds(140, 280, 120, 25);
         create.addActionListener(this);
         add(create);
         
         back = new JButton("Back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.setBounds(300, 280, 120, 25);
         back.addActionListener(this);
         add(back);
         
         //image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
         Image i2 = i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(415, 30, 250, 250);
         panel.add(image);
         
        
         
         
         
         
          
          
          add(panel);
          
          setVisible(true);
          
         
    }
    //override interface method
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==create){
              
              String atype=accountType.getSelectedItem();
              String susername=username.getText();
              String sname=name.getText();
              String spassword=password.getText();
              String smeter=meter.getText();
              
              try{
                  Conn c=new Conn();
                  String query = "insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
                  
                  c.s.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null,"Account created Successfully");
                  
                  setVisible(false);
                  new Login();
              
              }
          
              catch(Exception e){
                  e.printStackTrace();
              }
              
          }else if(ae.getSource()==back){
              setVisible(false);
              new Login();
          }
          
      }
     
    
    
    public static void main(String args[]){
        new Signup();
    }
}
