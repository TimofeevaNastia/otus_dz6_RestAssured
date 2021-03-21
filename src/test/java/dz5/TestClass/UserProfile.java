package dz5.TestClass;
import dz5.Driver.BaseClass;
import dz5.Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class UserProfile  extends BaseClass {
    private MainPage mainPage = new MainPage();

    @Given("I authorization")
    public void auth() {
        mainPage=new MainPage().clickEnter().auth(cfg.login(),cfg.passwors());
    }
    @Given("I open by {string}")
    public void openPage(String url) {
        setUp(url);
    }

    @Given("I open and authorization by {string}")
    public void openAndAuth(String url) {
        setUp(url);
        mainPage=new MainPage().auth(cfg.login(),cfg.passwors());
    }
    @When("I select item with name {string}")
    public void clickUserItem(String section) {
        mainPage.goToLink(section);
    }
    @Then("I should see title {string} over")
    public void verifyUserList(String title) {
        assertEquals(title,mainPage.getMainTitle());
    }
    @And("I should see active tab {string}")
    public void activeTab(String title) {
        assertEquals(title,mainPage.activeTab());
    }
    @And("I should see {int} tab")
    public void listTab(int count) {
        assertEquals(count,mainPage.getCountPersonalTab());
    }
}
