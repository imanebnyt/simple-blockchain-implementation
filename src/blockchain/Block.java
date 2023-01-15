package blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int index;
	private Long timestamp;
	private String data;
	private String previousHash;
	private String hash;
	
	public Block(int index, String data, String previousHash) {
		this.index = index; 
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = System.currentTimeMillis();
		this.hash = calculateHash();
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public Long getTimeStamp() {
		return timestamp;
	}
	
	public void setTimeStamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getPreviousHash() {
		return previousHash;
	}
	
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	// set hash
	public String calculateHash() {
		String text = String.valueOf(index + previousHash + String.valueOf(timestamp) + String.valueOf(data));
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final byte bytes[] = digest.digest(text.getBytes());
		final StringBuilder hexString = new StringBuilder();
		
		for (final byte b : bytes) {
			String hex = Integer.toHexString(0xff &b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
		
}