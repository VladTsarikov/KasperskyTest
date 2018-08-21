package kaspersky.pages.menu;

import framework.enums.NavigateBarLabel;
import org.openqa.selenium.By;
import webdriver.elements.*;

public class NavigateBarMenu {

    private String menuLabel = "//nav[contains(@class,'submenu')]//a[contains(@href,'%s')]";
    private String path;

    public void clickNavigateMenuLabel(NavigateBarLabel navigateBarLabel) {
        path = String.format(menuLabel, navigateBarLabel.getNavigateBarLabel());
        new Label(By.xpath(path), navigateBarLabel.getNavigateBarLabel() + " Label").clickAndWait();
    }
}
