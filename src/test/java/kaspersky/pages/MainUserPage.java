package kaspersky.pages;

import kaspersky.pages.menu.NavigateBarMenu;
import org.openqa.selenium.By;
import webdriver.BaseForm;

public class MainUserPage extends BaseForm {

    private static final String MAIN_LOCATOR = "//i[contains(@class,'logo')]";
    public NavigateBarMenu navigateBarMenu = new NavigateBarMenu();

    public MainUserPage() {
        super(By.xpath(MAIN_LOCATOR), "Kaspersky Main User Form");
    }
}
