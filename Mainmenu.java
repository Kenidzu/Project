package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainmenu extends JPanel {
    private MainFrame parent;
    private JButton confirm;
    private JTextField textFieldlogin;
    private JPasswordField textFieldpassword;
    private JLabel labellogin;
    private JLabel labelpassword;


    public Mainmenu(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        labellogin = new JLabel("Login");
        labellogin.setSize(300,30);
        labellogin.setLocation(100,100);
        add(labellogin);

        textFieldlogin = new JTextField("");
        textFieldlogin.setSize(300,30);
        textFieldlogin.setLocation(180,100);
        add(textFieldlogin);

        labelpassword = new JLabel("Password");
        labelpassword.setSize(300,30);
        labelpassword.setLocation(100,150);
        add(labelpassword);

        textFieldpassword = new JPasswordField(120);
        textFieldpassword.setSize(300,30);
        textFieldpassword.setLocation(180,150);
        textFieldpassword.setEchoChar('*');
        add(textFieldpassword);

        confirm = new JButton("Confirm");
        confirm.setSize(300,30);
        confirm.setLocation(130,230);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldlogin.getText();
                String password = textFieldpassword.getText();
                if (name.equals("kassir") && password.equals("kassir")){
                    textFieldlogin.setText("");
                    textFieldpassword.setText("");
                    parent.getKassir().setVisible(true);
                    parent.getMainmenu().setVisible(false);
                    parent.getKassir().shorButtonkassir();
                }
                else if (name.equals("admin") && password.equals("admin")){
                    textFieldlogin.setText("");
                    textFieldpassword.setText("");
                    parent.getAdmin().setVisible(true);
                    parent.getMainmenu().setVisible(false);
                    parent.getAdmin().showButtonadmin();
                }
            }
        });
        add(confirm);


    }

}
