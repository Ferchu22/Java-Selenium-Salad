package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.World;

public class MathSteps {
    private final World world; // declaration of the variable world, of World type, shares state class

    public MathSteps(World world) { // constructor taking World object as parameter
        this.world = world;  // assign the param world to the instance variable world
    }

    @Given("I have {int} cucumbers")  // {int} is the parameter type that takes the value from the gherkin step
    public void i_have_cucumbers(int count) {
        world.cucumbers = count;// initial count of cucumbers
        world.response = "";    // we use this to clean the response
        world.isError = false;  // we reset the status of the error
    }

    @Given("I have {int} carrots")   // {int} is the parameter type that takes the value from the gherkin step
    public void i_have_carrots(int count) {
        world.carrots = count;     // initial count of carrots
    }

    @When("I eat {int} cucumbers")
    public void i_eat_cucumbers(int count) {
        world.cucumbers -= count;    // does substraction/assignation of the cucumbers.
    }

    @When("I try to eat {int} carrots")
    public void i_try_to_eat_carrots(int carrotsToEat) {
        if (carrotsToEat > world.carrots) {       // if statement to either show a error message or not
            world.response  = "Error: You cant eat more carrots than you have";
            world.isError =true;    // with this we are giving new value to the boolean, instead of false, true
        } else {
            world.carrots -= carrotsToEat;  // does substraction/assignation of the carrots.
            world.response  = "Success: Remaining carrots = " + world.carrots;
            world.isError = false; // since isError = true, for success we do false instead
        }
    }

    @When("I make a salad with {int} cucumbers and {int} carrots")
    public void i_make_a_salad_with_cucumbers_and_carrots(int cucumberCount, int carrotCount) { // initial parameter values for cucumber and carrots
        world.cucumbers -= cucumberCount;   // how many cucumbers are left
        world.carrots -= carrotCount;       // how many carrots are left
        world.salads += 1;     //  does increment/assignation of the salad.
    }

    @Then("I have {int} cucumber")
    public void i_have_cucumber(int count) {
        Assert.assertEquals(count, world.cucumbers);  // validates cucumber count
    }

    @Then("I should see the appropriate response")
    public void verifyResponse() {
        System.out.println(world.response);   // shows result on console
        if(world.response.contains("Error")){
            Assert.assertTrue("Should show error", world.response.startsWith("Error"));  // assertions True if Error
        }else {
            Assert.assertTrue("Should show success", world.response.startsWith("Success")); // assertions True if Success
        }
    }

    @Then("I have {int} salad")
    public void i_have_salad(int count) {
        Assert.assertEquals(count, world.salads);   // validates salad count
    }
}