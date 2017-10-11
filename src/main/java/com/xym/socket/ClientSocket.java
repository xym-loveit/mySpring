package com.xym.socket;

import java.io.*;
import java.net.Socket;

/**
 * 客户端socket
 *
 *
 * @author xym
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端开启...");
        Socket client = new Socket("localhost", 8080);
        OutputStream outputStream = client.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("客户端向服务器发送消息");
        printWriter.flush();//此句关键
        InputStream inputStream = client.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println("客户端接受到服务器端消息=" + s);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        printWriter.close();
        outputStream.close();
        client.close();
    }
}