package storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("serial")
public class SerialStorage implements Storage {

	private String filename = "file.ser";

	@Override
	public Object read() {
		Object object = null;
		// deserialization
		try {
			// reading object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object = in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized!");
		} catch (IOException ex) {
			System.out.println("IOExeption is caught" + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found exception is caught");
		}
		return object;
	}

	@Override
	public void save(Object o) {
		// Seriaization
		try {
			// Saving of object to a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(o);

			out.close();
			file.close();

			System.out.println("Object has been serialized!");
		} catch (IOException ex) {
			System.out.println("IOExeption is cautht " + ex.getMessage());
		}
	}

}
