package framework;

import webdriver.utils.MailUtils;
import javax.mail.MessagingException;

public class MailFunctions {

    private static MailUtils mail;
    private static String folder;

    public String getMailText(String userName, String password, String folder, String subject){
        mail = new MailUtils(userName, password);
        mail.getStoreConnected();
        this.folder = folder;
        try {
            mail.waitForLetter(folder, subject);
        } catch (MessagingException e) {
            System.out.println("Letter has not found");
        }
        return mail.getMessageContent(folder, subject);
    }

    public static void closeSession(){
        mail.deleteAllMessages(folder);
        mail.closeStore();
    }
}
