package dz5.TestClass;
import dz5.Driver.BaseClass;
import dz5.Pages.MainPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.assertEquals;


public class UserMenu extends BaseClass {
    private MainPage mainPage = new MainPage();

    @When("I navigate in username")
    public void navigateInUsername() {
        mainPage.moveInpersonalAccount();
    }

    @Then("I should see list by {int} item")
    public void verifyUserList(int count) {
        assertEquals(count,mainPage.getCountListtUserMenu());
    }
}
