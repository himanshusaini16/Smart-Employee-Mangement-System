import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;

public class updateEmployee extends JFrame implements ActionListener{


    JButton add,back;
    JTextField tfEducation,ftfname,tfSalary,tfAddress,tfPhone,tfemail,tfdesignation,tfaddhar,tfname;
    JDateChooser dcDOB;
    JComboBox educat;
    JLabel empLabel;
    String Empid;

    updateEmployee(String Empid)
    {
        this.Empid=Empid;
        setLayout(null);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(290, 20,1000, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,28));
        add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(name);

        JLabel namelbl= new JLabel();
        namelbl.setBounds(200, 150, 170, 30);
        add(namelbl);

        JLabel fname=new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(fname);

        ftfname= new JTextField();
        ftfname.setBounds(550, 150, 170, 30);
        add(ftfname);

        JLabel DOB=new JLabel("DOB:");
        DOB.setBounds(50, 200, 150, 30);
        DOB.setFont(new Font("SERIF",Font.PLAIN,20));
        add(DOB);

        JLabel dcDOBlbl=new JLabel();
        dcDOBlbl.setBounds(200, 200, 150, 30);
        add(dcDOBlbl);

        JLabel Salary=new JLabel("Salary:");
        Salary.setBounds(400, 200, 150, 30);
        Salary.setFont(new Font("SERIF",Font.PLAIN,20));
        add(Salary);

        tfSalary= new JTextField();
        tfSalary.setBounds(550, 200, 170, 30);
        add(tfSalary);

        JLabel Address=new JLabel("Address:");
        Address.setBounds(50, 250, 150, 30);
        Address.setFont(new Font("SERIF",Font.PLAIN,20));
        add(Address);

        tfAddress= new JTextField();
        tfAddress.setBounds(200, 250, 170, 30);
        add(tfAddress);

        JLabel phone=new JLabel("Phone No:");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(phone);

        tfPhone= new JTextField();
        tfPhone.setBounds(550, 250, 170, 30);
        add(tfPhone);

        JLabel email=new JLabel("Email:");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SERIF",Font.PLAIN,20));
        add(email);

        tfemail= new JTextField();
        tfemail.setBounds(200, 300, 170, 30);
        add(tfemail);

        JLabel education=new JLabel("Highest Education:");
        education.setBounds(400, 300, 200, 30);
        education.setFont(new Font("SERIF",Font.PLAIN,20));
        add(education);

        tfEducation= new JTextField();
        tfEducation.setBounds(555, 300, 155, 30);
        add(tfEducation);

        JLabel designation=new JLabel("Designation:");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(designation);

        tfdesignation= new JTextField();
        tfdesignation.setBounds(200, 350, 170, 30);
        add(tfdesignation);

        JLabel addhar=new JLabel("Addhar No:");
        addhar.setBounds(400, 350, 150, 30);
        addhar.setFont(new Font("SERIF",Font.PLAIN,20));
        add(addhar);

        JLabel addharlbl= new JLabel();
        addharlbl.setBounds(550, 350, 170, 30);
        add(addharlbl);

        JLabel empid=new JLabel("Employee Id:");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empid);

        empLabel=new JLabel();
        empLabel.setBounds(200, 400, 150, 30);
        empLabel.setFont(new Font("SERIF",Font.PLAIN,20));
        add(empLabel);

        try {
            database conn= new database();
            String q="Select * from employee  where Empid = '"+Empid+"'";
            ResultSet rs=conn.s.executeQuery(q);
            while(rs.next())
            {
                namelbl.setText(rs.getString("Name"));
                ftfname.setText(rs.getString("fname"));
                dcDOBlbl.setText(rs.getString("dob")); 
                tfSalary.setText(rs.getString("Salary"));
                tfAddress.setText(rs.getString("Address"));
                tfPhone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfEducation.setText(rs.getString("Education"));
                tfdesignation.setText(rs.getString("Designation"));
                addharlbl.setText(rs.getString("Addhar"));
                empLabel.setText(rs.getString("Empid"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        add =new JButton("Update Detail");
        add.setBounds(200, 580, 200, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);

        back =new JButton("Back");
        back.setBounds(500, 580, 200, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);

        setSize(900,700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add){
            
            String fname=ftfname.getText();
           
            String Salary=tfSalary.getText();
            String Address=tfAddress.getText();
            String phone=tfPhone.getText();
            String Email=tfemail.getText();
            String Education=tfEducation.getText();
            String Designation=tfdesignation.getText();

            try {
                database conn =new database();
                String query="Update employee set fname='"+fname+"',Salary='"+Salary+"',Address='"+Address+"',Phone='"+phone+"',Email='"+Email+"',Education='"+Education+"',Designation='"+Designation+"' where  Empid='"+Empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully !!");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }

    }
    public static void main(String[] args) {
        new updateEmployee("") ;
    }
}
