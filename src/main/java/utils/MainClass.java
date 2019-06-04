package utils;

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

public class MainClass {
	public static void main(String args[]) throws IOException, SAXException {
		try {
			Utility rf = new Utility();
			File file1 = new File("src/main/resources/File1.txt");
			File file2 = new File("src/main/resources/File2.txt");

			rf.compareUtility(file1,file2);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
