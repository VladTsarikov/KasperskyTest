package kaspersky.pages.forms;

import org.openqa.selenium.By;
import webdriver.elements.*;

public class DownloadProductForm {

    private final Link lnkSendByEmail = new Link(By.xpath("//button[contains(@class,'SendEmailLink')]"), "Send By Email Link");
    private final Button btnDownloadProduct = new Button(By.xpath("//button[contains(@class,'download')]"), "Download Product Button");
    private static String productId;
    private static String osId;

    public void clickSendByEmailLink(){
        productId = btnDownloadProduct.getAttribute("data-service-type");
        osId = btnDownloadProduct.getAttribute("data-os-type");
        lnkSendByEmail.clickAndWait();
    }

    public static String getProductId() {
        return productId;
    }

    public static String getOsId() {
        return osId;
    }
}
