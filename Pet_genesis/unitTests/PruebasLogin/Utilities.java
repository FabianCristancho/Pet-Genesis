package PruebasLogin;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

//import com.afcr.dynamicstructs.simplelist.SimpleList;
//import com.jfyf.pokemongo.model.entity.Pokemon;
//import com.jfyf.pokemongo.model.entity.User;

/**
 * Clase Utilities.
 *
 * @author Andrés Felipe Chaparro Rosas
 *
 * @since 1.0 29/09/2018
 */
public class Utilities {

//	/**
//	 * Convierte una cadena de caracteres a un array de bytes.
//	 *
//	 * @param string cadena
//	 * @param cut    limite de ccaracteres
//	 * @return bytes de caracteres
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	public static byte[] stringToBytes(String string, int cut) {
//		return stringToBytes(cutString(string, cut));
//	}
//
//	public static byte[] addSizeTo(byte[] currentData, byte[] addData) {
//		byte[] data = new byte[currentData.length + addData.length];
//		fillBytes(data, currentData, 0);
//		fillBytes(data, addData, currentData.length);
//		return data;
//	}
//	
//	public static void fillBytes(byte[] bytes, byte[] auxBytes, int indexInit, int indexEnd) {
//		for (int i = indexInit; i < indexEnd; i++) {
//			bytes[i] = auxBytes[i - indexInit];
//		}
//	}
//
//	public static void fillBytes(byte[] bytes, byte[] auxBytes, int indexInit) {
//		for (int i = indexInit; i < indexInit + auxBytes.length; i++) {
//			bytes[i] = auxBytes[i - indexInit];
//		}
//	}
//
//	
//	/**
//	 * Convierte una cadena de caracteres a un array de bytes.
//	 *
//	 * @param string cadena
//	 * @param cut    limite de ccaracteres
//	 * @return bytes de caracteres
//	 */
//	public static byte[] stringToBytes(char[] string, int cut) {
//		return stringToBytes(cutString(string, cut));
//	}
//
//	/**
//	 * Convierte una cadena de caracteres a un array de bytes.
//	 *
//	 * @param string cadena
//	 * @return bytes de caracteres
//	 */
//	public static byte[] stringToBytes(String string) {
//		byte[] b = new byte[string.length()];
//		for (int i = 0; i < string.length(); i++) {
//			b[i] = (byte) string.charAt(i);
//		}
//		return b;
//	}
//
//	public static byte[] stringToBytes(char[] string) {
//		byte[] b = new byte[string.length];
//		for (int i = 0; i < string.length; i++) {
//			b[i] = (byte) string[i];
//		}
//		return b;
//	}
//
//	/**
//	 * Convierte un array de bytes a String
//	 * 
//	 * @param bytes array de bytes
//	 * @return String con bytes decodificados
//	 */
//	public static String bytesToString(byte[] bytes) {
//		String string = "";
//		for (int i = 0; i < bytes.length; i++) {
//			string += getCharTo(bytes[i]);
//		}
//		return string;
//	}
//
//	public static char getCharTo(byte b) {
//		return (char) (b < 0 ? b + 256 : b);
//	}
//
//	public static byte[] shortToBytes(short s) {
//		byte[] result = new byte[2];
//		for (int i = 1; i >= 0; i--) {
//			result[i] = (byte) (s & 0xFF);
//			s >>= 2;
//		}
//		return result;
//	}
//
//	/**
//	 * Convierte un entero a secuencia de bytes
//	 * 
//	 * @param integer entero a convertir
//	 * @return array de bytes
//	 */
//	public static byte[] intToBytes(int integer) {
//		byte[] result = new byte[4];
//		for (int i = 3; i >= 0; i--) {
//			result[i] = (byte) (integer & 0xFF);
//			integer >>= 4;
//		}
//		return result;
//	}
//
//	public static byte[] longToBytes(long l) {
//		byte[] result = new byte[8];
//		for (int i = 7; i >= 0; i--) {
//			result[i] = (byte) (l & 0xFF);
//			l >>= 8;
//		}
//		return result;
//	}
//
//	public static short bytesToShort(byte[] b) {
//		short result = 0;
//		for (int i = 0; i < 2; i++) {
//			result <<= 2;
//			result |= (b[i] & 0xFF);
//		}
//		return result;
//	}
//
//	public static long bytesToLong(byte[] b) {
//		long result = 0;
//		for (int i = 0; i < 8; i++) {
//			result <<= 8;
//			result |= (b[i] & 0xFF);
//		}
//		return result;
//	}
//
//	/**
//	 * Se encarga de cortar un string si se pasa del limite o de rellenarlo si le
//	 * faltan caracteres.
//	 *
//	 * @param string cadena a cortar
//	 * @param cut    longitud minima
//	 * @return nueva cadena
//	 */
//	public static String cutString(String string, int cut) {
//		String out = "";
//		out += string;
//		if (out.length() == cut)
//			return out;
//
//		if (out.length() < cut)
//			return cutString(out += " ", cut);
//
//		return out.substring(0, cut);
//	}
//
//	public static String cutString(char[] string, int cut) {
//		String out = "";
//		out += new String(string);
//		if (out.length() == cut)
//			return out;
//
//		if (out.length() < cut)
//			return cutString(out += " ", cut);
//
//		return out.substring(0, cut);
//	}
//
//	public static String cutString(String cad) {
//		int i = 0;
//		boolean cond = true;
//		while (cond && i < cad.length()) {
//			if (cad.charAt(i) == 0) {
//				cond = false;
//			}
//			i++;
//		}
//		return cad.substring(0, i - 1);
//	}
//
//	/**
//	 * Convierte bytes a cadeena de caracteres.
//	 *
//	 * @param b bytes
//	 * @return cadena
//	 */
//	public static String charsFromBytes(byte[] b) {
//		char[] chars = new char[b.length];
//		for (int i = 0; i < chars.length; i++) {
//			chars[i] = getCharTo(b[i]);
//		}
//		return new String(chars);
//	}
//
//	/**
//	 * Chars from bytes without spaces.
//	 *
//	 * @param b el dato b
//	 * @return el dato string
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	public static String charsFromBytesWithoutSpaces(byte[] b) {
//		int c = 0;
//		for (int i = 0; i < b.length; i++) {
//			if ((char) b[i] != ' ')
//				c++;
//		}
//		char[] chars = new char[c];
//		for (int i = 0; i < chars.length; i++) {
//			chars[i] = (char) b[i];
//		}
//		return new String(chars);
//	}
//
//	public static int setBytesTo(byte[] data, byte[] aux, int beginIndex) {
//		for (int i = 0; i < aux.length; i++) {
//			data[beginIndex + i] = aux[i];
//		}
//		return aux.length;
//	}

	/**
	 * Obtiene el dato scaled image.
	 *
	 * @param path el dato path
	 * @param d    el dato d
	 * @return el dato scaled image
	 */
	public static Icon getScaledImage(String path, Dimension d) {
		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH));
	}

//	/**
//	 * Obtiene el dato secaled image a partir de una ruta pasado por parametro
//	 * 
//	 * @param path Ruta de imagen
//	 * @return Imagen escalada
//	 */
//	public static Icon getScaledIcon(String path) {
//		return new ImageIcon(path);
//	}
//
//	/**
//	 * Escala un icono a partir de su ruta y nuevas dimensiones
//	 * 
//	 * @param path Ruta de icono
//	 * @param d    Nueva Dimension
//	 * @return Icono escalado
//	 */
//	public static Image getScaledIcon(String path, Dimension d) {
//		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH))
//				.getImage();
//	}
//
//	/**
//	 * Obtiene una imagen
//	 * 
//	 * @param path Ruta de imagen
//	 * @return Imagen
//	 */
//	public static Image getImage(String path) {
//		return new ImageIcon(Utilities.class.getResource(path)).getImage();
//	}
//
//	/**
//	 * Obtiene la imagen de un pokemon
//	 * 
//	 * @return Imagen de pokemon
//	 */
//	public static Image getPokemonImage() {
//		return ConstantPoke.POKEMON_IMAGES.get(new Random().nextInt(ConstantPoke.POKEMON_AVAILABLE));
//	}
//
//	/**
//	 * Obtiene la imagen de un pokemon a partir de un indice
//	 * 
//	 * @param pokemon Indice de pokemon
//	 * @return Imagen de pokemon
//	 */
//	public static Image getPokemonImage(int pokemon) {
//		return ConstantPoke.POKEMON_IMAGES.get(pokemon - 1);
//	}
//
//	/**
//	 * Lee un archivo a partir de su ruta o rutas
//	 * 
//	 * @param path  Ruta de archivo
//	 * @param paths Rutas de archivos
//	 */
//	public static void readFile(String path, SimpleList<String> paths) {
//		fileViewer(new File(path), paths);
//	}
//
//	/**
//	 * Obtiene cada una de las rutas de los archivos contenidos en la aplicacion
//	 * 
//	 * @param file  Archivo a buscar
//	 * @param paths Rutas encontradas
//	 */
//	public static void fileViewer(File file, SimpleList<String> paths) {
//		if (file.isDirectory()) {
//			for (File f : file.listFiles()) {
//				fileViewer(f, paths);
//			}
//		} else {
//			paths.add(file.getPath());
//		}
//	}
//
//	/**
//	 * Copia ciertos elementos dado un array de origen, a un nuevo array de bytes
//	 * 
//	 * @param bytes          Array de origen
//	 * @param beginArray     posicion en donde comience a copiar
//	 * @param lengthNewArray longitud de nuevo array
//	 * @return nuevo array de bytes con ciertos elementos del array origen
//	 */
//	public static byte[] copyBytes(byte[] bytes, int beginArray, int lengthNewArray) {
//		byte[] newBytes = new byte[lengthNewArray];
//		System.arraycopy(bytes, beginArray, newBytes, 0, lengthNewArray);
//		return newBytes;
//	}
//
//	/**
//	 * Se encarga de almacenar las posiciones tipo entero a un array de bytes
//	 * 
//	 * @param origin      bytes de origen que puede contener mas de un elemento
//	 * @param xCoordinate coordenada en x a guardar
//	 * @param yCoordinate coordenada en y a guardar
//	 * @return array de bytes con coordenadas acumuladas
//	 */
//	public static byte[] saveCoordinates(byte[] origin, int xCoordinate, int yCoordinate) {
//		if (origin == null) {
//			origin = convertCoordinatesIntToBytes(xCoordinate, yCoordinate);
//		} else {
//			byte[] temp = origin;
//			int sizeOrigin = origin.length;
//			origin = new byte[sizeOrigin + 8];
//			System.arraycopy(temp, 0, origin, 0, sizeOrigin);
//			temp = convertCoordinatesIntToBytes(xCoordinate, yCoordinate);
//			for (int i = sizeOrigin; i < origin.length; i++) {
//				origin[i] = temp[i - sizeOrigin];
//			}
//		}
//		return origin;
//	}
//
//	/**
//	 * Convierte las posiciones x e y a array de bytes
//	 * 
//	 * @param x Coordenada en x
//	 * @param y Coordenada en y
//	 * @return coordenadas convertidas a bytes
//	 */
//	public static byte[] convertCoordinatesIntToBytes(int x, int y) {
//		byte[] coordinates = new byte[8];
//		System.arraycopy(intToBytes(x), 0, coordinates, 0, 4);
//		System.arraycopy(intToBytes(y), 0, coordinates, 4, 4);
//		return coordinates;
//	}
//
//	/**
//	 * Convierte un array de bytes a entero, desde un indice dado
//	 * 
//	 * @param b     array de bytes
//	 * @param initB indice inicial
//	 * @return Numero entero
//	 */
//	public static int bytesToInt(byte[] b, int initB) {
//		int result = 0;
//		for (int i = initB; i < initB + 4; i++) {
//			result <<= 4;
//			result |= (b[i] & 0xFF);
//		}
//		return result;
//	}
//
//	/**
//	 * Convierte una serie de bytes a una lista simple que representara las
//	 * coordenadas de cada usuario
//	 * 
//	 * @param bytesCoordinates bytes que contiene coordenadas
//	 * @return lista simple con todas las coordenadas
//	 */
//	public static SimpleList<Integer[]> convertBytesCoordinatesToList(byte[] bytesCoordinates) {
//		SimpleList<Integer[]> listCoordinates = new SimpleList<>();
//		for (int i = 0; i < bytesCoordinates.length; i += 8) {
//			listCoordinates.add(new Integer[] { new Integer(bytesToInt(bytesCoordinates, i)),
//					new Integer(bytesToInt(bytesCoordinates, i + 4)) });
//		}
//		return listCoordinates;
//	}
//
//	/**
//	 * Convierte una serie de bytes a coordenadas
//	 * 
//	 * @param bytesCoordinates bytes que contiene coordenadas
//	 * @return aray con coordenadas
//	 */
//	public static int[] convertBytesToCoordinates(byte[] bytesCoordinates) {
//		return new int[] { bytesToInt(bytesCoordinates, 0), bytesToInt(bytesCoordinates, 4) };
//	}
//
//	/**
//	 * Se encarga de almacenar las coordenadas latitud y longitud en un array de
//	 * bytes
//	 * 
//	 * @param origin   array de bytes en donde se van a almacenar los datos
//	 * @param latitude latitud
//	 * @param lenght   longitud
//	 * @return secuencia de bytes con coordenadas
//	 */
//	public static byte[] saveCoordinates(byte[] origin, double latitude, double lenght) {
//		if (origin == null) {
//			origin = convertCoordinatesToBytes(latitude, lenght);
//		} else {
//			byte[] temp = origin;
//			int sizeOrigin = origin.length;
//			origin = new byte[sizeOrigin + 16];
//			System.arraycopy(temp, 0, origin, 0, sizeOrigin);
//			temp = convertCoordinatesToBytes(latitude, lenght);
//			for (int i = sizeOrigin; i < origin.length; i++) {
//				origin[i] = temp[i - sizeOrigin];
//			}
//		}
//		return origin;
//	}
//
//	/**
//	 * Convierte coordenadas de tipo double a secuencia de bytes
//	 * 
//	 * @param latitude Latitud
//	 * @param lenght   Longitud
//	 * @return Secuencia de bytes
//	 */
//	public static byte[] convertCoordinatesToBytes(double latitude, double lenght) {
//		byte[] coordinates = new byte[16];
//		System.arraycopy(doubleToByteArray(latitude), 0, coordinates, 0, 8);
//		System.arraycopy(doubleToByteArray(lenght), 0, coordinates, 8, 8);
//		return coordinates;
//	}
//
//	/**
//	 * Convierte un double a secuencia de bytes
//	 * 
//	 * @param value Valor a convertir
//	 * @return secuencia de bytes
//	 */
//	private static byte[] doubleToByteArray(double value) {
//		byte[] bytes = new byte[8];
//		ByteBuffer.wrap(bytes).putDouble(value);
//		return bytes;
//	}
//
//	/**
//	 * Convierte una secuencia de bytes a un double
//	 * 
//	 * @param bytes Secuencia de bytes a convertir
//	 * @return double convertido
//	 */
//	public static double bytesToDouble(byte[] bytes) {
//		return ByteBuffer.wrap(bytes).getDouble();
//	}
//
//	/**
//	 * Lista simple encargada de convertir una secuencia de bytes a coordenadas tipo
//	 * double
//	 * 
//	 * @param bytesCoordinates secuencia de bytes con coordenadas de usuarios
//	 * @return lista de coordenadas
//	 */
//	public static SimpleList<Double[]> convertBytesCoordinatesToDoubleList(byte[] bytesCoordinates) {
//		SimpleList<Double[]> listCoordinates = new SimpleList<>();
//		for (int i = 0; i < bytesCoordinates.length; i += 16) {
//			listCoordinates.add(new Double[] { new Double(bytesToDouble(since(bytesCoordinates, i))),
//					new Double(bytesToDouble(since(bytesCoordinates, i + 8))) });
//		}
//		return listCoordinates;
//	}
//
//	public static SimpleList<User> convertBytesToBasicUsers(byte[] data) {
//		SimpleList<User> basicUsers = new SimpleList<>();
//		for (int i = 0; i < data.length; i += 40) {
//			basicUsers.add(
//					new User(bytesToDouble(getFractionOf(data, i, 8)), bytesToDouble(getFractionOf(data, i + 8, 8)),
//							charsFromBytesWithoutSpaces(getFractionOf(data, i + 16, 20)),
//							bytesToInt(getFractionOf(data, i + 36, 4), 0)));
//		}
//		return basicUsers;
//	}
//
//	public static SimpleList<Pokemon> convertBytesToPokemon(byte[] data) {
//		SimpleList<Pokemon> pokemon = new SimpleList<>();
//		for (int i = 0; i < data.length; i += 26) {
//			Pokemon p = ConstantPoke.POKEMON_ENTITIES.get(bytesToShort(getFractionOf(data, i + 16, 2)));
//			pokemon.add(new Pokemon(bytesToLong(getFractionOf(data, i + 18, 8)), p.getId(), p.getName(), (byte) 1,
//					bytesToDouble(getFractionOf(data, i, 8)), bytesToDouble(getFractionOf(data, i + 8, 8))));
//		}
//		return pokemon;
//	}
//
//	public static byte[] getFractionOf(byte[] bytes, int indexInit, int size) {
//		byte[] aux = new byte[size];
//		for (int i = 0; i < aux.length; i++)
//			aux[i] = bytes[i + indexInit];
//		return aux;
//	}
//
//	/**
//	 * Dado un array de bytes, corta varios bytes de un vector y los convierte en
//	 * uno màs pequño
//	 * 
//	 * @param originBytes array inicial
//	 * @param index       indice a iniciar
//	 * @param size        tamaño del nuevo array
//	 * @return bytes el nuevo array
//	 */
//	public static byte[] sinceWithSize(byte[] originBytes, int index, int size) {
//		byte[] bytes = new byte[size];
//		System.arraycopy(originBytes, index, bytes, 0, size);
//		return bytes;
//	}
//
//	/**
//	 * Dado un array de bytes, almacena en otro del mismo tipo los elementos del
//	 * origen, a partir de un indice
//	 * 
//	 * @param originBytes Array origen
//	 * @param index       Indice con posicion inicial
//	 * @return nuevo array con algunos elementos
//	 */
//	private static byte[] since(byte[] originBytes, int index) {
//		byte[] bytes = new byte[8];
//		System.arraycopy(originBytes, index, bytes, 0, 8);
//		return bytes;
//	}
//
//
//
//	/**
//	 * Convierte un array de bytes a int
//	 * 
//	 * @param b array de bytes
//	 * @return entero convertido
//	 */
//	public int convertByteToInt(byte[] b) {
//		String cad = "";
//		for (int i = 0; i < b.length; i++) {
//			cad += (char) b[i];
//		}
//
//		System.out.println(cad);
//		int number = 0;
//		try {
//			number = Integer.parseInt(cad);
//			System.out.println(number);
//		} catch (NumberFormatException e) {
//			System.err.println("No es un numero");
//		}
//
//		return number;
//	}
//
//	/**
//>>>>>>> branch 'master' of https://github.com/AndresFelipeChaparro/Pokemon-Viewer-V1.2-Client.git
//	 * Guarda en un array de bytes las coordenadas de un usuario y el nickname
//	 * 
//	 * @param origin   vector de bytes
//	 * @param nickName del user
//	 * @return origin el vector inicial
//	 */
//	public static byte[] saveCoordinatesAndNickName(byte[] origin, String nickName) {
//		byte[] temp = origin;
//		int sizeOrigin = origin.length;
//		origin = new byte[sizeOrigin + 20];
//		System.arraycopy(temp, 0, origin, 0, sizeOrigin);
//		temp = stringToBytes(nickName);
//		for (int i = sizeOrigin; i < temp.length + sizeOrigin; i++) {
//			origin[i] = temp[i - sizeOrigin];
//		}
//		return origin;
//	}
//
//	/**
//	 * Convierte dos coordenadas (grados sexagesimales) en un array de bytes
//	 * 
//	 * @param x length
//	 * @param y latitude
//	 * @return coordinates s
//	 */
//	public static byte[] convertDegreesToBytes(double x, double y) {
//		byte[] coordinates = new byte[16];
//		System.arraycopy(doubleToByteArray(x), 0, coordinates, 0, 8);
//		System.arraycopy(doubleToByteArray(y), 0, coordinates, 8, 8);
//		return coordinates;
//	}
//
//	/**
//	 * Se encarga de almacenar las posiciones tipo double (grados sexagsimal) a un
//	 * array de bytes
//	 * 
//	 * @param origin   bytes de origen que puede contener mas de un elemento
//	 * @param length   en grados a guardar
//	 * @param latitude en grados a guardar
//	 * @return array de bytes con coordenadas acumuladas
//	 */
//	public static byte[] saveDegreesCoordinates(byte[] origin, double length, double latitude) {
//		if (origin == null) {
//			origin = convertDegreesToBytes(length, latitude);
//		} else {
//			byte[] temp = origin;
//			int sizeOrigin = origin.length;
//			origin = new byte[sizeOrigin + 16];
//			System.arraycopy(temp, 0, origin, 0, sizeOrigin);
//			temp = convertDegreesToBytes(length, latitude);
//			for (int i = sizeOrigin; i < origin.length; i++) {
//				origin[i] = temp[i - sizeOrigin];
//			}
//		}
//		return origin;
//	}

}
