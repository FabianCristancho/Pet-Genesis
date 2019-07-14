package PruebasLogin;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PasswordUtil {
	private static final Random random = new Random();
	
	public static HashSalt getHash(String password) throws Exception {
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
			byte[] hash = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			return new HashSalt(enc.encodeToString(hash), enc.encodeToString(salt));
		} catch (NoSuchAlgorithmException e) {
		} catch (InvalidKeySpecException e) {
		}
		throw new Exception("No se pudo crear hash");
	}

	public static boolean ValidatePass(String password, String stringHash, String stringSalt) {
		Base64.Decoder dec = Base64.getDecoder();
		byte[] salt = dec.decode(stringSalt);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
			byte[] hash = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			String currentHash = enc.encodeToString(hash);
			return currentHash.equals(stringHash);
		} catch (NoSuchAlgorithmException e) {
		} catch (InvalidKeySpecException e) {
		}
		return false;
	}
}
