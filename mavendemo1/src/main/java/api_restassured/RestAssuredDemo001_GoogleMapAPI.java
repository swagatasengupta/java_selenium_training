package api_restassured;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredDemo001_GoogleMapAPI {
	/***
	 * Given I have this information When I perform this action Then this should be
	 * the output
	 */
	public static final String GOOGLE_KEY = "AIzaSyBB0GjYSOhdy6Zhrm61Stqf90rHnmm4vy4"; //cloudscaleqa account

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";

	}

	@Test
	public void apitest001() {
		given().param("units", "imperial").param("origins", "Washington,DC").param("destinations", "New+York+City,NY")
				.param("key", GOOGLE_KEY).when().get("/distancematrix/json").then().statusCode(200).and()
				.contentType(ContentType.JSON);
	}

	@Test
	public void apitest002() {
		given().param("units", "imperial").param("origins", "Washington,DC").param("destinations", "New+York+City,NY")
				.param("key", GOOGLE_KEY).when().get("/distancematrixINVALID/json").then().statusCode(404);
	}

	@Test
	public void apitest003() throws JSONException, IOException {

		Response resp = given().param("units", "metric")
				.param("origins", "The Platina, Jayabheri Enclave, Gachibowli, Hyderabad, Telangana 500032")
				.param("destinations",
						"Cyber Towers, Hitech City Road, HITEC City, Madhapur, Hyderabad, Telangana 500081")
				.param("key", GOOGLE_KEY).when().get("/distancematrix/json");
		JSONObject jsonBody = new JSONObject((Map) resp.body().jsonPath().getJsonObject(""));
		System.out.println(jsonBody.get("status"));
		System.out.println(jsonBody.get("destination_addresses"));
		resp.then().statusCode(200);
	}

	@Test(enabled = false)
	public void apitest004() throws IOException {

		String json = new String(Files.readAllBytes(Paths.get("resources/twitter_new_tweet.json")),
				StandardCharsets.UTF_8);
		System.out.println(json);
	}

}
