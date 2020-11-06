package Project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    DBManager dbManager;

    public ClientHandler() {
    }

    public ClientHandler(Socket socket, int id,DBManager dbManager) {
        this.socket = socket;
        this.id = id;
        this.dbManager = dbManager;
    }

    @Override
    public void run() {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            if ((data = (PackageData) inputStream.readObject())!=null){
                if (data.getOperationtype().equals("list")){
                    data = dbManager.packageData();
                    outputStream.writeObject(data);
                }else{
                    dbManager.addpackage(data);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
