package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JPanel {
    private MainFrame parent;
    private JButton city;
    private JButton aircraft;
    private JButton fly;

    public void showButtonadmin(){
        city.setVisible(true);
        aircraft.setVisible(true);
        fly.setVisible(true);
    }

    public Admin(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);


        boolean connect = Main.connect();

        city = new JButton("City");
        city.setSize(300,30);
        city.setLocation(100,100);
        city.setVisible(false);
        city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(false);
                parent.getAddair().setVisible(false);
                parent.getAddfly().setVisible(false);
                parent.getAddcity().showButtonaddcity();
                parent.getAddcity().setVisible(true);
            }
        });
        add(city);

        aircraft = new JButton("Aicraft");
        aircraft.setSize(300,30);
        aircraft.setLocation(100,150);
        aircraft.setVisible(false);
        aircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(false);
                parent.getAddcity().setVisible(false);
                parent.getAddfly().setVisible(false);
                parent.getAddair().showButtonaddair();
                parent.getAddair().setVisible(true);
            }
        });
        add(aircraft);

        fly = new JButton("Fly");
        fly.setSize(300,30);
        fly.setLocation(100,200);
        fly.setVisible(false);
        fly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(false);
                parent.getAddair().setVisible(false);
                parent.getAddcity().setVisible(false);
                parent.getAddfly().showButtonaddfly();
                parent.getAddfly().setVisible(true);
            }
        });
        add(fly);


    }
}
