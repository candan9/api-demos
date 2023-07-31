package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.HideAndShowPage;
import pages.IncomingMessagePage;
import util.DriverFactory;

public class incomingMessageStepDefs {
    IncomingMessagePage incomingMessagePage = new IncomingMessagePage(DriverFactory.getDriver());


    @Then("click Show Notification button")
    public void click_show_notification_button() {

        incomingMessagePage.clickShowNotificationButton();
    }

    @Then("check notification detail context is similar")
    public void check_notification_detail_context_is_similar() {
        incomingMessagePage.checkNotificationMessage();
    }
}
