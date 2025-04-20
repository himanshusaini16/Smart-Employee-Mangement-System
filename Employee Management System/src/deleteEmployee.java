import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class deleteEmployee extends JFrame implements ActionListener{
   Choice cEmpid;
   JButton delete,back;
    deleteEmployee()
    {
        setLayout(null);

        JLabel empLabel=new JLabel("Employee Id");
        empLabel.setBounds(50, 50, 100, 30);
        add(empLabel);
        
        cEmpid=new Choice();
        cEmpid.setBounds(150, 50, 150, 30);
        add(cEmpid);

        try {
            database c=new database();
            String q="Select * from employee";
            ResultSet rs=c.s.executeQuery(q);
            while (rs.next()) {
                cEmpid.add(rs.getString("Empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(50, 100, 100, 30);
        add(name);

        JLabel namelLabel=new JLabel();
        namelLabel.setBounds(150, 100, 100, 30);
        add(namelLabel);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(50, 150, 100, 30);
        add(phone);

        JLabel phoneLabel=new JLabel();
        phoneLabel.setBounds(150, 150, 100, 30);
        add(phoneLabel);

        JLabel email=new JLabel("Email");
        email.setBounds(50, 200, 100, 30);
        add(email);

        JLabel emailLabel=new JLabel();
        emailLabel.setBounds(150, 200, 200, 30);
        add(emailLabel);

        try {
            database c=new database();
            String q="Select * from employee where Empid='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(q);
            while (rs.next()) {
                namelLabel.setText(rs.getString("Name"));
                phoneLabel.setText(rs.getString("Phone"));
                emailLabel.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie)
            {
                try {
                    database c=new database();
                    String q="Select * from employee where Empid='"+cEmpid.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(q);
                    while (rs.next()) {
                        namelLabel.setText(rs.getString("Name"));
                        phoneLabel.setText(rs.getString("Phone"));
                        emailLabel.setText(rs.getString("Email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        add(delete);
        delete.addActionListener(this);

        back= new JButton("Back");
        back.setBounds(200, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);


        setSize(1000, 400);
        setLocation(300,150);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==delete){
            try {
                database c=new database();
                String q="Delete from employee where Empid='"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted  Successfully!!");
                setVisible(false);
                new Home();
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new deleteEmployee();
    }
}
