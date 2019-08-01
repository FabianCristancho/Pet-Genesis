package testLogin;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;

public class ObjectFileOperations {

	public static void createFile(String name, String dir, String ext) {
		if (!new File(dir).exists()) 	
			createDirectory(dir);
		createFile(dir + name + ext);
	}
	
	public static void createDirectory(String dir) {
		File file = new File(dir);
		file.mkdirs();
	}
	
	public static void createFile(String dir) {
		File file = new File(dir);
		try {
			FileWriter toWrite = new FileWriter(file, true);
			toWrite.close();
		} catch (Exception e) {
		}
	}
	
	public static void createBinFile(String name, String dir) {
		createFile(name, dir, ".bin");
	}

	public static void saveBinFile(Object obj, String name, String dir) {
		File file;
		FileOutputStream fos;
		ObjectOutputStream oos;
		file = new File(dir + name + ".bin");
		if (file.exists()) {
			try {
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(obj);
				fos.close();
			} catch (IOException e) {
			}
		} else {
			createBinFile(name, dir);
			saveBinFile(obj, name, dir);
		}
	}

	public static Object loadBinFile(String name, String dir) {
		File file;
		FileInputStream fis;
		ObjectInputStream ois;
		Object ob = null;
		file = new File(dir + name + ".bin");
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				ob = ois.readObject();
				fis.close();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return ob;
		}
		return null;
	}
}