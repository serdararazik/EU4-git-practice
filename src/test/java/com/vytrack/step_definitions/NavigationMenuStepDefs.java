package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Expected and Actual titles are matching");
    }

    @When("the user navigates to Marketting, Campaigns")
    public void the_user_navigates_to_Marketting_Campaigns() {
        System.out.println("the user navigates to Marketting, Campaigns");
    }

    @Then("the title should be Campaings")
    public void the_title_should_be_Campaings() {
        System.out.println("Expected and Actual titles are matching");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("the user navigates to Activities, Calendar Events");
    }

    @Then("the title should be Calendar Events")
    public void the_title_should_be_Calendar_Events() {
        System.out.println("Expected and Actual titles are matching");
    }

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        BrowserUtils.waitFor(5);
        new DashboardPage().navigateToModule(tab,module);
    }


    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(10);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber =Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum,actualNumber);
    }

}
