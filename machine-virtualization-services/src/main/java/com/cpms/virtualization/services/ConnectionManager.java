package com.cpms.virtualization.services;

import com.cpms.virtualization.models.Characteristics;
import com.cpms.virtualization.models.Monitor;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by Rakib on 11/21/2015.
 */
public class ConnectionManager {

    private static final int BUF_SIZE = 1024;
    private static final int MIN_SIZE = 1;

    public Characteristics getCharacteristicsData() throws IOException {
        Characteristics characteristics = new Characteristics();
        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        Socket clientSocket = null;
        clientSocket = new Socket(hostName, portNumber);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // get progress
        outToServer.write("probe".getBytes());
        char[] buf;
        buf = new char[BUF_SIZE];
        inFromServer.read(buf);
        String output = new String(buf);
        StringTokenizer st = new StringTokenizer(output, ",");
        characteristics.setMachineModelName(st.nextToken());
        characteristics.setCompany(st.nextToken());
        characteristics.setMachineType(st.nextToken());
        characteristics.setMaterial(st.nextToken());
        characteristics.setMaxWidth(st.nextToken());
        characteristics.setMaxDepth(st.nextToken());
        characteristics.setMaxHeight(st.nextToken());
        characteristics.setBuildAreaShape(st.nextToken());
        characteristics.setConnectionType(st.nextToken());
        if (clientSocket != null) {
            clientSocket.close();
        }
        return characteristics;
    }

    public Monitor getMonitorData() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String timeStamp = sdf.format(new Date());
        String bedTemperature = "";
        String nozzleTemperature = "";
        String progress = "";


        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        Socket clientSocket = null;
        clientSocket = new Socket(hostName, portNumber);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        char[] buf;
        // get progress
        outToServer.write("monitor".getBytes());
        buf = new char[BUF_SIZE];
        inFromServer.read(buf);
        String output = new String(buf);
        StringTokenizer st = new StringTokenizer(output, ",");
        progress = st.nextToken();
        nozzleTemperature = st.nextToken();
        bedTemperature = st.nextToken();

        if (clientSocket != null) {
            clientSocket.close();
        }
        return new Monitor(timeStamp, bedTemperature, nozzleTemperature, progress);
    }

    public String printFile(InputStream inputStream) throws IOException {

        String resultMessage = "Success";

        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        byte[] fileBytes = getBytes(inputStream);
        Socket clientSocket = new Socket(hostName, portNumber);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        char[] buf;
        // get progress
        buf = new char[MIN_SIZE];
        outToServer.write("load".getBytes());
        inFromServer.read(buf);
        if (new String(buf).equals("1")) {
            outToServer.write(fileBytes);
            String output = new String(buf);
            StringTokenizer st = new StringTokenizer(output, ",");
        } else {
            resultMessage = "Failure";
        }
        clientSocket.close();
//            resultMessage = "Failure";
        return resultMessage;
    }

    private byte[] getBytes(InputStream is) throws IOException {

        int len;
        int size = 5079000;
        byte[] buf;

        if (is instanceof ByteArrayInputStream) {
            size = is.available();
            buf = new byte[size];
            len = is.read(buf, 0, size);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buf = new byte[size];
            while ((len = is.read(buf, 0, size)) != -1)
                bos.write(buf, 0, len);
            buf = bos.toByteArray();
        }
        return buf;
    }

    public String getMachineStatus() throws IOException {
        String status = "";
        // host ip of raspberry pi
        String hostName = "130.184.104.182";
        // port number of raspberry pi
        int portNumber = Integer.parseInt("12345");

        Socket clientSocket = null;
        clientSocket = new Socket(hostName, portNumber);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        char[] buf;
        // get progress
        outToServer.write("status".getBytes());
        buf = new char[1];
        inFromServer.read(buf);
        String output = new String(buf);
        if (Integer.parseInt(output) == 1) {
            status = "Busy";
        } else {
            status = "Available";
        }

        if (clientSocket != null) {
            clientSocket.close();
        }
        return status;
    }
}