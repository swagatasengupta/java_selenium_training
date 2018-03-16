package encode_decode;

import java.util.Base64;

public class EncodeDecodeDemo {

	public static void main(String[] args) {
		byte[] encoded = Base64.getEncoder().encode("Great$h0w1".getBytes());
		System.out.println("Encoded: " + new String(encoded));
		byte[] decoded= Base64.getDecoder().decode(encoded);
		System.out.println("Decoded: " + new String(decoded));
		
	}

}
