package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;

//Create to perform Create,Retrieve,Update and Delete requests to the user API

public class UserEndPoints2 {
	
	//Method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//read properties file
		return routes;
	}

	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");//properties file
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(post_url);
		
		return response;			
	}
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");//properties file
		
		Response response = given()
				.pathParam("username",userName)
				
				.when()
				.get(get_url);
		
		return response;			
	}
	
	public static Response updateUser(String userName,User payload)
	{
		String update_url=getURL().getString("update_url");//properties file
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				
				.when()
				.put(update_url);
		
		return response;			
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");//properties file
		
		Response response = given()
				.pathParam("username",userName)
				
				.when()
				.delete(delete_url);
		
		return response;			
	}
}
