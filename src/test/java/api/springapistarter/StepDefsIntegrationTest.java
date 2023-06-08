package api.springapistarter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.openapitools.model.TeamOut;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    static final String URL = "http://localhost:8080/v1/teamstore";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Given("the client calls POST {word} with")
    public void the_client_calls_POST(String path, DataTable table) throws Throwable {
        JSONObject teamJsonObject = new JSONObject();
        List<List<String>> rows = table.asLists(String.class);
    
        for (List<String> columns : rows) {
            teamJsonObject.put(columns.get(0), columns.get(1));
        }

        executePost(URL + path, teamJsonObject);
    }

    @When("the client calls get {word}")
    public void the_client_calls_GET(String path) throws Throwable {
        executeGet(URL + path);
    }

    @When("the client calls GET {word} by id {word}")
    public void the_client_calls_GET_byId(String path, String id) throws Throwable {
        executeGet(URL + path + '/' + id);
    }

    @When("the client calls PUT {word} by last id with")
    public void the_client_calls_PUT_bylastId(String path, DataTable table) throws Throwable {
        JSONObject teamJsonObject = new JSONObject();
        List<List<String>> rows = table.asLists(String.class);
    
        for (List<String> columns : rows) {
            teamJsonObject.put(columns.get(0), columns.get(1));
        }

        JsonNode root = objectMapper.readTree(latestResponse.getBody());
        executePut(URL + path + '/' + root.path("id").asText(), teamJsonObject);
    }

    @When("the client calls GET {word} by last id")
    public void the_client_calls_GET_bylastId(String path) throws Throwable {
        JsonNode root = objectMapper.readTree(latestResponse.getBody());
        executeGet(URL + path + '/' + root.path("id").asText());
    }

    @When("the client calls DELETE {word} by last id")
    public void the_client_calls_DELETE_bylastId(String path) throws Throwable {
        JsonNode root = objectMapper.readTree(latestResponse.getBody());
        executeDelete(URL + path + '/' + root.path("id").asText());
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is NOK : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("the client receives object with")
    public void the_client_receives_key_value(DataTable table) throws Throwable {
        JsonNode root = objectMapper.readTree(latestResponse.getBody());
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> columns : rows) {
            assertThat("field is NOK : " + latestResponse.getBody(), root.path(columns.get(0)).asText(), is(columns.get(1)));
        }
    }
}
