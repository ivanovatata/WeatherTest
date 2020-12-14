package ru.weather.test

import spock.lang.Specification
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when

class WeatherTestSpec extends Specification{

    def "getStatusCode200"() {
        expect:
            given().
                    queryParam("access_key", "fbeee5aa924dc0756704d75bcecb3e76").
                    queryParam("query", "New York")
            when().
                    get("http://api.weatherstack.com/current").
                    then().
                    assertThat().
                    statusCode(200)
        }
}
