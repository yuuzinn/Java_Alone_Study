package javaOfGod.version2.ch28;

import java.net.Socket;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample test = new SocketClientSample();
        test.sendSocketSample();
    }

    public void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData("EXIT");
    }

    public void sendSocketData(String data) {
        Socket socket = null;
//        try {
//            System.out.println("Client : Connecting");
//            socket = new Socket("127.0.0.1", 9999);
//            System.out.println("Client : Connect status : " + socket.isConnected());

//        }
    }
}
