import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class sensyneteststepdef {

    @When("^I hit the Get products Api$")
    public void i_hit_the_Get_products_Api() throws UnirestException {
        sensyneapitest.getProducts();

    }

    @Then("^I should see the available products$")
    public void i_should_see_the_available_products() throws Throwable {
        Assert.assertTrue("Status is not 200",sensyneapitest.areproductsAvailable());
    }

    @When("^I try to add a record with name (.*) and price (.*)$")
    public void i_try_to_add_a_record_with_name_and_price(String name, Double price) throws UnirestException {
        sensyneapitest.addProduct(name,price);
    }

    @Then("^The record should be added$")
    public void thenIVerifyRecordIsAdded() throws UnirestException {
        Assert.assertTrue("Record not added ",sensyneapitest.verifyRecordAdded());
    }

}
