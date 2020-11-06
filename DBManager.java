package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addpackage(PackageData data){
        try {
            if (data.getOperationtype().equals("city")){
                city city = null;
                city = data.getCity();
                PreparedStatement st = connection.prepareStatement("INSERT INTO cities(name, country, short_name) values(?,?,?)");
                st.setString(1,city.getName());
                st.setString(2,city.getCountry());
                st.setString(3,city.getShort_name());
                st.executeUpdate();
                st.close();
            }
            else if (data.getOperationtype().equals("aircraft")){
                aicraft aicraft = null;
                aicraft = data.getAicraft();
                PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(name,model,business_class_capacity,econom_class_capacity) values(?,?,?,?)");
                st.setString(1,aicraft.getName());
                st.setString(2,aicraft.getModel());
                st.setInt(3,aicraft.getBusiness_class_capacity());
                st.setInt(4,aicraft.getEconom_class_capacity());
                st.executeUpdate();
                st.close();
            }else if (data.getOperationtype().equals("flights")){
                flight flight = null;
                flight = data.getFlight();
                PreparedStatement st = connection.prepareStatement("INSERT INTO flights(aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) values(?,?,?,?,?,?)");
                st.setInt(1,flight.getAircraft_id());
                st.setInt(2,flight.getDeparture_city_id());
                st.setInt(3,flight.getArrival_city_id());
                st.setString(4,flight.getDeparture_time());
                st.setInt(5,flight.getEconom_place_price());
                st.setInt(6,flight.getBusiness_place_price());
                st.executeUpdate();
                st.close();
            }else if (data.getOperationtype().equals("ticket")){
                ticket ticket = null;
                ticket = data.getTicket();
                PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(flight_id,name,surname,passport_number,ticket_type) VALUES (?,?,?,?,?)");
                st.setInt(1,ticket.getFlight_id());
                st.setString(2,ticket.getName());
                st.setString(3,ticket.getSurname());
                st.setString(4,ticket.getPassport_number());
                st.setString(5,ticket.getTicket_type());
                st.executeUpdate();
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PackageData packageData (){
        PackageData data = null;
        aicraft aicraft = null;
        city city = null;
        flight flight = null;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = ((PreparedStatement) st).executeQuery();

            while(rs.next()){
                String name = rs.getString("name");
                String model = rs.getString("nodel");
                int businesscap = rs.getInt("business_class_capacity");
                int economcap = rs.getInt("econom_class_capacity");
                aicraft = new aicraft(name,model,businesscap,economcap);
            }
            PreparedStatement ts = connection.prepareStatement("SELECT * FROM cities");
            ResultSet sr = ((PreparedStatement) ts).executeQuery();
            while (sr.next()){
                String name = sr.getString("name");
                String country = sr.getString("country");
                String 	short_name = sr.getString("short_name");
                 city = new city(name,country,short_name);
            }
            PreparedStatement tt = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rr = ((PreparedStatement) tt).executeQuery();
            while (rr.next()){
                int aircraft_id = rr.getInt("aircraft_id");
                int departure_city_id = rr.getInt("departure_city_id");
                int arrival_city_id = rr.getInt("departure_time");
                String departure_time = rr.getString("departure_time");
                int econom_place_price = rr.getInt("econom_place_price");
                int business_place_price = rr.getInt("business_place_price");
                flight = new flight(aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price);
            }
            data = new PackageData(city,flight,aicraft);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
