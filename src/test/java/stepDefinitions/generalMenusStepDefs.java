package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.GeneralMenusPage;
import util.DriverFactory;

public class generalMenusStepDefs {
    GeneralMenusPage generalMenusPage = new GeneralMenusPage(DriverFactory.getDriver());

    @Then("click Enable admin check box")
    public void click_enable_admin_check_box() {
        generalMenusPage.clickEnableAdminCheckbox();
    }
    @Then("scroll to bottom")
    public void scroll_to_bottom() {
        generalMenusPage.scrollToActivateButton();
    }
    @Then("click {string} title")
    public void click_title(String title) {
        generalMenusPage.clickTitle(title);
    }
    @Then("activate button")
    public void activate_button() {
        generalMenusPage.ClickActivateButton();
    }
    @Then("check Enable admin check box is checked")
    public void check_enable_admin_check_box_is_checked() {
        generalMenusPage.CheckEnableAdminChecked();
    }

}
