import org.junit.Before;
import org.junit.Test;
import pages.*;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CreateAccountTest extends BaseWebDriverTest{

    home homepage;
    singin singInPage;
    accountcreation Account;

    @Before
    public void init(){
        homepage = new home(driver);
        singInPage = new singin(driver);
        Account = new accountcreation(driver);
        driver.get(homepage.BaseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepage.goToSingInPage();
    }

    @Test
    public void verifyAccountCreationPage(){
        Account.genarateMail(generateEmail());
        Account.goToCreateAccountPage();
        assertTrue(Account.isCreateAnAccountPageDisplayed());
        Account.enterAccountInformation();
        Account.submitAccount();
        assertTrue(Account.isMyAccountPageDisplayed());
    }
}
