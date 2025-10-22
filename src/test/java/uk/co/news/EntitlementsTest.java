package uk.co.news;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.news.graphql.RequestUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class EntitlementsTest {

    private final static String BASE_URL = "https://main-graphql.newsapis.co.uk/graphql";
    private final static String ACS_COOKIE = "tid%3D538e17c9-8c59-485c-9951-c68516727be8%26eid%3DCPN-M0RZSCJTZ%26e%3D1%26a%3DRmlsaXAgRHJhYmlr%26u%3D8056f428-fe15-4613-8069-561e5848cbac%26t%3D1761130464%26h%3D54b68140f472fa0c380e8a01afa6bc65";
    private final static String SACS_COOKIE = "45684a1f-c01b-4da9-83ab-f09ad10fbb4b";

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
//    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }


    @Test
    public void whenFeaturesRequested_thenCommentingExists() {
        given()
                .body(RequestUtils.createBody(
                        "query FeatureDecisions {\n" +
                                "            featureDecisions(featureCodes: []) {\n" +
                                "                code\n" +
                                "                name\n" +
                                "                outcome\n" +
                                "                outcomeAsBoolean\n" +
                                "                reason\n" +
                                "            }\n" +
                                "          }"
                ))
                .cookie("acs_tnl", ACS_COOKIE)
                .cookie("sacs_tnl", SACS_COOKIE)
                .contentType("application/json")
                .when()
                .post()
                .then()
                .statusCode(200)
                .assertThat()
                .body("data.featureDecisions", hasItems(hasEntry("code", "fp-1113")));
        ;
    }
}
