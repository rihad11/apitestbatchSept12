import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	
	
	
	
	@Test
	public void postCall() {
		
		RestAssured.baseURI="https://reqres.in/api"; // base URL
		
		RequestSpecification httpreq = RestAssured.given();
		
		
		
		JSONObject reqParam= new JSONObject();
		reqParam.put("name", "John Constantine");
		reqParam.put("job", "Exorcist");
		
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqParam.toJSONString());
		
		
		
		Response response = httpreq.request(Method.POST,"/users");// Filtering data- whatever data you want to look at
		
		String responseBody = response.getBody().asString(); // getting response
		
		System.out.println(responseBody);// printing response
		
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 201);// validation of status code
		
		
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");// validation of status line	
		
		
		String allcontents=response.header("Content-Type");
		System.out.println("contents are :"+ allcontents);
		
		Headers allheaders = response.headers();
		
		for(Header header:allheaders) {
			
			
			System.out.println(header.getName() +"    "+header.getValue());
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
