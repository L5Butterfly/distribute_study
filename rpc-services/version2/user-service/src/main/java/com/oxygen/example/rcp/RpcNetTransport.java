package com.oxygen.example.rcp;

import com.oxygen.example.RpcRequest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 远程RPC 网络Io调用
 * RpcNetTransport
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 3:10
 **/
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws IOException {
        Socket socket=new Socket(host,port);
        return socket;
    }

    public Object send(RpcRequest request){
        ObjectOutputStream outputStream=null;
        ObjectInputStream inputStream=null;
        Socket socket=null;
        try {
            socket=newSocket();
            //IO操作
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();
            inputStream=new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
}
