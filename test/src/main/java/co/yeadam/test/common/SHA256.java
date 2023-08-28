package co.yeadam.test.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public String encrypt(String text) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");//sha-256으로 사용
			md.update(text.getBytes());//업데이트할 때 바이트로 실행
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytesToHex(md.digest());
	}

	private String bytesToHex(byte[] digest) {
		StringBuilder builder = new StringBuilder();
		for(byte b : digest) {
			builder.append(String.format("%2x", b));
		}
		return builder.toString();
	}
}
