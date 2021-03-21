package dz5.TestClass;

import dz5.Driver.BaseClass;
import dz5.Pages.Сategory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TeacherСategory extends BaseClass {

    @Autowired
    private Сategory сategory;

    @Then("I should see page became of teacher with title {string}")
    public void iShouldSeePageCalendarOfCourse(String title) {
        assertEquals(title,сategory.getTitleBecameTeacher());
    }

    @And("Must be button with name {string}")
    public void iShouldSeePageCalendarOfEvent(String buttonName) {
        assertEquals(buttonName,сategory.getBtnBecameTeacher());
        }
    @Then("I should see block")
    public void iShouldSeePageCalendarOfCourse(DataTable table1) {
        List<List<String>> table = table1.cells();
        for (int i=0;i<table.size();i++) {
            System.out.println(table.get(i).get(0) + " ");
            assertEquals(table.get(i).get(0), сategory.getNameTabKnowledgeBase(i));
        }
    }
}
