package apiExecutor;

import io.restassured.response.Response;
import utils.loadProps;

public class executeWrapper {

	public void load() {
	loadProps pr=new loadProps(); 
	pr.prop();
	System.out.println("Properties file loaded");
	}
	
	public Response getweather() {
		
		
		return null;
		
	}
}
