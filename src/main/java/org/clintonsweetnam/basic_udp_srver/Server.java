package org.clintonsweetnam.basic_udp_srver;

import java.net.*;

public class Server {
	private static int port;
	
	public static void main(String[] args){
		if(args.length == 1)
			port = Integer.parseInt(args[0]);
		else
			port = 3330;
		
		System.out.format("Starting BasicUdpServer, listening on port %d\n", port);
		
		DatagramSocket serverSocket = null;
		
		try
		{ 
			serverSocket = new DatagramSocket(port); 
		
			byte[] receiveData = new byte[1024]; 
	  
			while(true) 
	        { 
	  
				receiveData = new byte[1024]; 

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 

				System.out.println ("Waiting for datagram packet");

				serverSocket.receive(receivePacket); 

				String sentence = new String(receivePacket.getData()).substring(0, receivePacket.getLength()); 
	  
				InetAddress IPAddress = receivePacket.getAddress(); 
	  
				System.out.println ("From: " + IPAddress + 
						",Port : " + receivePacket.getPort() +
						", Message : " + sentence);
	        } 
		}
		catch (Exception ex){ 
			ex.printStackTrace();
		}
		finally {
			serverSocket.close();
		}

	}
}
