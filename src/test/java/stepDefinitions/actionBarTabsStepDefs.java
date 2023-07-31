package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ActionBarTabsPage;
import pages.HomePage;
import util.DriverFactory;

public class actionBarTabsStepDefs {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ActionBarTabsPage actionBarTabsPage = new ActionBarTabsPage(DriverFactory.getDriver());
    @Given("check that the opened app is the desired app")
    public void check_that_the_opened_app_is_the_desired_app() {
        homePage.clickPopupOkButton();
    }
    @When("click {string} tab")
    public void click_tab(String tabName) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickTab(tabName);
    }

    @Then("click {int} times Add new tab button")
    public void click_times_add_new_tab_button(Integer times) {
        for (int i=0 ; i<times ; i++) {
            actionBarTabsPage.clickAddTabButton();
        }
    }

    @Then("click Toggle tab mode button")
    public void click_toggle_tab_mode_button() {
        actionBarTabsPage.clickToggleTabModeButton();
    }

    @Then("check {int} tabs have been added")
    public void check_tabs_have_been_added(int times) {
        actionBarTabsPage.checkItemCount(times);

    }

    @Then("click Remove last tab button")
    public void click_remove_last_tab_button() {
        actionBarTabsPage.clickRemoveLastTabButton();
    }

    @Then("check last tab deleted")
    public void check_last_tab_deleted() {
        actionBarTabsPage.checkLastElementDeleted();
    }

    @Then("click Remove all tabs button")
    public void click_remove_all_tabs_button() {
        actionBarTabsPage.clickRemoveAllTabsButton();
    }

    @Then("check all tabs removed")
    public void check_all_tabs_removed() {
        actionBarTabsPage.checkAllTabsDeleted();
    }
}
