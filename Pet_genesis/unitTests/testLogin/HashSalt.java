package testLogin;

import java.io.Serializable;

public class HashSalt implements Serializable{
	private String hash;
	private String salt;

	public HashSalt(String hash, String salt) {
		this.hash = hash;
		this.salt = salt;
	}

	public String getHash() {
		return hash;
	}

	public String getSalt() {
		return salt;
	}
}