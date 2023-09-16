package tuan8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Stoge {
	public void Save(Object obj, String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName) );
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	public Object Read(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		Object obj;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		obj = ois.readObject();
		return obj;	
	}
}
