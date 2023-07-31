package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.AlertDialogsPage;
import util.DriverFactory;

public class alertDialogsStepDefs {
    AlertDialogsPage alertDialogsPage = new AlertDialogsPage(DriverFactory.getDriver());
    @Then("click {string} button")
    public void click_button(String string) {
        alertDialogsPage.clickListDialogButton(string);
    }

    @Then("choose any element on list")
    public void choose_any_element_on_list() {
        alertDialogsPage.clickRandomElementButton();
    }

    @Then("verify alert message")
    public void verify_alert_message() {
        alertDialogsPage.checkAlertMessage();
    }
}
