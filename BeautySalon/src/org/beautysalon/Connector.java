package org.beautysalon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Connector {
	private String ip = "10.0.2.2";
	private int port = 4388;
	private DatagramSocket dsocket;

	public Connector(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			dsocket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public Connector() {
		super();
		try {
			dsocket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public Object sendMessage(Serializable data) {

		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(obj);
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] message = obj.toByteArray();
		InetAddress addr = null;
		try {
			addr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		DatagramPacket pack = new DatagramPacket(message, message.length, addr,
				port);
		try {
			dsocket.send(pack);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] receivedBytes = new byte[1000];
		DatagramPacket receivedPack = new DatagramPacket(receivedBytes,
				receivedBytes.length);
		try {
			dsocket.receive(receivedPack);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteArrayInputStream reply = new ByteArrayInputStream(receivedBytes);
		Object rData = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(reply);
			rData = ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rData;
	}

}
