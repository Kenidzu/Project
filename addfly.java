package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addfly extends JPanel {
    private MainFrame parent;
    private JButton addflights;
    private JButton back;
    private JLabel aircraft_id;
    private JLabel departure_city_id;
    private JLabel arrival_city_id;
    private JLabel departure_time;
    private JLabel econom_place_price;
    private JLabel business_place_price;
    private JTextField textFieldaircraft_id;
    private JTextField textFielddeparture_city_id;
    private JTextField textFieldarrival_city_id;
    private JTextField textFielddeparture_time;
    private JTextField textFieldeconom_place_price;
    private JTextField textFieldbusiness_place_price;

    public void showButtonaddfly(){
        addflights.setVisible(true);
        aircraft_id.setVisible(true);
        departure_city_id.setVisible(true);
        arrival_city_id.setVisible(true);
        departure_time.setVisible(true);
        econom_place_price.setVisible(true);
        business_place_price.setVisible(true);
        textFieldaircraft_id.setVisible(true);
        textFielddeparture_city_id.setVisible(true);
        textFielddeparture_time.setVisible(true);
        textFieldeconom_place_price.setVisible(true);
        textFieldbusiness_place_price.setVisible(true);
        back.setVisible(true);
        textFieldarrival_city_id.setVisible(true);
    }

    public addfly(MainFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        aircraft_id = new JLabel("aircraft_id");
        aircraft_id.setSize(300,30);
        aircraft_id.setLocation(100,100);
        add(aircraft_id);

        textFieldaircraft_id = new JTextField("");
        textFieldaircraft_id.setSize(200,30);
        textFieldaircraft_id.setLocation(200,100);
        textFieldaircraft_id.setVisible(false);
        add(textFieldaircraft_id);

        departure_city_id = new JLabel("departure_city");
        departure_city_id.setSize(300,30);
        departure_city_id.setLocation(100,150);
        add(departure_city_id);

        textFielddeparture_city_id = new JTextField("");
        textFielddeparture_city_id.setSize(200,30);
        textFielddeparture_city_id.setLocation(200,150);
        textFielddeparture_city_id.setVisible(false);
        add(textFielddeparture_city_id);

        arrival_city_id = new JLabel("arrival_city");
        arrival_city_id.setSize(300,30);
        arrival_city_id.setLocation(100,200);
        add(arrival_city_id);

        textFieldarrival_city_id = new JTextField("");
        textFieldarrival_city_id.setSize(200,30);
        textFieldarrival_city_id.setLocation(200,200);
        textFieldarrival_city_id.setVisible(false);
        add(textFieldarrival_city_id);

        departure_time = new JLabel("departure_time");
        departure_time.setSize(300,30);
        departure_time.setLocation(100,250);
        add(departure_time);

        textFielddeparture_time = new JTextField("");
        textFielddeparture_time.setSize(200,30);
        textFielddeparture_time.setLocation(200,250);
        textFielddeparture_time.setVisible(false);
        add(textFielddeparture_time);

        econom_place_price = new JLabel("econom_price");
        econom_place_price.setSize(300,30);
        econom_place_price.setLocation(100,300);
        add(econom_place_price);

        textFieldeconom_place_price = new JTextField("");
        textFieldeconom_place_price.setSize(200,30);
        textFieldeconom_place_price.setLocation(200,300);
        textFieldeconom_place_price.setVisible(false);
        add(textFieldeconom_place_price);

        business_place_price = new JLabel("business_price");
        business_place_price.setSize(300,30);
        business_place_price.setLocation(100,350);
        add(business_place_price);

        textFieldbusiness_place_price = new JTextField("");
        textFieldbusiness_place_price.setSize(200,30);
        textFieldbusiness_place_price.setLocation(200,350);
        textFieldbusiness_place_price.setVisible(false);
        add(textFieldbusiness_place_price);

        addflights = new JButton("Add");
        addflights.setSize(100,30);
        addflights.setLocation(130,400);
        addflights.setVisible(false);
        addflights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aircraftid = textFieldaircraft_id.getText();
                int aircraft_id = Integer.parseInt(aircraftid);
                String departure_city_id = textFielddeparture_city_id.getText();
                int departure_city = Integer.parseInt(departure_city_id);
                String arrival_city_id = textFieldarrival_city_id.getText();
                int arrival_city = Integer.parseInt(textFieldarrival_city_id.getText());
                String departure_time = textFielddeparture_time.getText();
                String econom_place_price = textFieldeconom_place_price.getText();
                int econom_price = Integer.parseInt(econom_place_price);
                String business_place_price = textFieldbusiness_place_price.getText();
                int business_price = Integer.parseInt(business_place_price);
                flight flight = new flight(aircraft_id,departure_city,arrival_city,departure_time,econom_price,business_price);
                PackageData data = new PackageData("flights",flight);
                Main.addServer(data);
                textFieldaircraft_id.setText("");
                textFieldarrival_city_id.setText("");
                textFieldbusiness_place_price.setText("");
                textFielddeparture_city_id.setText("");
                textFielddeparture_time.setText("");
                textFieldeconom_place_price.setText("");
            }
        });
        add(addflights);

        back = new JButton("Back");
        back.setSize(100,30);
        back.setLocation(250,400);
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(true);
                parent.getAddfly().setVisible(false);
                parent.getAddcity().setVisible(false);
                parent.getAddair().setVisible(false);
            }
        });
        add(back);

    }
}
