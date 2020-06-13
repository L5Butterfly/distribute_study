package com.oxygen.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用的IO Socket编程
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/13 17:49
 **/
public class NewIoServer {

    /**
     * 多路复用器，使用单个线程来管理所有的请求
     */
    static Selector selector;

    /**
     * NIO 非阻塞的网络IO
     * @param args
     */
    public static void main(String[] args) {
        try {
            //开启多路复用器
            selector=Selector.open();
            //selector 必须是非阻塞
            //开启一个IO网络请求通道
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //设置通道监听端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            //把连接事件注册到多路复用器上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select(); //阻塞机制,获取就绪的请求
                Set<SelectionKey> selectionKeySet=selector.selectedKeys();
                Iterator<SelectionKey> iterable=selectionKeySet.iterator();
                while(iterable.hasNext()){
                    SelectionKey key=iterable.next();
                    iterable.remove();
                    if(key.isAcceptable()){
                        //连接事件
                        handleAccept(key);
                    }else if(key.isReadable()){
                        //读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理请求
     * @param selectionKey
     */
    private static void handleAccept(SelectionKey selectionKey){
        ServerSocketChannel serverSocketChannel=(ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel socketChannel=serverSocketChannel.accept() ;//一定会有一个连接
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello Client,I'm NIO Server".getBytes()));
            socketChannel.register(selector,SelectionKey.OP_READ); //注册读事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读的就绪事件
     * @param selectionKey
     */
    private static void handleRead(SelectionKey selectionKey){
        SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer); //这里是不是一定有值
            System.out.println("server receive msg:"+new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
