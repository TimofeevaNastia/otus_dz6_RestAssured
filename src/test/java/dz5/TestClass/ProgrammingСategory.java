package dz5.TestClass;

import dz5.Driver.BaseClass;
import dz5.Pages.Сategory;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProgrammingСategory  extends BaseClass {


    @Autowired
    private Сategory сategory;

    @Then("I should see {int} courses in list of section")
    public void checkCountOfCourseOfSection(int count) {
        assertEquals(count, сategory.getCountOfCourseList());
    }
    @Then("I should see {int} courses in title of section")
    public void checkCountOfCourseOfLabel(int count) {
        Integer count1=(Integer)count;
        assertTrue(сategory.getCountOfCourse().contains(count1.toString()));
    }
}
