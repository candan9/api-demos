package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.ContextMenuPage;
import util.DriverFactory;

public class contextMenuStepDefs {
    ContextMenuPage contextMenuPage = new ContextMenuPage(DriverFactory.getDriver());
    @Then("long press to button")
    public void long_press_to_button() {
        contextMenuPage.longPressToButton();
    }

    @Then("check {string} and {string} opened")
    public void check_menu_a_and_menu_b_opened(String textA,String textB) {
        contextMenuPage.checkMenus(textA,textB);
    }
}
