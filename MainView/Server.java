package MainView;

import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(MainView view){
        try {
            ServerSocket server=new ServerSocket(10000);
            new Thread(){
                @Override
                public void run(){
                    System.out.println("服务端开启");
                    try {
                        while (true){
                            //System.out.println(view.txtIP);
                            if (view!=null){
                                Socket socket=server.accept();
                                System.out.println("响应请求");
                                InputStream is=socket.getInputStream();

                                BufferedReader br=new BufferedReader(new InputStreamReader(is));

                                String line=br.readLine();

                                view.txtChat.append("接受到的消息："+ line+'\n');
                                br.close();
                                socket.close();

                            }
                        }
                    }catch (IOException e){

                        e.printStackTrace();
                    }
                }
            }.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws IIOException{
        MainView view=new MainView();
        Server server=new Server(view);
    }
}
