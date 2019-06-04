package test;
import java.io.IOException;
import org.xml.sax.SAXException;

import utils.ReadFile;
public class test {

	public static void main(String args[]) throws IOException, SAXException {
		ReadFile rf = new ReadFile();
		rf.read("File1","File2");
	}
}
