package dz5.TestClass;

import dz5.Driver.BaseClass;
import dz5.Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static junit.framework.TestCase.assertEquals;

public class NavigationInCategory extends BaseClass {

    private MainPage mainPage= new MainPage();

    @When("I navigate in {string}")
    public void navigateInUsername(String tabName) {
        mainPage.moveInTabMenu(tabName);
    }

    @Then("I should see {int} item in dropping out list from {int} tab")
    public void verifyUserList(int count, int number) {
        assertEquals(count,mainPage.getCountItemInTabInMainForm(number));
    }

    @When("I navigate in tab {string}")
    public void navigateInSubTab(String tabName) {
        mainPage.moveInSubTabMenu(tabName);
    }

    @When("I navigate in add tab")
    public void navigateInAddSubTab() {
        mainPage.moveInSubTabMenuAdd();
    }

    @Then("I should see {int} courses in list of tab {string}")
    public void checkCountOfCourseOfTab(int count, String section) {
        assertEquals(count,mainPage.getCountOfCourseListOfTab(section));
    }

}
