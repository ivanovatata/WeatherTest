package ru.weather.test

import io.restassured.RestAssured
import io.restassured.specification.RequestSpecification
import spock.lang.Specification
import static io.restassured.RestAssured.*

class WeatherTestSpec extends Specification{


    def setupSpec() {
        RestAssured.baseURI = "http://api.weatherstack.com";
        RestAssured.requestSpecification = given()
                .queryParam("access_key", "fbeee5aa924dc0756704d75bcecb3e76")
    }

    def "Test to validate status code 200"() {
        expect:
            given().
                    queryParam("query", city)
            when().
                    get("/current").
                    then().
                    assertThat().
                    statusCode(200)
        where:
        city << ["New York", "Moscow", "London"]
        }
}
