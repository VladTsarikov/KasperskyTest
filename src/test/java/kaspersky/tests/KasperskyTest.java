package kaspersky.tests;

import framework.MailFunctions;
import framework.enums.*;
import kaspersky.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import webdriver.PropertiesResourceManager;
import static org.testng.Assert.*;

public class KasperskyTest extends BaseTest {

    private static PropertiesResourceManager prop = new PropertiesResourceManager("credentials.properties");
    private final static String EMAIL_USERNAME = prop.getProperty("credentials_username");
    private final static String EMAIL_PASSWORD = prop.getProperty("credentials_password");
    private final static String INBOX_FOLDER = "INBOX";
    private final static String SUBJECT_NAME = "Kaspersky";
    private static final String REG_EXP = RegularExpression.DOWNLOAD_LINK.getRegExp();
    private static String kasperskyEmail;
    private static String kasperskyPassword;
    private static String downloadProductOs;
    private static String downloadProduct;

    @Parameters({"email", "password","os","product"})
    @BeforeClass
    public void initParams(String email, String password, String os, String product){
        kasperskyEmail = email;
        kasperskyPassword = password;
        downloadProductOs = os;
        downloadProduct = product;
    }

    @Override
    public void runTest() {
        logStep(1,"OPENING MyKaspersy.com...");
        MainPage mainPage = new MainPage();
        logStep(2,"AUTHORIZATION...");
        mainPage.clickSignInButton();
        mainPage.signInForm.sigIn(kasperskyEmail,kasperskyPassword);

        logStep(3,"OPENING USER HOME PAGE...");
        MainUserPage mainUserPage = new MainUserPage();
        logStep(4,"SELECTINGT DOWNLOAD TAB...");
        mainUserPage.navigateBarMenu.clickNavigateMenuLabel(NavigateBarLabel.DOWNLOADS);

        logStep(5,"OPENING DOWNLOAD PRODUCT PAGE...");
        DownloadProductPage downloadProductPage = new DownloadProductPage();
        logStep(6,"SELECTING NECESSARY PRODUCT...");
        downloadProductPage.chooseOperatingSystem(downloadProductOs);
        downloadProductPage.chooseProduct(downloadProduct);
        logStep(7,"SENDING DOWNLOAD LINK ON EMAIL...");
        downloadProductPage.downloadProductForm.clickSendByEmailLink();
        downloadProductPage.sendByEmailForm.clickSendByEmailButton();
        logStep(8,"CHECKING SENT LETTER FOR PRESENCE OF CORRECT DOWNLOAD LINK...");
        assertNotNull(downloadProductPage.verifySendEmails(EMAIL_USERNAME,EMAIL_PASSWORD,INBOX_FOLDER,SUBJECT_NAME,REG_EXP), "ASSERT FAILED: 'Mail does not contain download link'");
    }

    @AfterClass
    public void tearDown(){
        MailFunctions.closeSession();
    }
}
