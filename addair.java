package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addair extends JPanel {
    private MainFrame parent;
    private JButton addaircraft;
    private JButton back;
    private JLabel name;
    private JLabel model;
    private JLabel business_class_capacity;
    private JLabel econom_class_capacity;
    private JTextField textFieldname;
    private JTextField textFieldmodel;
    private JTextField textFieldbusiness_class_capacity;
    private JTextField textFieldeconom_class_capacity;

    public void showButtonaddair(){
        name.setVisible(true);
        textFieldname.setVisible(true);
        model.setVisible(true);
        textFieldmodel.setVisible(true);
        business_class_capacity.setVisible(true);
        textFieldbusiness_class_capacity.setVisible(true);
        econom_class_capacity.setVisible(true);
        textFieldeconom_class_capacity.setVisible(true);
        addaircraft.setVisible(true);
        back.setVisible(true);
    }


    public addair(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        name = new JLabel("Name");
        name.setSize(300,30);
        name.setLocation(50,100);
        name.setVisible(false);
        add(name);

        textFieldname = new JTextField("");
        textFieldname.setSize(200,30);
        textFieldname.setLocation(200,100);
        textFieldname.setVisible(false);
        add(textFieldname);

        model = new JLabel("Model");
        model.setSize(300,30);
        model.setLocation(50,150);
        model.setVisible(false);
        add(model);

        textFieldmodel = new JTextField("");
        textFieldmodel.setSize(200,30);
        textFieldmodel.setLocation(200,150);
        textFieldmodel.setVisible(false);
        add(textFieldmodel);

        business_class_capacity = new JLabel("business_capacity");
        business_class_capacity.setSize(300,30);
        business_class_capacity.setLocation(50,200);
        business_class_capacity.setVisible(false);
        add(business_class_capacity);

        textFieldbusiness_class_capacity = new JTextField("");
        textFieldbusiness_class_capacity.setSize(200,30);
        textFieldbusiness_class_capacity.setLocation(200,200);
        textFieldbusiness_class_capacity.setVisible(false);
        add(textFieldbusiness_class_capacity);

        econom_class_capacity = new JLabel("econom_class_capacity");
        econom_class_capacity.setSize(300,30);
        econom_class_capacity.setLocation(50,250);
        econom_class_capacity.setVisible(false);
        add(econom_class_capacity);

        textFieldeconom_class_capacity = new JTextField("");
        textFieldeconom_class_capacity.setSize(200,30);
        textFieldeconom_class_capacity.setLocation(200,250);
        textFieldeconom_class_capacity.setVisible(false);
        add(textFieldeconom_class_capacity);

        addaircraft = new JButton("Add");
        addaircraft.setSize(100,30);
        addaircraft.setLocation(130,300);
        addaircraft.setVisible(false);
        addaircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldname.getText();
                String model = textFieldmodel.getText();
                String business_capacity =  textFieldbusiness_class_capacity.getText();
                int businesscapacity = Integer.parseInt(business_capacity);
                String econom_capacity = textFieldeconom_class_capacity.getText();
                int economcapacity = Integer.parseInt(econom_capacity);
                aicraft air = new aicraft(name,model,businesscapacity,economcapacity);
                PackageData data = new PackageData("aircraft",air);
                Main.addServer(data);
                textFieldname.setText("");
                textFieldmodel.setText("");
                textFieldbusiness_class_capacity.setText("");
                textFieldeconom_class_capacity.setText("");
            }
        });
        add(addaircraft);

        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(250,300);
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
