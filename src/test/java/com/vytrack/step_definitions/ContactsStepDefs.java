package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        switch (userType) {
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "sales manager":
                username = ConfigurationReader.get("salesmanager_username");
                password = ConfigurationReader.get("salesmanager_password");
                break;
            case "store manager":
                username = ConfigurationReader.get("storemanager_username");
                password = ConfigurationReader.get("storemanager_password");
                break;
        }
        //send username and password and login
        new LoginPage().login(username,password);
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options (List<String> menuOptions){

        BrowserUtils.waitFor(5);
        //get the list of web element and convert them to list of string and assert
        List <String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }


    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userInfo) {
        System.out.println(userInfo);
        //use map information to login and also verify firstname and lastname
        //login with map info
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));
        //verify firstname and lastname
        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname") + " " + userInfo.get("lastname");

        Assert.assertEquals(expectedName,actualName);
        System.out.println("expectedName = " + expectedName);
        System.out.println("actualName = " + actualName);

    }


}