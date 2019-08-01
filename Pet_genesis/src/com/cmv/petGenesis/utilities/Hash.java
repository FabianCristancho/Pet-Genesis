package com.cmv.petGenesis.utilities;

/**
 * Clase Hash - Se encarga de la codificación y decodificación de las contraeñas
 * para los usuarios
 *
 * @version 1.0 - 1/08/2019
 * @author Yohan Caro - Fabian Cristancho
 */
public class Hash {

	/**
	 * Retorna un hash a partir de un tipo y un texto
	 * @param txt texto
	 * @param hashType tipo
	 * @return cadena s
	 */
	public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Retorna un hash MD5 a partir de un texto
	 * @param txt texto
	 * @return cadena s
	 */
	public static String md5(String txt) {
		return Hash.getHash(txt, "MD5");
	}

	/**
	 * Retorna un hash SHA1 a partir de un texto
	 * @param txt texto
	 * @return cadena s
	 */
	public static String sha1(String txt) {
		return Hash.getHash(txt, "SHA1");
	}

}