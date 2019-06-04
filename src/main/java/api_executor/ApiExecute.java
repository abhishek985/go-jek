package api_executor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiExecute {
	//GET METHOD EXECUTION
	public Response getAPI(String baseuri){
		try {
			/* Rest Assured Init*/		
			RestAssured.baseURI = baseuri;
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get();
			return response;
		}		
		catch(IllegalArgumentException iae){

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;		
	}



	//POST METHOD EXECUTION
	public Response postAPI(String baseuri,String params ,String header){
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
		Response response = httpRequest.post(params);
		return response;
	}

	//PUT METHOD EXECUTION
	public Response putAPI(String baseuri,String params ,String header){
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
		Response response = httpRequest.put(params);
		return response;
	}

	//DELETE METHOD EXECUTION
	public Response deleteAPI(String baseuri,String params ,String header){
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
		Response response = httpRequest.delete(params);
		return response;
	}
}
