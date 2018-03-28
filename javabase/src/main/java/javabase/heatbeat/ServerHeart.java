package javabase.heatbeat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @program: Joy
 * @description: 服务端心跳
 * @author: suzhengxiao
 * @create: 2018/03/28 16:41
 **/
public class ServerHeart extends Thread{

    private ServerSocket serverSocket = null;
    Object obj = new Object();
    @Override
    public void run () {
        try {
            serverSocket = new ServerSocket(9090);
            while (true) {
                Socket client = serverSocket.accept();
                synchronized (obj) {
                    new Thread(new Client(client) ).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: suzhengxiao
     * @Date: 2018/3/28 17:14
    */
    public static void main (String [] args) {
        System.out.println(String.format("Date: %s, 开始检测客户端是否在线...", new Date()));
        new ServerHeart().start();
    }

}
