package apitests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import api.util.ReadTestData;
import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import api.core.BaseTest;
import api.pojo.postPojo;
import api.util.DataGeneration;
import api.util.ExtentReport;
import api.util.Helper;
import io.restassured.response.Response;

public class apiTestScript extends BaseTest {

    private String accessToken;
    DataGeneration datageneration = new DataGeneration();
    private String name = datageneration.genarateString(6);
    private String job = datageneration.genarateString(7);


//@TestNG

//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateStatusCodeGetUsers() throws IOException, ParseException {	
//		
//	System.out.println("**********************"+ ReadTestData.getTestData("uriGetUsers"));
//	Response resp = given()
//			.when().get(ReadTestData.getTestData("uriGetUsers")); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateStatusCodeGetUser() throws IOException, ParseException {	
//		
//	System.out.println("*****************" + Helper.propertyReader("qaBaseUrl"));
//	
//	
//	//System.out.println("URI is ******:" + uri);
//	
//	Response resp = given().queryParam("page", 2)
//			.when().get(getUri()); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetUs() throws IOException, ParseException {	
//		
//	Response resp = given()
//						.queryParam("page", 2)
//						.when()
//						.get("https://reqres.in/api/users"); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	String actualValue = resp.path("data[1].email");
//	assertEquals(actualValue, ReadTestData.getTestData("expectedEmail"));
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetHeader() {	
//		
//	Response resp = given()
//					.headers("Content-Type","application/json")
//					.when()
//					.get("https://gorest.co.in/public-api/users"); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetPathParam() {	
//		
//	String raceSeasonValue = "2017";
//	Response resp = given().pathParam("raceSeason", raceSeasonValue)
//					.when()
//					.get("http://ergast.com/api/f1/{raceSeason}/circuits.json"); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetBasicAuth() {	
//		
//	Response resp = given()
//			  		.auth()
//			  		.basic("postman", "password")
//					.when()
//					.get("https://postman-echo.com/basic-auth"); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	accessToken = resp.path("token");
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetDigestAuth() {	
//		
//	Response resp = given()
//			  		.auth()
//			  		.digest("postman", "password")
//					.when()
//					.get("https://postman-echo.com/basic-auth"); //RestAssured
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetOauth1Auth() {	
//		
//		  Response resp = given()
//	                		.auth()
//	                		.oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
//	                		.when()
//	                		.get("https://reqres.in/api/users/2");
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetOauth2Auth() {	
//		
//             Response resp = given()
//	                		.auth()
//	                		.oauth2(accessToken)
//	                		.when()
//	                		.get("https://reqres.in/api/users/2");
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validateResponseBodyGetOauth2WithHeader() {	
//		
//		  Response resp = given()
//				  			.header("Authorization", accessToken)
//	                		.when()
//	                		.get("https://reqres.in/api/users/2");
//	
//	int actualStatusCode = resp.statusCode();  //RestAssured
//	assertEquals(actualStatusCode, 200); //Testng
//	System.out.println(resp.body().asString());
//	 
//	}

    @Test(description = "Validate the status code for GET users endpoint", enabled = true, groups = {"SmokeSuite", "RegressionSuite"})
    public void validateResponseBodyPojoPost() throws IOException {
        ExtentReport.extentlog = ExtentReport.extentreport.startTest("validateResponseBodyPojoPost",
                "Validate the status code for GET users endpoint");
        Response resp = given()
                .body(IOUtils.toString(new FileInputStream(new File(System.getProperty("user.dir") + "/Resources/TestData/postRequestBody.json"))))
                .header("Content-type", "application/json")
                .when()
                .post("https://reqres.in/api/users");
        assertEquals(resp.statusCode(), 201); //Testng
    }


//	@Test(description="Validate the status code for GET users endpoint", groups="RegressionSuite")
//	public void validateResponseBodyPojoPostBody() throws IOException {	
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC-001:getHeader",
//				"Validate the status code for GET request");
//		  Response resp = given()
//				  			.body(pojo())
//				  			.header("Content-type", "application/json")
//	                		.when()
//	                		.post("https://reqres.in/api/users");
//	assertEquals(resp.statusCode(), 201); //Testng
//	}
//	
//	@Test(description="Validate the status code for GET users endpoint")
//	public void validatePostBodyComplexPOjo() throws IOException {	
//		
//		pojoComplex pojo = new pojoComplex();
//		//created a list of type string to have all the values defined as per the JSON
//		List<String> job = new ArrayList<>();
//		job.add("tester");
//		job.add("developer");
//		job.add("support");
//		
//		cityModel cities = new cityModel();
//		cities.setName("bangalore");
//		cities.setTemperature("30");
//		cities.setHumidity("20");
//		
//		cityModel cities2 = new cityModel();
//		cities2.setName("delhi");
//		cities2.setTemperature("40");
//		cities2.setHumidity("25");
//		
//		List<cityModel> lst = new ArrayList<>();
//		lst.add(cities);
//		lst.add(cities2);
//		
//		pojo.setName("morpheus");
//		pojo.setJobs(job);
//		pojo.setCitymodels(lst);
//		
//		String testdata = RandomUtils.generateRandomString(5);
//		
//		  Response resp = given()
//				  			.body(pojo())
//				  			.header("Content-type", "application/json")
//	                		.when()
//	                		.post("https://reqres.in/api/users");
//		  assertEquals(resp.statusCode(), 201); //Testng
//	}
//	
////	
//	@Test
//	public static void postmethodwithpojoclass() {
//		String job = RandomUtils.generateRandomString(5);
//		String name = RandomUtils.generateRandomNumericString(8);
//		pojoClass obj = new pojoClass(name,job);
//		Response resp = given().headers("Content-Type","application/json").
//				body(obj).
//				when().post("https://reqres.in/api/users");
//		assertEquals(resp.getStatusCode(),201);
//		System.out.println("The status code for post method is : " + resp.getStatusCode() );
//		System.out.println("The response body of the post method is : " + resp.getBody().asString());
//		assertEquals(resp.path("job"),job);
//		assertEquals(resp.path("name"),name);
//	}


    private static String getUri() throws IOException, ParseException {
        String uri = Helper.propertyReader("qaBaseUrl") + ReadTestData.getTestData("endpointGetUsers");
        return uri;
    }

    private postPojo pojo() {
        postPojo pojo = new postPojo();
        pojo.setName(name);
        pojo.setJob(job);
        return pojo;
    }

}
