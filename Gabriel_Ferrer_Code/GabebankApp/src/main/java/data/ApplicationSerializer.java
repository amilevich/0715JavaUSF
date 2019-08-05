package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Application;
import seed.PrimaryModels;

public class ApplicationSerializer {
	private static String filename = "src/main/application.txt";

	public static void main(String[] args) {
		PrimaryModels.seed();
		serialize(Application.getAll());
		// deserialize();
		Application.setAll(deserialize());
	}

	public static void serialize(TreeMap<Integer, Application> applications) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject( applications );

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	}

	public static TreeMap<Integer, Application> deserialize() {
		TreeMap<Integer, Application> applications = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			applications = (TreeMap<Integer, Application>) inputStream.readObject();
			fileInputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			// TODO Auto-generated catch block
			cnf.printStackTrace();
		}
//		Set set = applications.entrySet();
//		Iterator iterator = set.iterator();
//		while (iterator.hasNext()) {
//			Map.Entry mentry = (Map.Entry) iterator.next();
//			System.out.print("key: " + mentry.getKey() + " & Value: ");
//			System.out.println(mentry.getValue());
//		}
		return applications;
	}
}
