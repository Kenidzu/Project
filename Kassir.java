package Project;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kassir extends JPanel {
    private MainFrame parent;
    private JButton buttonadd;
    private JButton buttonback;
    private JLabel flight_id;
    private JTextField textFieldflight_id;
    private JLabel name;
    private JTextField textFieldname;
    private JLabel surname;
    private JTextField textFieldsurname;
    private JLabel passport_number;
    private JTextField textFieldpassport_number;
    private JLabel ticket_type;
    private JTextField textFieldticket_type;
    private JTextArea information;

    public void shorButtonkassir(){
        buttonadd.setVisible(true);
        buttonback.setVisible(true);
        flight_id.setVisible(true);
        textFieldflight_id.setVisible(true);
        name.setVisible(true);
        textFieldname.setVisible(true);
        surname.setVisible(true);
        textFieldsurname.setVisible(true);
        passport_number.setVisible(true);
        textFieldpassport_number.setVisible(true);
        ticket_type.setVisible(true);
        information.setVisible(true);
        textFieldticket_type.setVisible(true);
    }

    public Kassir(MainFrame parent){
        this.parent = parent;
        setSize(1000,1000);
        setLayout(null);

        boolean connect = Main.connect();

        flight_id = new JLabel("flight_id");
        flight_id.setSize(300,30);
        flight_id.setLocation(50,100);
        flight_id.setVisible(false);
        add(flight_id);

        textFieldflight_id = new JTextField("");
        textFieldflight_id.setSize(100,30);
        textFieldflight_id.setLocation(150,100);
        textFieldflight_id.setVisible(false);
        add(textFieldflight_id);

        name = new JLabel("Name");
        name.setSize(300,30);
        name.setLocation(50,150);
        name.setVisible(false);
        add(name);

        textFieldname = new JTextField("");
        textFieldname.setSize(100,30);
        textFieldname.setLocation(150,150);
        textFieldname.setVisible(false);
        add(textFieldname);

        surname = new JLabel("Surname");
        surname.setSize(300,30);
        surname.setLocation(50,200);
        surname.setVisible(false);
        add(surname);

        textFieldsurname = new JTextField("");
        textFieldsurname.setSize(100,30);
        textFieldsurname.setLocation(150,200);
        textFieldsurname.setVisible(false);
        add(textFieldsurname);

        passport_number = new JLabel("passport_number");
        passport_number.setSize(300,30);
        passport_number.setLocation(50,250);
        passport_number.setVisible(false);
        add(passport_number);

        textFieldpassport_number = new JTextField("");
        textFieldpassport_number.setSize(100,30);
        textFieldpassport_number.setLocation(150,250);
        textFieldpassport_number.setVisible(false);
        add(textFieldpassport_number);

        ticket_type = new JLabel("ticket_type");
        ticket_type.setSize(300,30);
        ticket_type.setLocation(50,300);
        ticket_type.setVisible(false);
        add(ticket_type);

        textFieldticket_type = new JTextField("");
        textFieldticket_type.setSize(100,30);
        textFieldticket_type.setLocation(150,300);
        textFieldticket_type.setVisible(false);
        add(textFieldticket_type);

        buttonadd = new JButton("Add");
        buttonadd.setSize(100,30);
        buttonadd.setLocation(80,350);
        buttonadd.setVisible(false);
        buttonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flight_id = textFieldflight_id.getText();
                int flight = Integer.parseInt(flight_id);
                String name = textFieldname.getText();
                String surname = textFieldsurname.getText();
                String passport_number = textFieldpassport_number.getText();
                String ticket_type = textFieldticket_type.getText();
                ticket ticket = new ticket(flight,name,surname,passport_number,ticket_type);
                PackageData data = new PackageData("ticket",ticket);
                Main.addServer(data);
                textFieldname.setText("");
                textFieldsurname.setText("");
                textFieldflight_id.setText("");
                textFieldpassport_number.setText("");
                textFieldticket_type.setText("");
            }
        });
        add(buttonadd);

        buttonback = new JButton("Back");
        buttonback.setSize(100,30);
        buttonback.setLocation(200,350);
        buttonback.setVisible(false);
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdmin().setVisible(true);
                parent.getKassir().setVisible(false);
            }
        });
        add(buttonback);

        information = new JTextArea();
        information.setSize(300,150);
        information.setLocation(50,400);
        information.setVisible(false);
        information.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                PackageData data = packageData();
                information.append(data.getCity().toString());
                information.append(data.getFlight().toString());
                information.append(data.getAicraft().toString());
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });

    }
    public static PackageData packageData(){
        PackageData packageData = new PackageData("list");
        Main.packageData(packageData);
        return packageData;
    }
}
