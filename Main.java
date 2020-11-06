package Project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Main {
    public static Socket socket;
    public static boolean var = false;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    public static boolean connect (){
        try {
            Socket socket = new Socket("Localhost", 2010);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            var = true;
        }catch (Exception e){
            e.printStackTrace();
            var = false;
        }
        return var;
    }

    public static void addServer(PackageData packageData){
        try {
            outputStream.writeObject(packageData);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static PackageData packageData(PackageData packageData){
        PackageData data = null;
        try {
            outputStream.writeObject(packageData);
            if ((data = (PackageData) inputStream.readObject())!=null){
                return data;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
