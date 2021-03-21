package dz5.TestClass;

import dz5.Driver.BaseClass;
import dz5.Pages.AboutYourself;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;

public class UserAboutYourself extends BaseClass {
    @Autowired
    private AboutYourself aboutYourself;

    @When("I select tab {string}")
    public void navigateInUsername(String tabName) {
        aboutYourself.clickTab(tabName);
    }
    @Then("I should see {int} item")
    public void verifyTabList(int count) {
        assertEquals(count,aboutYourself.getCountTab());
    }
    @Then("I should see title {string}")
    public void verifyTitleInTab(String title) {
        assertEquals(title,aboutYourself.getTitleInTab());
    }
}
