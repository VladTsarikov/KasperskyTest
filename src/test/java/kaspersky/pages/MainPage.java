package kaspersky.pages;

import kaspersky.pages.forms.SignInForm;
import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.*;

public class MainPage extends BaseForm {

    private static final String MAIN_LOCATOR = "//div[contains(@class,'icon-kpc-logo')]";
    private final Button btnSignIn = new Button(By.xpath("//div[@class='signin-invite']//button"), "SignIn Button");
    public SignInForm signInForm = new SignInForm();

    public MainPage() {
        super(By.xpath(MAIN_LOCATOR), "Kaspersky Main Form");
    }

    public void clickSignInButton(){
        btnSignIn.clickAndWait();
    }
}
