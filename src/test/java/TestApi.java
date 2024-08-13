import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class TestApi {
    private Properties properties;

    @BeforeClass
    public void setup() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        RestAssured.baseURI = properties.getProperty("BASE_URL");
    }

    @Test(priority = 1)
    public void testGetBooks() {
        RestAssured.given()
                .when()
                .get("/api/Book")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("firstName", properties.getProperty("FIRST_NAME"));
        data.put("lastName", properties.getProperty("LAST_NAME"));
        data.put("gender", properties.getProperty("GENDER"));
        data.put("password", properties.getProperty("PASSWORD"));
        data.put("confirmPassword", properties.getProperty("PASSWORD"));  // Assuming same as PASSWORD
        data.put("username", properties.getProperty("USERNAME"));

        RestAssured.given()
                .contentType(ContentType.JSON)
                .cookie("ARRAffinity", "227011b2e2632fdca027bd8016fbc746e32106ec420672f296549087fbefe89f")
                .body(data)
                .when()
                .post("/api/User")
                .then()
                .statusCode(200)
                .log().all();
    }
}
