package pl.wsb.programowaniejava.maciejgowin.gatling;

import java.time.Duration;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class LocateApiGatlingSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            // The root for all relative URLs
            //.baseUrl("https://www.ryanair.com/api/views/locate")
            .baseUrl("http://localhost:8080")
            // Common headers
            .acceptHeader("application/json;q=0.9,*/*;q=0.8")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");

    ScenarioBuilder scn = scenario("Location searches") // A scenario is a chain of requests and pauses
            .exec(http("request_1")
                    .get("/5/airports/en/active"))
            .pause(1)
            .exec(http("request_2")
                    .get("/5/airports/en/WRO"))
            .pause(2)
            .exec(http("request_3")
                    .get("/5/airports/en/DUB"))
            .pause(Duration.ofMillis(1500))
            .exec(http("request_4")
                    .get("/5/airports/en/active"))
            .pause(Duration.ofMillis(890))
            .exec(http("request_5")
                    .get("/5/airports/pl/active"))
            .pause(Duration.ofMillis(670))
            .exec(http("request_6")
                    .get("/3/routes"))
            .pause(Duration.ofMillis(629))
            .exec(http("request_7")
                    .get("/3/routes/WRO"))
            .pause(Duration.ofMillis(734))
            .exec(http("request_8")
                    .get("/3/routes/DUB"))
            .pause(1)
            .exec(http("request_9")
                    .get("/3/routes/STN"))
            .pause(0)
            .exec(http("request_10")
                    .get("/3/routes"));

    {
        setUp(scn.injectOpen(atOnceUsers(1)).protocols(httpProtocol));
    }
}
