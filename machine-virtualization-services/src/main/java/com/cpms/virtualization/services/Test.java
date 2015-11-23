package com.cpms.virtualization.services;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Rakib on 11/21/2015.
 */
public class Test {
    public static void main(String[] args) {
        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        char[] buf = new char[1024];

        try {
            Socket clientSocket = new Socket(hostName, portNumber);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // connect the printer
            outToServer.write("connect".getBytes());
            inFromServer.read(buf);
            System.out.println("From Server : " +  new String(buf));

            // get progress
            outToServer.write("monitor".getBytes());
            buf = new char[100];
            inFromServer.read(buf);
            System.out.println("From Server : " +  new String(buf));

            // disconnect machine
            outToServer.write("disconnect".getBytes());
            buf = new char[100];
            inFromServer.read(buf);
            System.out.println("From Server : " + new String(buf));

            clientSocket.close();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
