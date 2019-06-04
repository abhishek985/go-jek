package utils;

import io.restassured.response.Response;

public class JSONComp{
	public int compare(String res1, String res2) {
		int status =0;

		try {
			//String resbody1 = res1.getBody().asString();
			//String resbody2 = res2.getBody().asString();

			if(res1.equals(res2)) 
				status= 0;

			else 
				status= -1;
		}
		catch(NullPointerException ne) {
			System.out.println("input was null");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}

