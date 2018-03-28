package javabase.heatbeat;

/**
 * @program: Joy
 * @description: 客户端心跳
 * @author: suzhengxiao
 * @create: 2018/03/28 17:13
 **/
public class ClientHeart extends Thread {
    @Override
    public void run () {
        while (true) {
            try {
                ClientSender.getInstance().send();
                synchronized (ClientHeart.class) {
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String [] args) {
        ClientHeart clientHeart = new ClientHeart();
        clientHeart.start();
    }

}
