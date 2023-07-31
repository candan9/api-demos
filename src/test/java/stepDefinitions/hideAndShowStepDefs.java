package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.GeneralMenusPage;
import pages.HideAndShowPage;
import util.DriverFactory;

public class hideAndShowStepDefs {
    HideAndShowPage hideAndShowPage = new HideAndShowPage(DriverFactory.getDriver());

    @Then("click Show button and button name is {string}")
    public void click_show_button_and_button_name_is(String text) {
        hideAndShowPage.clickShowButton(text);
    }

    @Then("click Hide button and button name is {string}")
    public void click_hide_button_and_button_name_is(String text) {
        hideAndShowPage.checkElementsOpened();
        hideAndShowPage.clickHideButton(text);
    }
}
