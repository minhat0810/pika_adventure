//package socket;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//
//import main.Main;
//
//public class GameServer {
//
//	private DatagramSocket socket;
//	private Main game;
//	
//	public GameServer(Main game, String ipAddress) {
//		this.game = game;
//		try {
//			this.socket = new DatagramSocket(1331);
//			
//		}catch(SocketException e){
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void run() {
//		while(true) {
//			byte[] data = new byte[1024];
//			DatagramPacket packet = new DatagramPacket(data, data.length);
//			try {
//				socket.receive(packet);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String message = new String(packet.getData());
//			if(message.equalsIgnoreCase("ping")) {
//				sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
//			}
//		}
//	}
//	public void sendData(byte[] data, InetAddress ipAddress,int  port) {
//		DatagramPacket packet = new DatagramPacket(data, data.length,ipAddress,1331);
//		try {
//			socket.send(packet);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}