package javanet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPByHostName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub     
        try {
            //InetAddress host = InetAddress.getByName("DESKTOP-8T7H1GT");
           // InetAddress host = InetAddress.getByName("MACBOOKAIR-DEF6");
        	InetAddress host = InetAddress.getByName("SWA-UBUNTU01");
            System.out.println(host.getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

	}

}
