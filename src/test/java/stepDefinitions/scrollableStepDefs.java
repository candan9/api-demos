package stepDefinitions;


import io.cucumber.java.en.Then;
import pages.ScrollablePage;
import util.DriverFactory;

public class scrollableStepDefs {
    ScrollablePage scrollablePage = new ScrollablePage(DriverFactory.getDriver());
    @Then("scroll to Tabs")
    public void scroll_to_tabs() {
        scrollablePage.scrollToTabsButton();
    }
    @Then("tab to {int}. TAB")
    public void tab_to_tab(Integer count) {
        scrollablePage.tabTo(count);
    }

    @Then("check tab content {string}")
    public void check_tab_content(String string) {
        scrollablePage.checkContent(string);
    }
}
