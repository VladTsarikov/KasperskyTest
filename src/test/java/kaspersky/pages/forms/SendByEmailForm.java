package kaspersky.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import webdriver.Browser;
import webdriver.elements.*;
import webdriver.waitings.SmartWait;

public class SendByEmailForm {

    private final Button btnSendProductLink = new Button(By.xpath("//button[contains(@data-at-selector,'installerSend')]"), "Send Product Link Button");
    private final Label frame = new Label(By.tagName("iframe"));

    public void clickSendByEmailButton(){
        waitForValidatingСaptcha();
        btnSendProductLink.clickAndWait();
    }

    private void waitForValidatingСaptcha() {
        if (frame.isPresent()) {
            ExpectedCondition<Boolean> condition = d -> false;
            SmartWait.waitForTrue(condition,Browser.getDefaultFrameTimeout());
        }
    }
}
