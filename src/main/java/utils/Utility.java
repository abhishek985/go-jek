package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.SAXException;

import apiExecutor.apiExecute;
import io.restassured.response.Response;
public class Utility {
	apiExecute ae=new apiExecute();
	JSONComp c =new JSONComp();
	XMLComp xc =new XMLComp();	
	BufferedReader reader1;
	BufferedReader reader2;

	public void compareUtility(File file1 ,File file2) throws SAXException {
		try {
			reader1 = new BufferedReader(new FileReader(file1));
			reader2 = new BufferedReader(new FileReader(file2));

			String line1 = reader1.readLine();
			String line2 = reader2.readLine();

			while (line1 !=null  || line2!=null ){
				Response res1 =ae.getAPI(line1);
				String content1 =res1.contentType();
				Response res2 =ae.getAPI(line2);
				String content2 =res2.contentType();

				if(content1.equals(content2) && content1.equals("application/json; charset=utf-8")) {
					if(c.compare(res1.getBody().asString(), res2.getBody().asString()) == 0) {
						System.out.println(line1 +" equals "+ line2 );
					}
					else
						System.out.println(line1 +" not equals "+ line2 );
				}
				else if(content1.equals(content2) && content1.equals("application/xml; charset=utf-8")) {
					if(xc.compare(res1.getBody().asString(), res2.getBody().asString())==true) {
						System.out.println(line1 +" equals "+ line2 );
					}
					else
						System.out.println(line1 +" not equals "+ line2 );
				}
				else
					System.out.println(line1 +" not equals "+ line2 );
				line1 = reader1.readLine();
				line2 = reader2.readLine();
				System.gc();
			}
			reader1.close();
			reader2.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException ne) {
			System.out.println("Line was null");
		}
	}
}
