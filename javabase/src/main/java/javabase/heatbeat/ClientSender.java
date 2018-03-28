package javabase.heatbeat;

import javax.jws.soap.SOAPBinding;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

/**
 * @program: Joy
 * @description: 客户端发送信息
 * @author: suzhengxiao
 * @create: 2018/03/28 17:16
 **/
public class ClientSender {
    private ClientSender(){

    }

    Socket sender = null;
    private static ClientSender instance;

    public static ClientSender getInstance() {
        if (instance == null) {
             synchronized (ClientSender.class) {
                 instance = new ClientSender();
             }
        }
        return instance;
    }

    public void send () {
        try {
            sender = new Socket(InetAddress.getLocalHost(), 9090);
            while (true) {
                ObjectOutput out = new ObjectOutputStream(sender.getOutputStream());

                UserInfo userInfo = new UserInfo();
                userInfo.setName("Joy");
                userInfo.setSex("Boy");

                out.writeObject(userInfo);
                out.flush();

                System.out.println(String.format("Date:%s, Beating!", new Date()));
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
