package com.books.tomcat.chapter1.servertmp;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer{

    /**
     * WEB_ROOT is the directory where our html and other files reside.
     * For this package , WEB_ROOT is the "WEB_ROOT" directory under the working directory
     * The working directory is the location in the file system
     * from where java command is invoked
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") +
            File.separator + "WEB_ROOT";

    //shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    //THE shutdown command received
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await(){
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        //loop for a request
        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try{
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                //create request object and parse
                Request request = new Request(input);
                request.parse();

                //create Response Object
                Response  response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                //socket close
                socket.close();

                //check if the previouse uri is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }

    }
}
