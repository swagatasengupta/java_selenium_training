package javanet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPLocalHost {

	public static void main(String[] args) {

		try {
			InetAddress ipAddr = InetAddress.getLocalHost();
			System.out.println("ipAddr.getHostAddress(): " + ipAddr.getHostAddress());
			System.out.println("InetAddress.getLoopbackAddress().getHostAddress(): " + InetAddress.getLoopbackAddress().getHostAddress());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}

	}

}
