//package socket;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//
//import main.GamePanel;
//import main.Main;
//
//public class GameClient extends Thread{
//
//	private InetAddress ipAddress;
//	private DatagramSocket socket;
//	private Main game;
//	
//	public GameClient(Main game, String ipAddress) {
//		this.game = game;
//		try {
//			this.socket = new DatagramSocket();
//			this.ipAddress = InetAddress.getByName(ipAddress);
//		}catch(SocketException e){
//			e.printStackTrace();
//		} catch(UnknownHostException e) {
//			e.printStackTrace();
//		}
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
//			System.out.println("SERVER> " +new String(packet.getData()));
//		}
//	}
//	public void sendData(byte[] data) {
//		DatagramPacket packet = new DatagramPacket(data, data.length,ipAddress,1331);
//		try {
//			socket.send(packet);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
