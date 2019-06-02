package apiExecutor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiExecute {

	public Response getAPI(String baseuri,String params ,String header){
		/* Rest Assured Init*/		
		RestAssured.baseURI = baseuri;
		RequestSpecification httpRequest = RestAssured.given();

		/* Converting headers to map*/	
		JSONObject headers = new JSONObject(header);
		HashMap<String, Object> map = (HashMap<String, Object>) headers.toMap();
		Iterator itr =  map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>) itr.next();
			httpRequest.header(entry.getKey(),entry.getValue());
		}

		//Hitting API with params
		Response response = httpRequest.get(params);
		return response;
	}
	

}
