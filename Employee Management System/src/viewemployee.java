import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;
  
import javax.swing.*;
import java.awt.*;   

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.proteanit.sql.DbUtils;

public class viewemployee extends JFrame implements ActionListener {

    JTable table;
    Choice CEmployeeid;
    JButton searchButton,priButton,updateButton,backButton;
    viewemployee()
    {
        setLayout(null);
        
        table=new JTable();

        JLabel search=new JLabel("Search By Employee Id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        CEmployeeid = new Choice();
        CEmployeeid.setBounds(180,20,150,20);
        add(CEmployeeid);

        searchButton = new JButton("Search");
        searchButton.setBounds(20, 50, 100, 20);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.white);
        add(searchButton);
        searchButton.addActionListener(this);

        priButton = new JButton("Print");
        priButton.setBounds(150, 50, 100, 20);
        priButton.setBackground(Color.BLACK);
        priButton.setForeground(Color.white);
        add(priButton);
        priButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setBounds(280, 50, 100, 20);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.white);
        add(updateButton);
        updateButton.addActionListener(this);

        backButton= new JButton("BAck");
        backButton.setBounds(410, 50, 100, 20);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        add(backButton);
        backButton.addActionListener(this);


        try {
            database conn =new database();
            ResultSet rs= conn.s.executeQuery("Select * from employee");

            while(rs.next())
            {
                CEmployeeid.add(rs.getString("Empid"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        

        try {
            database conn =new database();
            ResultSet rs= conn.s.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while(rs.next())
            {
                CEmployeeid.add(rs.getString("Empid"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        

        setSize(900,700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==searchButton)
        {
            String query="Select * from employee where Empid= '"+CEmployeeid.getSelectedItem()+"' ";
            try {
                database conn =new database();
                ResultSet rs= conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==priButton)
        {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==updateButton) {
            new updateEmployee(CEmployeeid.getSelectedItem());
            setVisible(false);
        }
        else{
            new Home();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new viewemployee();
    }
}
