package org.beautysalon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	private static final int port = 4388;
	private byte[] buff = new byte[1000];
	private DatagramPacket pack;
	private DatagramSocket dsocket;

	public Server() {
		pack = new DatagramPacket(buff, buff.length);
		try {
			dsocket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		processRequest();
	}

	private void processRequest() {
		while (true) {
			try {
				dsocket.receive(pack);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ByteArrayInputStream request = new ByteArrayInputStream(buff);
			Object reqObj = null;
			try {
				ObjectInputStream ois = new ObjectInputStream(request);
				reqObj = ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			response((SendMessage) reqObj);
		}
	}

	private void response(SendMessage request) {

		int type = request.getType();
		Object obj = null;
		switch (type) {

		case SendMessageConstant.LOGIN:
			obj = Util.login(request);
			break;

		case SendMessageConstant.GET_FACE_LIST:
			obj = Util.getFaceList();
			break;

		case SendMessageConstant.GET_FACE_DETAIL:
			obj = Util.getFaceDetail(request);
			break;

		case SendMessageConstant.SEND_FACE_SELF_SCORE:
			Util.updateFaceScore(request);
			break;

		case SendMessageConstant.GET_HAIR_LIST:
			obj = Util.getHairList();
			break;

		case SendMessageConstant.GET_HAIR_DETAIL:
			obj = Util.getHairDetail(request);
			break;

		case SendMessageConstant.SEND_HAIR_SELF_SCORE:
			Util.updateHairScore(request);
			break;

		case SendMessageConstant.GET_PROFILE:
			obj = Util.getProfile(request);
			break;
			
		case SendMessageConstant.UPDATE_USER_INFO:
			Util.UpdateUserInfo(request);
			break;
			
		case SendMessageConstant.GET_RECORD:
			obj = Util.getRecord(request);
			break;
		}

		ByteArrayOutputStream response = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(response);
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] message = response.toByteArray();
		DatagramPacket responsePack = new DatagramPacket(message,
				message.length, pack.getAddress(), pack.getPort());
		try {
			dsocket.send(responsePack);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
