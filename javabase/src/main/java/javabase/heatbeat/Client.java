package javabase.heatbeat;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @program: Joy
 * @description: 客户端
 * @author: suzhengxiao
 * @create: 2018/03/28 16:50
 **/
public class Client implements Runnable{
    Socket client;

    public Client(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            while (true){
                ObjectInput in = new ObjectInputStream(client.getInputStream());
                UserInfo userInfo = (UserInfo) in.readObject();
                System.out.println(userInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
