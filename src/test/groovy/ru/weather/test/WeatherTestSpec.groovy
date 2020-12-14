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

    def "Test to validate status code 200 current data"() {
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

    def "Test to validate status code 200 historical data"() {
        expect:
            given().
                    queryParam("query", city).
                    queryParam("historical_date", historicalDate).
                    queryParam("hourly", interval)
            when().
                    get("/historical").
                    then().
                    assertThat().
                    statusCode(200)
        where:
        city       |historicalDate  |interval
        "New York" |"2018-12-31"    |"12"
        "Moscow"   |"2018-12-31"    |"12"
        "London"   |"2018-12-31"    |"12"
    }
}