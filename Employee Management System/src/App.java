import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements ActionListener
{
    App()
    {
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1300, 50);
        heading.setFont(new Font("serif", Font.PLAIN,50));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image i2=i.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50, 100, 900, 500);
        add(image);

        JButton btn=new JButton("CONTINUE");
        btn.setBounds(750, 450, 100, 30);
        btn.setBackground(Color.black);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        image.add(btn);

        setSize(1000,650);
        setLocation(200, 100);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new login();
    }
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        new App();
    }
}
