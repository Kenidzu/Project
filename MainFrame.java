package Project;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Mainmenu mainmenu;
    private Kassir kassir;
    private Admin admin;
    private addcity addcity;
    private addair addair;
    private addfly addfly;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aviasales");
        setSize(500,500);
        setLayout(null);

        mainmenu = new Mainmenu(this);
        mainmenu.setVisible(true);
        add(mainmenu);

        kassir =  new Kassir(this);
        kassir.setVisible(true);
        add(kassir);

        admin = new Admin(this);
        admin.setVisible(true);
        add(admin);

        addcity = new addcity(this);
        addcity.setVisible(true);
        add(addcity);

        addair = new addair(this);
        addair.setVisible(true);
        add(addair);

        addfly = new addfly(this);
        addfly.setVisible(true);
        add(addfly);
    }

    public Mainmenu getMainmenu() {
        return mainmenu;
    }

    public Kassir getKassir() {
        return kassir;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Project.addcity getAddcity() {
        return addcity;
    }

    public Project.addair getAddair() {
        return addair;
    }

    public Project.addfly getAddfly() {
        return addfly;
    }
}
