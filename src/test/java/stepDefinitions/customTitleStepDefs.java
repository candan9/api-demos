package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.CustomTitlePage;
import util.DriverFactory;

public class customTitleStepDefs {
    CustomTitlePage customTitlePage = new CustomTitlePage(DriverFactory.getDriver());

    @Then("type left input {string}")
    public void type_left_input(String text) {
        customTitlePage.typeOnLeftTextBox(text);
    }

    @Then("type right input {string}")
    public void type_right_input(String text) {
        customTitlePage.typeOnRightTextBox(text);
    }

    @Then("click Change left button")
    public void click_change_left_button() {
        customTitlePage.clickLeftEditButton();
    }

    @Then("click Change right button")
    public void click_change_right_button() {
        customTitlePage.clickRightEditButton();
    }

    @Then("assert left section is changed as {string}")
    public void assert_left_section_is_changed_as(String text) {
        customTitlePage.checkLeftLabelText(text);
    }

    @Then("assert right section is changed as {string}")
    public void assert_right_section_is_changed_as(String text) {
        customTitlePage.checkRightLabelText(text);
    }
}
