import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_RestAssured_Project {
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
    String SSHkey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCtNDvpehPVpnPe3fj/sdw9ZoyL3USVWRyyGfWeVuNT0PSV+Cjg9CLsfoET7NbFL+OGgNDHGDuxhlTSdFi+MSZYpld2QCVNFFgJXLA/vIW14V67BzcFPy0j9XGXKJxcnp4IoQ1s0pbGDOYMiN8o6b1X3N6VJnf78h7H4jeaNEmEyAB5QdQYCa4+zEz0enPMfIe8dAGs9SK+CAbO/LWNrYohJGQgw8AYCHZuXf9pTPk38p7eHD+2GFBECOiowMIFhCuyk17eS5xoKZbgv6TyJpvjBQwWkT86tE9bgtZ7r1fgPyIVykjeNqJUIQ620tihn3NgK8iZ36wZ4/oH0aCnmNhv";
    int sshid;
    
    @BeforeClass
    public void setup()
    {
    	requestspec = new RequestSpecBuilder()
    			.setContentType(ContentType.JSON)
    			.setBaseUri("https://api.github.com")
    			.addHeader("Authorization","token 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")
    			.build();
    }	
@Test (priority=1)
public void postreq()
{
	String reqbody = "{\"title\": \"TestB11\", \"key\": \"" + SSHkey + "\" }";
	Response response = given().spec(requestspec).body(reqbody).when().post("/user/keys");
	String resbody = response.getBody().asPrettyString();
	System.out.println(reqbody);
	System.out.println(resbody);
	sshid = response.then().extract().path("id");
	System.out.println("id generated is " + sshid);
	

	response.then().statusCode(201);
}
@Test (priority=2)
public void getreq()
{
	 Response response = given().spec(requestspec).when().get("/user/keys");
	String resbody2 = response.getBody().asPrettyString();
	System.out.println(resbody2);
	response.then().statusCode(200);
}
@Test (priority=3)
public void delreq()
{
	 Response response = given().spec(requestspec).pathParam("keyId",sshid).when().delete("/user/keys/{keyId}");
	String resbody3 = response.getBody().asPrettyString();
	System.out.println(resbody3);
	response.then().statusCode(204);
}

}
