package kaspersky.pages;

import framework.MailFunctions;
import framework.enums.RegularExpression;
import kaspersky.pages.forms.*;
import org.openqa.selenium.By;
import webdriver.BaseForm;
import framework.RegularExpFinder;
import webdriver.elements.*;

public class DownloadProductPage extends BaseForm {

    private static final String MAIN_LOCATOR = "//article[contains(@class,'osSelect')]";
    private String osPath = "//div[contains(text(),'%s')]";
    private String productPath = "//div[contains(text(),'%s')]/ancestor::div[contains(@class,'download')]//button[contains(@data-section,'Downloads')]";
    public DownloadProductForm downloadProductForm = new DownloadProductForm();
    public SendByEmailForm sendByEmailForm = new SendByEmailForm();
    private String textMsg;

    public DownloadProductPage() {
        super(By.xpath(MAIN_LOCATOR), "Kaspersky Download Product Form");
    }

    public void chooseOperatingSystem(String os){
        new Label(By.xpath(String.format(osPath, os)),"Operating System Label").clickAndWait();
    }

    public void chooseProduct(String product){
        new Button(By.xpath(String.format(productPath, product)),"Product Button").clickViaJS();
    }

    public String verifySendEmails(String userName,String password,String folder,String subject, String regExp){
        MailFunctions mailFunctions = new MailFunctions();
        textMsg = mailFunctions.getMailText(userName,password,folder,subject);
        return RegularExpFinder.findByRegularExp(textMsg,String.format(regExp,DownloadProductForm.getProductId(),DownloadProductForm.getOsId()));
    }
}
