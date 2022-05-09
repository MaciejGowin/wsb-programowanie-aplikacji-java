package pl.wsb.programowaniejava.maciejgowin.przyklad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.wsb.programowaniejava.maciejgowin.przyklad.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private BankAccount bankAccount;

    @Given("customer bank account balance is set to {double}")
    public void customerAccountBalanceIsSetTo(double balance) {
        bankAccount = BankAccount.builder().balance(balance).build();
    }

    @When("customer adds {double}")
    public void customerAdds(double value) {
        bankAccount.add(value);
    }

    @Then("customer bank account balance is {double}")
    public void customerAccountBalanceIs(double balance) {
        assertEquals(balance, bankAccount.getBalance());
    }
}
