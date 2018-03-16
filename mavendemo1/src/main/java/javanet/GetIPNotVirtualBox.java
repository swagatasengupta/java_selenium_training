package javanet;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
public class GetIPNotVirtualBox {

	public static void main(String[] args) {

		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
/*				if(intf.getDisplayName().contains("VirtualBox") || intf.getDisplayName().contains("Loopback") ) {
					continue;
				}*/
/*				System.out.println("  intf.getName()= " + intf.getName() + " ; intf.getDisplayName()= " + intf.getDisplayName());
				System.out.println("---");*/
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					
					String ip = enumIpAddr.nextElement().getHostAddress();
					if (ip.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
						System.out.println("matches IP pattern");
						System.out.println(" >> ip >>  = " + ip);
						System.out.println("Network Interface Display Name: " + intf.getDisplayName()
						+ "... virtual=" + intf.isVirtual()
						+ "... loopback=" + intf.isLoopback()
						+ "... pointToPoint=" + intf.isPointToPoint());
						//if(intf.isPointToPoint())
					}
					
//					System.out.println(" >> ip >>  = " + ip);
				}
//				System.out.println("=================");
			}
		} catch (SocketException e) {
			System.out.println(" (error retrieving network interface list)");
		}
	

	}

}
