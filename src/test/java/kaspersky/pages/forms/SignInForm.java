package kaspersky.pages.forms;

import org.openqa.selenium.By;
import webdriver.elements.*;

public class SignInForm {

    private final TextBox txbUserEmailField = new TextBox(By.xpath("//input[@type='email']"), "Email Field");
    private final TextBox txbUsePasswordField = new TextBox(By.xpath("//input[@type='password']"), "Password Field");
    private final Button btnSignIn = new Button(By.xpath("//button[contains(@class,'btn-signin')]"), "SignIn Button");

    public void sigIn(String userEmail, String password){
        txbUserEmailField.setText(userEmail);
        txbUsePasswordField.setText(password);
        btnSignIn.clickAndWait();
    }
}
