package utils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.LineIterator;

import apiExecutor.apiExecute;
import io.restassured.response.Response;

import org.apache.commons.io.FileUtils;
public class ReadFile1 {
	public void read(String File1,String File2) throws IOException {
		System.out.println(File1);
		File f1 = new File("src/main/resources/"+File1+".txt");
		File f2 = new File("src/main/resources/"+File2+".txt");

		LineIterator it1 = FileUtils.lineIterator(f1);
		LineIterator it2 = FileUtils.lineIterator(f2);

		apiExecute ae=new apiExecute();

		try {
			while (it1.hasNext()) {
				String line1 = it1.nextLine();
				String line2 =it2.nextLine();

				while(line1!=null || line2!=null) {
					Response res1 =ae.getAPI(line1);
					Response res2 =ae.getAPI(line2);

					if((res1.asString()).equals(res2.asString())) {
						System.out.println(line1 +" equals "+ line2 );
					}
					else
						System.out.println(line1 +" not equals "+ line2 );

					line1 = it1.nextLine();
					line2 =it2.nextLine();
				}
			}
		} 
		finally {
			it1.close();
			it2.close();
		}
	}
}
