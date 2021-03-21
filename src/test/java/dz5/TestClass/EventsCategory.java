package dz5.TestClass;

import dz5.Driver.BaseClass;
import dz5.Pages.Сategory;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;

public class EventsCategory extends BaseClass{

    @Autowired
    private Сategory сategory;

    @Then("I should see page calendar of courses with title {string}")
    public void iShouldSeePageCalendarOfCourse(String title) {
        title=title.replace("\\n","\n");
            assertEquals(title,сategory.getTitleOfEventTab1());
    }
    @Then("I should see page calendar of event with title {string}")
    public void iShouldSeePageCalendarOfEvent(String title) {
        assertEquals(title,сategory.getTitleOfEvenTab2());
    }
}
