package com.books.tomcat.chapter1.servertmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendRequest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            OutputStream os = socket.getOutputStream();
            boolean autoflush = true;
            PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            //send a HTTP request
            out.println("GET /index.jsp HTTP/1.1");
            out.println("Host: localhost:8080");
            out.println("Connection: Close");
            out.println();

            //read the response
            boolean loop = true;
            StringBuffer sb = new StringBuffer(1024);
            while(loop){
                if(in.ready()) {
                    int i = 0;
                    while (i != -1) {
                        i = in.read();
                        sb.append((char) i);
                    }
                    loop = false;
                }
                Thread.currentThread().sleep(50);
            }
            System.out.println(sb.toString());
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
