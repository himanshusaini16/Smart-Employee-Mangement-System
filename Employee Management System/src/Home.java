import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
    JButton add,view,update,delete;
    Home()
    {
        setLayout(null);
       

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image i2=i.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 500);
        add(image);

        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(15, 30, 1000, 50);
        heading.setFont(new Font("serif", Font.PLAIN,50));
        heading.setForeground(Color.red);
        image.add(heading);

        add =new JButton("Add Employee");
        add.setBounds(400, 85, 200, 40);
        image.add(add);
        add.addActionListener(this);
        
        view =new JButton("view Employees");
        view.setBounds(650, 85, 200, 40);
        image.add(view);
        view.addActionListener(this);

        update=new JButton("Update Employee");
        update.setBounds(400, 140, 200, 40);
        image.add(update);
        update.addActionListener(this);

        delete =new JButton("Remove Employee");
        delete.setBounds(650, 140, 200, 40);
        image.add(delete);
        delete.addActionListener(this);



        setSize(910,530);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            new Add();
            setVisible(false);
        }
        else if(e.getSource()==view)
        {
            new viewemployee();
            setVisible(false);
        }
        else if(e.getSource()==update)
        {
            new viewemployee();
            setVisible(false);
        }
        else{
            new deleteEmployee();
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new Home();
    }
}
