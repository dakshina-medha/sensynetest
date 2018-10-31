import com.mashape.unirest.http.exceptions.UnirestException;
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
    public void then_I_Verify_Record_Is_Added() throws UnirestException {
        Assert.assertTrue("Record not added ",sensyneapitest.verifyRecordAdded());
    }

    @When("^I try to update a record with product id (.*) and name (.*) and change price to (.*)$")
    public void i_try_to_update_record(String prod_id,String name, Double price_update) throws UnirestException {
        sensyneapitest.updateRecord(prod_id,name,price_update);
    }
    @Then("^The record should be updated$")
    public void then_I_Verify_Record_Is_Updated() throws UnirestException {
        Assert.assertTrue("Record not updated",sensyneapitest.verifyRecordAdded());
    }

    @When("^I try to delete a record with product id (.*)$")
    public void i_try_to_delete_record(String prod_id) throws UnirestException {
        sensyneapitest.deleteRecord(prod_id);
    }

    @Then("^The record should be deleted with product id (.*)$")
    public void then_I_Verify_Record_Is_Deleted(int prod_id) throws UnirestException {
        Assert.assertTrue("Record not deleted",sensyneapitest.verifyRecordDeleted(prod_id));
    }
}
