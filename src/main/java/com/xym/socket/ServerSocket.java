package com.xym.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务端socket
 *
 * @author xym
 */
public class ServerSocket {

    public static void main(String[] args) throws IOException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);
        System.out.println("服务端开启...");
        Socket accept = serverSocket.accept();
        InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        System.out.println("接受到客户端的消息 line =" + line);
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        printWriter.println("服务端响应消息");
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        accept.close();
    }

}