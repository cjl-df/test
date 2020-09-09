package com.books.tomcat.chapter2;

import com.books.tomcat.chapter1.HttpServer;
import com.books.tomcat.chapter1.Request;
import com.books.tomcat.chapter1.Response;
import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await(){
        ServerSocket server = null;
        int port = 8080;
        try {
            server = new ServerSocket(8080,1,new InetAddress("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        while(!shutdown){
            Socket socket = null;
            OutputStream output = null;
            InputStream input = null;
            try {
                socket = server.accept();
                output = socket.getOutputStream();
                input = socket.getInputStream();

                //create request object
                Request request = new Request(input);
                request.parse();

                //create response object
                Response response = new Response(output);
                response.setRequest(request);

                //check if this is a request to a servlet  or a static resource
                //a request for servlet begins with "/servlet/"
                if(request.getUri().startsWith("/servlet/")){
//                    ServletProcessor1 processor = new ServletProcessor1or1();
//                    processor.process(request,response);
                }else{

                }

                //close the socket
                socket.close();

                //check if the previous url is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            }catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }

    }
}
