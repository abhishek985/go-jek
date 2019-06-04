package utils;

import io.restassured.response.Response;

public class JSONComp{

	public int compare(Response res1, Response res2) {

		String resbody1 = res1.getBody().asString();
		String resbody2 = res2.getBody().asString();

		if(resbody1.equals(resbody2)) 
			return 0;

		else 
			return -1;
	}
}
