package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addcity extends JPanel {
    private MainFrame parent;
    private JButton cityadd;
    private JButton back;
    private JLabel labelname;
    private JLabel labelcountry;
    private JLabel labelshort_name;
    private JTextField textFieldname;
    private JTextField textFieldcountry;
    private JTextField textFieldshort_name;


    public void showButtonaddcity(){
        labelname.setVisible(true);
        labelcountry.setVisible(true);
        labelshort_name.setVisible(true);
        textFieldname.setVisible(true);
        textFieldcountry.setVisible(true);
        textFieldshort_name.setVisible(true);
        cityadd.setVisible(true);
        back.setVisible(true);
    }



    public addcity(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        labelname = new JLabel("Name");
        labelname.setSize(300,30);
        labelname.setLocation(50,100);
        labelname.setVisible(false);
        add(labelname);

        textFieldname = new JTextField("");
        textFieldname.setSize(300,30);
        textFieldname.setLocation(150,100);
        textFieldname.setVisible(false);
        add(textFieldname);

        labelcountry = new JLabel("Country");
        labelcountry.setSize(300,30);
        labelcountry.setLocation(50,150);
        labelcountry.setVisible(false);
        add(labelcountry);

        textFieldcountry = new JTextField("");
        textFieldcountry.setSize(300,30);
        textFieldcountry.setLocation(150,150);
        textFieldcountry.setVisible(false);
        add(textFieldcountry);

        labelshort_name = new JLabel("Short_name");
        labelshort_name.setSize(300,30);
        labelshort_name.setLocation(50,200);
        labelshort_name.setVisible(false);
        add(labelshort_name);

        textFieldshort_name = new JTextField("");
        textFieldshort_name.setSize(300,30);
        textFieldshort_name.setLocation(150,200);
        textFieldshort_name.setVisible(false);
        add(textFieldshort_name);

        cityadd = new JButton("Add");
        cityadd.setSize(100,30);
        cityadd.setLocation(90,250);
        cityadd.setVisible(false);
        cityadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldname.getText();
                String country = textFieldcountry.getText();
                String short_name = textFieldshort_name.getText();
                city city = new city(name,country,short_name);
                PackageData data = new PackageData("city",city);
                Main.addServer(data);
                textFieldcountry.setText("");
                textFieldname.setText("");
                textFieldshort_name.setText("");
            }
        });
        add(cityadd);

        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(250,250);
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(true);
                parent.getAddcity().setVisible(false);
                parent.getAddair().setVisible(false);
                parent.getAddfly().setVisible(false);
            }
        });
        add(back);


    }


}
