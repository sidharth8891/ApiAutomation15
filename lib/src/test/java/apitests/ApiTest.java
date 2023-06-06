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


import io.restassured.response.Response;

public class ApiTest {

    @Test
    public static void verifyGetStatusCode() {
        Response resp = given().queryParam("page", "2").
                when().get("https://reqres.in/api/users");
        int statusCode = resp.getStatusCode();
        System.out.println("Return status code is :" + statusCode);
        System.out.println("Return response body ********************************************" + resp.getBody().asString() + "******************************");
        assertEquals(statusCode, 200);
        System.out.println("test");

    }

    @Test(description = "Validate total for page 2 is 12")
    public static void verifyurl() throws IOException, ParseException {
        Response resp = given().
                when().get(ReadTestData.getTestData("uriGetUsers"));
        String expected = "https://reqres.in/#support-heading";
        int statusCode = resp.getStatusCode();
        System.out.println("Return status code is :" + statusCode);
        System.out.println("Return response body ********************************************" + resp.getBody().asString() + "******************************");
        String i = resp.path("support.url");
        System.out.println("The value of URL is: " + i);
        assertEquals(statusCode, 200);
        assertEquals(i, expected);
    }
	@Test(description="validate 204 for Delete user",groups= {"RegressionSuite","B_User"})
	public void verifyStatusCodeDelete() {

		Response resp = given().delete("https://reqres.in/api/users/2");
		assertEquals(resp.getStatusCode(),204);
		System.out.println("***********************************PASS*******************************");

	}

	@Test(description="Verify email for User with id=2",groups= {"SmokeSuite","RegressionSuite","Payment"})
	public void verifyEmailUIDPathParamGet() throws IOException, ParseException, org.json.simple.parser.ParseException {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("Execute post method",
//				" validate post method");
		String str ="2017";
		Response resp = given().pathParam("raceSeason", str).
				when().get("http://ergast.com/api/f1/{raceSeason}/circuits.json");
		assertEquals(resp.path("MRData.CircuitTable.season"),str);
		//assertEquals(resp.path("MRData.total"),ReadTestData.getTestData("total"));
		System.out.println(resp.getBody().asString());

	}
	@Test(description="Verify status code for GET method-users/2 as 200")
	 public static void verifyStatusCodeGET() throws IOException, org.json.simple.parser.ParseException {
//		ExtentReport.extentlog = ExtentReport.extentreport.startTest("Execute post method",
//				" validate post method");
	     Response resp=given().when().get(ReadTestData.getTestData("uriGetUsers"));
	     assertEquals(resp.getStatusCode(),200);
	     assertEquals(resp.path("support.url"),ReadTestData.getTestData("supportURL"));
	}
//	@Test(priority=2,groups="Auth_OAUTH")
//	public static void auth() {
//		Response resp = given()
//				.auth()
//				.basic("postman", "password").when().get("https://postman-echo.com/digest-auth");
//		Response resp1 = given()
//				.auth()
//				.preemptive().basic("sid", "sid").when().get("https://reqres.in/api/users/2");
//		Response resp2 = given()
//				.auth()
//				.digest("sid", "sid").when().get("https://reqres.in/api/users/2");
//		Response resp3 = given()
//				.auth()
//				.oauth2("accesstoken").when().get("https://reqres.in/api/users/2");
//		Response resp4 = given()
//				.auth()
//				.oauth("consumerKey", "consumerSecret", "accessToken", "secretToken").when().get("https://reqres.in/api/users/2");
//		Response resp5 = given().header("Authorization","Bearer ywtfuytweHNWIuy8r7y6r8764gh")
//					.when().get("https://reqres.in/api/users/2");
//				 
//	}
//	@Test(description= "Automate post method for users")
//	public static void postmethodjson() throws IOException, ParseException, org.json.simple.parser.ParseException {
////		ExtentReport.extentlog = ExtentReport.extentreport.startTest("CreateUserPostMethod",
////				" validate post method");
//		FileInputStream file = new FileInputStream(new File (System.getProperty("user.dir")+"/Resources/TestData/postrequest.json"));
//
//		Response resp = given().header("Content-type","application/json").
//				body(IOUtils.toString(file, ReadTestData.getTestData("encodingType"))).
//				when().post("https://reqres.in/api/users");
//		assertEquals(resp.getStatusCode(),201);
//		System.out.println("The status code for post method is : " + resp.getStatusCode() );
//		System.out.println("The response body of the post method is : " + resp.getBody().asString());
//		//assertEquals(resp.path("job"),ReadTestData.getTestData("expectedJob"));
//
//	}
}
